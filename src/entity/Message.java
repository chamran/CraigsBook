package entity;

/**
 * Created by user on 5/7/2016.
 */
public class Message {

    private int messageId;
    private int userContactId;
    private String userMessage;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserContactId() {
        return userContactId;
    }

    public void setUserContactId(int userContactId) {
        this.userContactId = userContactId;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}