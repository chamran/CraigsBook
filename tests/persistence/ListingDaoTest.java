package persistence;

import entity.Listing;
import org.apache.log4j.Logger;
import org.apache.log4j.pattern.IntegerPatternConverter;
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
    List<Listing> listingList;

    @Before
    public void setUp() {

        listing = new Listing();
        listing.setBookAuthor("Ran");
        listing.setListingId(1);
        listing.setCourse("java");
        listing.setInstructorFirstName("Alice");
        listing.setInstructorLastName("Bob");
        listing.setIsbn("084930315X");
        listing.setBookTitle("Java made easy");
        listing.setUserName("ran");
        listing.setPrice("30");

    }

    @Test
    public void testGetListingsByQuery() throws Exception {
        listingList= dao.getListingsByQuery("course", "java");
        assertTrue(listingList.size() > 0);
    }

    @Test
    public void testAddListing() throws Exception {

        insertedListingId = (int) dao.addListing(listing);
        assertTrue(insertedListingId > 0);
    }
}
