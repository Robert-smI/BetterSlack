package commands;

import com.beust.jcommander.JCommander;
import commands.Login;

public class JCommanderDemo {


    public static void main(String[] args) {

        Login login = new Login();
        JoinChannel joinChannel = new JoinChannel();

        JCommander commander = JCommander.newBuilder()
                .addObject(login)
                .build();

        commander.usage();
        commander.parse(args);

//        JCommander commander1 = JCommander.newBuilder()
//                .addObject(joinChannel)
//                .build();
//        commander1.usage();
//        commander1.parse(args);


        System.out.println(login.getUsername());
        System.out.println(login.getPassword());

//        System.out.println(joinChannel.getChannelName());

    }

}
