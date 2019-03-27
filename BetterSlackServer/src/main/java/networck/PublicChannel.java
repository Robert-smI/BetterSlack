package networck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PublicChannel extends Channel {

    private List<ChatClient> channelClients = new ArrayList<>();

    public PublicChannel (String name){
        super(name);
    }

    @Override
    public void broadcast(ChatClient sender, String message) {
        List<ChatClient> recipients = channelClients.stream()
                .filter(client -> client != sender)
                .collect(Collectors.toList());
        recipients.forEach(recipienslClients -> recipienslClients.sendMessage(message));
    }

    @Override
    public void join(ChatClient client) {
        channelClients.add(client);
        System.out.println("New client has joined " + name + " channel");
        System.out.println("Clients in channel " + name + ": " + channelClients.size());
    }

    @Override
    public void leave(ChatClient client) {
        if(channelClients.contains(client)){
            channelClients.remove(client);
        }
        System.out.println("Client has left " + name + " channel");
        System.out.println("Clients in channel " + name + ": " + channelClients.size());
    }

}
