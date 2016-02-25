package persistence;

import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/22/2016.
 */
public class UserDaoWithSQLTest {
    UserDaoWithSQL test;
    User user;
    @Test
    public void testGetAllUsers() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {
        test = new UserDaoWithSQL();
        user = new User("Yim", "1234");
        test.updateUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testAddUser() throws Exception {

    }
}