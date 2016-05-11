package persistence;

import entity.Listing;
import entity.Message;
import entity.MessageContact;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by user on 5/8/2016.
 */
public class MessageContactDao {
    Session session;
    private final Logger log = Logger.getLogger(this.getClass());

    List<MessageContact> messageContacts;
    MessageContact messageContact;

    public List<MessageContact> getAllMessageContactsId(int messageContactId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(MessageContact.class);
        criteria.add(Restrictions.eq("messageContactId", messageContactId));
        List messageContacts = criteria.list();
        return messageContacts;
    }

    public MessageContact getMessageContactById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (MessageContact)session.get(MessageContact.class, id);
    }

    public int addMessageContact(MessageContact messageContact) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer messageContactId = null;
        try {
            tx = session.beginTransaction();
            messageContactId = (Integer) session.save(messageContact);
            tx.commit();
            log.info("Added messageContact: " + messageContact + " with id of: " + messageContactId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return messageContactId;
    }
}
