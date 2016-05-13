package persistence;

import entity.Contact;
import entity.Listing;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by user on 5/8/2016.
 */
public class ContactDao {

    private final Logger log = Logger.getLogger(this.getClass());


    public List<Contact> getMyContacts(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List contacts = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Contact.class);

            Criterion listingMadeBy = Restrictions.eq("listingMadeBy", userName);
            Criterion listingWantedBy = Restrictions.eq("listingWantedBy", userName);
            LogicalExpression orExp = Restrictions.or(listingMadeBy, listingWantedBy);
            criteria.add(orExp);

            contacts = criteria.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return contacts;

    }

    public void deleteContactById(String contactId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;log.info("deletecontactbyid..." +contactId );
        try{
            tx = session.beginTransaction();
            Contact contact = (Contact)session.get(Contact.class, Integer.parseInt(contactId));
            session.delete(contact);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Integer addContact(Contact contact) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer contactId = null;

        try {
            tx = session.beginTransaction();

            contactId = (Integer) session.save(contact);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close();
        }
        return contactId;
    }
}
