package networck;

import java.util.Objects;

public abstract class Channel {

   protected String name;

    public Channel(String name){
        this.name = name;
    }

    public abstract void broadcast(ChatClient sender, String message);
    public abstract void  join(ChatClient client);
    public abstract void  leave (ChatClient client);

    public String getName() {
        return name;
    }


    public void changeName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Channel)) return false;
        Channel channel = (Channel) o;
        return Objects.equals(name, channel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
