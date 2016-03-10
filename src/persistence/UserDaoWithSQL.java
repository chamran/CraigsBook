package persistence;

import entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 2/18/16.
 */


    //TODO: implement the UserDao interface - build out at least 2
    // of the methods to retrieve a list of all employees, add an employee, update
    // an employee or delete an employee. These methods should be built
    // using the Connection, Statement and ResultSet classes. Use this class an
    // example: https://github.com/MadJavaEntSpring2016/FatBikeTrailReports/blob/master/src/com/paulawaite/fbtr/persistence/UserDaoWithSql.java
    //
    // Note, the Database class in this package may help!

    //TODO: write at least one test for each method to make sure each method
    // works as expected. DO NOT create any main methods to run/test your
    // classes/methods.  Use this test class as an example: https://github.com/MadJavaEntSpring2016/FatBikeTrailReports/blob/master/tests/com/paulawaite/fbtr/persistence/UserDaoWithSqlTest.java


public class UserDaoWithSQL implements UserDao {
    List<User> users;
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<User> getAllUsers() {
        users = new ArrayList<User>();
        Database database = Database.getInstance();

        Connection connection = null;


        String sql = "select * from user order by id";
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            // iterate over the resultset, adding each user to the list
            while (results.next()) {
                User user = createUserFromResults(results);
                users.add(user);
            }
        } catch (SQLException e) {
            log.error("SQL Exception: ", e);
        } catch (Exception e) {
            log.error(e);
        }

        return users;
    }

    @Override
    public void updateUser(User user) {
        users = getAllUsers();
        users.get(user.getId()).setName(user.getName());
        users.get(user.getId()).setPassword(user.getPassword());
        log.trace("user: Id " + user.getId() + ", updated in the database");
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setId(results.getInt("id"));
        user.setName(results.getString("name"));
        user.setPassword(results.getString("password"));
        return user;
    }
}