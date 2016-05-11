package persistence;

import entity.Listing;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 5/4/2016.
 */
public class ListingDao {
    Session session;
    private final Logger log = Logger.getLogger(this.getClass());


    public List<Listing> getListingsByQuery(String category, String restrict) {

        List<Listing> listings = new ArrayList<Listing>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Listing.class);
            // Add restriction.
            cr.add(Restrictions.eq(category, restrict));
            listings = cr.list();

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return listings;
    }

    public void deleteListing(Listing listing) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(listing);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    public int addListing(Listing listing) {
        log.info("addListing()");

        session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        int userAdd = 0;
        try {
            tx = session.beginTransaction();
            userAdd = (Integer) session.save(listing);
            tx.commit();
            log.info("Added book: " + listing.getBookTitle() + " with id of: " + listing.getListingId());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return userAdd;
    }

}
