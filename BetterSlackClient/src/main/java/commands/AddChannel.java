package commands;

import com.beust.jcommander.Parameter;

public class AddChannel extends ChatCommand {

    @Parameter(names ={"-chn", "--channelname"}, required = true)
    private String channelName;
    @Parameter(names = "--private")
    private boolean isPrivate;

}
