package persistence;

import entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ran on 2/2/16.
 */
public class UserDaoWithHibernate implements UserDao {
    Session session;
    private final Logger log = Logger.getLogger(this.getClass());
    List<User> users;
    User user;

    @Override
    public List<User> getAllUsers() {
        users = new ArrayList<User>();
        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String hql = "FROM User";
        Query query = session.createQuery(hql);
        users = query.list();

        try {
                        tx = session.beginTransaction();
            tx.commit();
            log.fatal("Rows found: " + users.size());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return users;
    }

    public User selectUser(String name){
        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String hql = "FROM User " +
                     "WHERE name = '" + name + "'";
        Query query = session.createQuery(hql);
        user = (User)query.uniqueResult();
        try{
            tx = session.beginTransaction();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }


    @Override
    public void updateUser(User user) {

        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String hql = "UPDATE FROM User " +
                     "SET name = '" + user.getName() +"' " +
                     ",password = '" + user.getPassword() +"'" +
                     "WHERE id = " + user.getId();
        Query query = session.createQuery(hql);

        try {
            tx = session.beginTransaction();
            int result = query.executeUpdate();
            tx.commit();
            log.fatal("Rows updated: " + result);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(User user) {

        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String hql = "DELETE FROM User WHERE id = " + user.getId();
        Query query = session.createQuery(hql);

        try {
            tx = session.beginTransaction();
            int result = query.executeUpdate();
            tx.commit();
            log.fatal("Rows deleted: " + result);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public int addUser(User user) {

        log.trace("addUser()");

        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int userAdd = 0;
        try {
            tx = session.beginTransaction();
            userAdd = (int) session.save(user);
            tx.commit();
            log.fatal("Added user: " + user.getName() + " with id of: " + user.getId());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return userAdd;
    }
}
