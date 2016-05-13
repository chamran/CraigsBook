package persistence;

import entity.User;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by ran on 2/22/2016.
 */
public class UserDaoWithHibernateTest {
    List<User> list;
    UserDao dao;
    User user;


    @Test
    public void testGetAllUsers() throws Exception {
        dao = new UserDao();
        list = dao.getAllUsers();

        assertTrue(list.size() > 0);
    }

    @Test
    public void testUpdateUser() throws Exception {
        user = new User("rannn", "qqqqqqqq");
        dao = new UserDao();
        dao.addUser(user);
        user.setPassword("Q1w2e3r4");
        dao.updateUser(user);

        assertEquals("Q1w2e3r4", dao.selectUser("rannn").getPassword());
        dao.deleteUser(user);
    }

    @Test
    public void testSelectUser() throws Exception {
        dao = new UserDao();
        user = dao.selectUser("ran");

        assertEquals("ran", user.getName());
    }


    @Test
    public void testDeleteUser() throws Exception {
        dao = new UserDao();
        user = new User("Units", "supersecret");

        dao.addUser(user);
        assertEquals("Units", dao.selectUser("Units").getName());
        dao.deleteUser(user);
        assertEquals(null,  dao.selectUser("Units"));
    }

    @Test
    public void testAddUser() throws Exception {
        dao = new UserDao();
        int insertedUserId;
        //create user to add
        user = new User("hey", "now");
        insertedUserId = dao.addUser(user);

        assertTrue(insertedUserId > 0);
        dao.deleteUser(user);
    }
}