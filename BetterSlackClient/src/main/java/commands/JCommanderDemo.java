package commands;

import com.beust.jcommander.JCommander;
import commands.Login;

public class JCommanderDemo {


    public static void main(String[] args) {

        Login login = new Login();

        JCommander commander = JCommander.newBuilder()
                .addObject(login)
                .build();

        commander.usage();
        commander.parse(args);

        System.out.println(login.getUsername());
        System.out.println(login.getPassword());
    }

}
