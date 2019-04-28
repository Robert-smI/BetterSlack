package commands;

import java.time.LocalDateTime;

public class Message extends ChatCommand {

    private LocalDateTime timestamp;
    private String content;

    public Message() {
    }

    public static Message createNew(String content){
        return load (content,LocalDateTime.now());
    }

    public static Message load (String content, LocalDateTime timestamp){
        Message message = new Message();
        message.timestamp = timestamp;
        message.content = content;
        return message;
    }



    public String getContent() {
        return content;
    }
}
