package commands;

import com.beust.jcommander.Parameter;

public class ChangeUsername extends ChatCommand {

    @Parameter(required = true)
    private String newUsername;
}
