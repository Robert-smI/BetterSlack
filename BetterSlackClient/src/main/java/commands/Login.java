package commands;

import com.beust.jcommander.Parameter;


public class Login extends ChatCommand {

    @Parameter(names = {"-u", "--username"}, description = "reads username", required = true)
    private String username;
    @Parameter(names = {"-p", "--password"}, description = "reads password", required = true, password = true)
    private String password;


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


}
