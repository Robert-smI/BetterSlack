import org.junit.Before;
import org.junit.Test;
import users.User;

public class UserTest {

    User user;

@Before
public void before(){
    user = new User("adam", "password");
}


@Test(expected = IllegalArgumentException.class)
public void illegalSizeUserNameChanged () {
    String newName = "";
        user.changeUserName(newName);
}


}
