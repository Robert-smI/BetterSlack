import org.junit.Before;
import org.junit.*;
import users.InMemoryUserDatabase;
import users.User;

import java.util.Optional;

import static org.junit.Assert.*;



public class InMemoryDatabaseTest {
    InMemoryUserDatabase inMemoryUserDatabase;
    User user;


    @Before
    public void before() {
        inMemoryUserDatabase = new InMemoryUserDatabase();
        user = new User("adam", "password");
    }


    @Test
    public void initialDatabaseSizeTest() {
        //Given
        int size = inMemoryUserDatabase.getUsersCount();
        // When
        //Then
        assertEquals(0, size);
    }

    @Test
    public void addedUserTest() {
        // Given
        int exceptedSize = inMemoryUserDatabase.getUsersCount() + 1;
        // When
        inMemoryUserDatabase.addUser(user);
        // Then
        assertEquals(exceptedSize, inMemoryUserDatabase.getUsersCount());
    }

    @Test
    public void addedUserNegativeTest() {
        // Given
        int exceptedSize = inMemoryUserDatabase.getUsersCount();
        // When
        inMemoryUserDatabase.addUser(user);
        // Then
        assertNotEquals(exceptedSize, inMemoryUserDatabase.getUsersCount());
    }
//    @Test
//    public void addUserNullTest (){
//        // Given
//        int exceptedSize = inMemoryUserDatabase.getUsersCount();
//        // When
//        inMemoryUserDatabase.addUser(null);
//        // Then
//        assertEquals(exceptedSize, inMemoryUserDatabase.getUsersCount());
//    }
    @Test
    public void findByNameTest (){
        // Given
           inMemoryUserDatabase.addUser(user);
           String exceptedname = user.getUsername();
        // When
            Optional<User> returnedUser = inMemoryUserDatabase.find(user.getUsername());
        // Then
          //  assertEquals(user.getUsername(), returnedUser.filter(u->u.getUsername().equals("adam")));
            assertEquals(exceptedname, returnedUser.get().getUsername());
    }
    @Test
    public void findByNameNegativeTest (){
        // Given
        inMemoryUserDatabase.addUser(user);
        // When
        Optional<User> returnedUser = inMemoryUserDatabase.find(user.getUsername());
        // Then
        //  assertEquals(user.getUsername(), returnedUser.filter(u->u.getUsername().equals("adam")));
        assertNotEquals(" ", returnedUser.get().getUsername());
    }



}

