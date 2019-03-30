package sandbox;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Message {
    String content;
    LocalDateTime timestamp;

    /*
    used by framewroks
     */
    private Message (){

    }


    public Message(String content) {
        this.content = content;
        timestamp = LocalDateTime.now();
    }

    public Message(String content, LocalDateTime timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

//    public String getContent() {
//        return content;
//    }
//
//    public LocalDateTime getTimestamp() {
//        return timestamp;
//    }
}
