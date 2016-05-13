package entity;

/**
 * Created by user on 5/7/2016.
 */
public class Message {

    private int messageId;
    private String contactId;
    private String userName;
    private String userMessage;

    /**
     * Instantiates a new Message.
     */
    public Message() {

    }

    /**
     * Instantiates a new Message.
     *
     * @param contactId   the contact id
     * @param userName    the user name
     * @param userMessage the user message
     */
    public Message(String contactId, String userName, String userMessage) {
        this.contactId = contactId;
        this.userName = userName;
        this.userMessage = userMessage;
    }

    /**
     * Gets message id.
     *
     * @return the message id
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * Sets message id.
     *
     * @param messageId the message id
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets user message.
     *
     * @return the user message
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * Sets user message.
     *
     * @param userMessage the user message
     */
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
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
     * Gets contact id.
     *
     * @return the contact id
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Sets contact id.
     *
     * @param contactId the contact id
     */
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}