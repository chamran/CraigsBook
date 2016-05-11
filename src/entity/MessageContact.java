package entity;

/**
 * Created by user on 5/8/2016.
 */
public class MessageContact {

    private int messageContactId;
    private String bookTitle;
    private String listingMadeBy;
    private String listingWantedBy;

    public int getMessageContactId() {
        return messageContactId;
    }

    public void setMessageContactId(int userContactId) {
        this.messageContactId = userContactId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getListingMadeBy() {
        return listingMadeBy;
    }

    public void setListingMadeBy(String listingMadeBy) {
        this.listingMadeBy = listingMadeBy;
    }

    public String getListingWantedBy() {
        return listingWantedBy;
    }

    public void setListingWantedBy(String listingWantedBy) {
        this.listingWantedBy = listingWantedBy;
    }

}
