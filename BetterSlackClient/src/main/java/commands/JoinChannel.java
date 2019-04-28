package commands;

import com.beust.jcommander.Parameter;
import lombok.Getter;

@Getter
public class JoinChannel extends ChatCommand {

    @Parameter(names ={"-chn", "--channelname"},description = "reads channel name", required = true)
    private String channelName;


}
