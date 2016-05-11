package persistence;

import entity.Listing;
import entity.Message;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by user on 5/7/2016.
 */
public class MessageDao {
    Session session;
    private final Logger log = Logger.getLogger(this.getClass());

    List<Message> messages;
    Message message;

    public List<Message> getAllMessagesById(int listingId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("listingId", listingId));
        List messages = criteria.list();
        return messages;
    }

    public int addMessage(Message message) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer messageId = null;
        try {
            tx = session.beginTransaction();
            messageId = (Integer) session.save(message);
            tx.commit();
            log.info("Added message: " + message + " with id of: " + messageId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return messageId;
    }
}
