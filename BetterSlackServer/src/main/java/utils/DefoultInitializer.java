package utils;

import networck.ChannelRepository;
import networck.Channel;
import networck.PublicChannel;
import networck.settings.ChannelSettings;

public class DefoultInitializer implements BetterSlackInitializer {

    private final ChannelRepository channelrepository;


    public DefoultInitializer(ChannelRepository channelrepository) {
        this.channelrepository = channelrepository;
    }

    @Override
    public void initialize() {
        Channel general = new PublicChannel(ChannelSettings.DEFAULT_CHANNEL_NAME);
        channelrepository.add(general);
    }
}
