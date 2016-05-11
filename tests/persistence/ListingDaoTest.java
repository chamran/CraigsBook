package persistence;

import entity.Listing;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Student on 5/4/2016.
 */
public class ListingDaoTest {

    private int insertedListingId;
    private Listing listing;
    ListingDao dao = new ListingDao();
    private final Logger log = Logger.getLogger(this.getClass());


    @Before
    public void setUp() {

        listing = new Listing();
        listing.setBookAuthor("Ran");
        listing.setListingId(1);
        listing.setCourse("java");
        listing.setInstructor("Alice");
        listing.setIsbn("084930315X");
        listing.setBookTitle("Java made easy");

    }

    @Test
    public void testGetListingsByQuery() throws Exception {
        List<Listing> listing = dao.getListingsByQuery("course", "java");
        log.info(listing.get(0).getInstructor());
    }

    @Test
    public void testAddListing() throws Exception {

        insertedListingId = dao.addListing(listing);
    }

    @Test
    public void testDeleteListing() {

        dao.deleteListing(listing);
        assertTrue(dao.getListingsByQuery("course", "java").size() == 0);

    }
}
