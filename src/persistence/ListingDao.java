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
        log.info(category+restrict);
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

    public void deleteListingById(String listingId){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Listing listing =
                    (Listing)session.get(Listing.class, Integer.parseInt(listingId));
            session.delete(listing);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Object addListing(Listing listing) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userAdd = null;
        try {
            tx = session.beginTransaction();
            userAdd = (Integer)session.save(listing);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return userAdd;
    }

}
