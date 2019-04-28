package commands;

import com.beust.jcommander.Parameter;

public class ChangeUsername extends ChatCommand {

    @Parameter(names ={"-nn", "--newname"}, required = true)
    private String newUsername;
}
