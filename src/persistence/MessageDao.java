package persistence;

import entity.Listing;
import entity.Message;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/7/2016.
 */
public class MessageDao {

    private final Logger log = Logger.getLogger(this.getClass());



    public List<Message> getMessagesByContactId(String contactId) {
        log.info(contactId.getClass());
        List<Message> messages = new ArrayList<>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Message.class);

            criteria.add(Restrictions.eq("contactId", contactId));
            messages = criteria.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

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
