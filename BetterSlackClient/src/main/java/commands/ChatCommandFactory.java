package commands;

public class ChatCommandFactory {

    public ChatCommand create(SupportedCommands commandType) {
        switch (commandType){
            case LOGIN:
                return new Login();
            case ADD_CHANNEL:
                return new AddChannel();
            case REGISTER:
                return new Register();
            case CHANGE_USERNAME:
                return new ChangeUsername();
            case JOIN_CHANNEL:
                return new JoinChannel();
            default:
                throw new IllegalStateException("Unrecognized command");
        }

    }
}
