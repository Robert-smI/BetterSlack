import com.beust.jcommander.JCommander;
import commands.ChatCommand;
import commands.ChatCommandFactory;
import commands.Message;
import commands.SupportedCommands;
import exeption.EmptyMessageExeption;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputProvider implements UserInputProvider {

    private final Scanner scanner = new Scanner(System.in);
    private final String username;
    private final ChatCommandFactory chatCommandFactory = new ChatCommandFactory();

    public ConsoleInputProvider() {
        String tempname;
        System.out.println("Hello !");
        while (true) {
            System.out.println("Enter username: ");
            tempname = scanner.nextLine();
            if (!ifUsernameValid(tempname)) {
                System.out.println("username must have between "
                        + UserSettings.MIN_USERNAME_LENGTH +  " and "
                        + UserSettings.MAX_USERNAME_LENGTH + " characters from a to Z / 0 to 9");
            }

            if (ifUsernameValid(tempname)) {
                break;
            }
        }
        username = tempname;
        System.out.println("Your username: " + username + " welcome !");
    }


    private static boolean ifUsernameValid(String username) {
        return !username.isEmpty() && username.length() >= UserSettings.MIN_USERNAME_LENGTH
                && username.length() <= UserSettings.MAX_USERNAME_LENGTH
                && username.matches(UserSettings.USERNAME_PATTERN);
    }


    @Override
    public ChatCommand getUserInput() {
        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            throw new EmptyMessageExeption();
        }
        if (isCommand(input)) {
            String commandString = input.contains(" ") ?
                    input.split(" ")[0] : input;

            SupportedCommands commandType = SupportedCommands.fromString(commandString);
            ChatCommand command = chatCommandFactory.create(commandType);

            if (input.contains(" ")) {
                String[] arguments = input.split(" ");
                JCommander.newBuilder()
                        .addObject(command)
                        .build()
                        .parse(Arrays.copyOfRange(arguments, 1, arguments.length ));
            }
            return command;
        }
        return Message.createNew(input);
    }


    private static boolean isCommand(String input) {
        String trimedInput = input.trim();
        String regex = !trimedInput.contains(" ") ? "^\\/[a-z]+$" : "^\\/[a-z]+\\s+\\S+";
        return trimedInput.matches(regex);
    }

    //  outdated method replaced by getUserInput
    public String getUserInputSimple (){
        return String.format("%s: %s", username, scanner.nextLine());
    }


}


