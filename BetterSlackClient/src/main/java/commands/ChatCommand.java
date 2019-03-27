package commands;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class ChatCommand {
    protected String sender;

    protected ChatCommand() {
        try {
            sender = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new IllegalStateException("could not create command don't have connect");
        }
    }

    public String getSender() {
        return sender;
    }
}
