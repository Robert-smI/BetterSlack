package commands;

import com.beust.jcommander.Parameter;

public class JoinChannel extends ChatCommand {

    @Parameter(required = true)
    private String channelName;


}
