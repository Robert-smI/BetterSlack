package networck;

import java.util.Collection;
import java.util.Optional;

public interface ChannelRepository {

    void add(Channel channel);
    Collection<Channel> getAll();
    Optional<Channel> findByName(String name);
}
