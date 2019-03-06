
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter


public class User {
    public static final int MIN_USERNAME_LENGTH = 3;
    public static final int MAX_USERNAME_LENGTH = 20;
    private String username;
    private String password;
    private UUID id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;


    public User(String username, String password) {

        id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        createAt = LocalDateTime.now();
        updateAt = createAt;
    }


    public void changeUserName(String name) {
        if (!isUsernameValid(name)) {
            throw new IllegalArgumentException(username + " Valid username should have between "
                    + MIN_USERNAME_LENGTH + "and "
                    + MAX_USERNAME_LENGTH + " sign");
        }
        this.username = name;
        upDate();
    }

    public static boolean isUsernameValid(String name) {
        return name != null &&
                name.length() >= MIN_USERNAME_LENGTH &&
                name.length() <= MAX_USERNAME_LENGTH;
    }

    private void upDate() {
        updateAt = LocalDateTime.now();
    }


}
