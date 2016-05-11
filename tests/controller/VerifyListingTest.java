package controller;


import entity.Book;
import entity.Listing;
import org.junit.Test;
import org.apache.log4j.*;

/**
 * Created by Student on 4/26/2016.
 */
public class VerifyListingTest {
    VerifyListing isbndb;
    Book book;
    Listing listing;

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testGetBookData() throws Exception {

        /*isbndb = new VerifyListing();
        listing = new Listing(isbndb.setBook(), "Alice", "Java", 12345, "ran");

        book = isbndb.setBook();
        List<BookData> list = book.getData();
        BookData data = list.get(0);
        List<AuthorData> authorDataList = data.getAuthorData();
        AuthorData authorData = authorDataList.get(0);
        log.fatal(listing.getInstructor());*/
    }
}
