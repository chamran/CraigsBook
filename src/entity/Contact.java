package entity;

/**
 * Created by user on 5/8/2016.
 */
public class Contact {

    private int contactId;
    private String bookTitle;
    private String listingMadeBy;
    private String listingWantedBy;
    private Integer listingId;

    /**
     * Instantiates a new Contact.
     */
    public Contact() {

    }

    /**
     * Instantiates a new Contact.
     *
     * @param bookTitle       the book title
     * @param listingMadeBy   the listing made by
     * @param listingWantedBy the listing wanted by
     * @param listingId       the listing id
     */
    public Contact(String bookTitle, String listingMadeBy, String listingWantedBy, int listingId) {
        this.bookTitle = bookTitle;
        this.listingMadeBy = listingMadeBy;
        this.listingWantedBy = listingWantedBy;
        this.listingId = listingId;
    }

    /**
     * Gets contact id.
     *
     * @return the contact id
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * Sets contact id.
     *
     * @param contactId the contact id
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /**
     * Gets book title.
     *
     * @return the book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Sets book title.
     *
     * @param bookTitle the book title
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Gets listing made by.
     *
     * @return the listing made by
     */
    public String getListingMadeBy() {
        return listingMadeBy;
    }

    /**
     * Sets listing made by.
     *
     * @param listingMadeBy the listing made by
     */
    public void setListingMadeBy(String listingMadeBy) {
        this.listingMadeBy = listingMadeBy;
    }

    /**
     * Gets listing wanted by.
     *
     * @return the listing wanted by
     */
    public String getListingWantedBy() {
        return listingWantedBy;
    }

    /**
     * Sets listing wanted by.
     *
     * @param listingWantedBy the listing wanted by
     */
    public void setListingWantedBy(String listingWantedBy) {
        this.listingWantedBy = listingWantedBy;
    }

    /**
     * Gets listing id.
     *
     * @return the listing id
     */
    public Integer getListingId() {
        return listingId;
    }

    /**
     * Sets listing id.
     *
     * @param listingId the listing id
     */
    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }
}
