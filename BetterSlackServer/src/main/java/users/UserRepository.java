package users;

import java.util.Optional;

public interface UserRepository {

    void addUser(User user);
    Optional<User> find (String username);
}
