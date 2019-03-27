import networck.*;
import utils.BetterSlackInitializer;
import utils.DefoultInitializer;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        ChannelRepository channelRepository = new InMemoryChannelRepository();
        BetterSlackInitializer initializer = new DefoultInitializer(channelRepository);
        initializer.initialize();
        Collection<Channel> channel =  channelRepository.getAll();
        ChatServer server = new TcpChatServer(channelRepository);

        server.start(50000);
    }


}
