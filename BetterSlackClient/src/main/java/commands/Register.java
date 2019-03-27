package commands;

import com.beust.jcommander.Parameter;
//import jdk.nashorn.internal.objects.annotations.Getter;


public class Register extends ChatCommand  {

    @Parameter(names = {"-u", "--username"}, description = "reads username", required = true)
    private String username;
    @Parameter(names = {"-p", "--password"}, description = "reads password", required = true, password = true)
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
