package entity;

/**
 * The type Listing.
 */
public class Listing {

    private int listingId;
    private String instructor;
    private String course;
    private String bookTitle;
    private String bookAuthor;
    private String isbn;
    private String userName;
    private String price;
    private Boolean resultsFound;

    /**
     * Instantiates a new Listing.
     */
    public Listing() {

    }

    /**
     * Instantiates a new Listing.
     *
     * @param book       the book
     * @param instructor the instructor
     * @param course     the course
     * @param isbn       the isbn
     * @param userName   the user name
     * @param price      the price
     */
    public Listing(Book book, String instructor, String course, String isbn, String userName, String price) {
        this.bookTitle = book.getData().get(0).getTitle();
        this.bookAuthor = book.getData().get(0).getAuthorData().get(0).getName();
        this.instructor = instructor;
        this.course = course;
        this.isbn = isbn;
        this.userName = userName;
        this.price = price;
    }

    /**
     * Gets listing id.
     *
     * @return the listing id
     */
    public int getListingId() {
        return listingId;
    }

    /**
     * Sets listing id.
     *
     * @param bookId the book id
     */
    public void setListingId(int bookId) {
        this.listingId = bookId;
    }

    /**
     * Gets instructor.
     *
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Sets instructor.
     *
     * @param instructor the instructor
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * Gets course.
     *
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets course.
     *
     * @param course the course
     */
    public void setCourse(String course) {
        this.course = course;
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
     * Gets book author.
     *
     * @return the book author
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * Sets book author.
     *
     * @param author the author
     */
    public void setBookAuthor(String author) {
        this.bookAuthor = author;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets results found.
     *
     * @return the results found
     */
    public Boolean getResultsFound() {
        return resultsFound;
    }

    /**
     * Sets results found.
     *
     * @param resultsFound the results found
     */
    public void setResultsFound(Boolean resultsFound) {
        this.resultsFound = resultsFound;
    }
}
