package persistence;

import entity.Message;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MessageDaoTest {
    List<Message> messages;
    MessageDao dao;
    Message message;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        dao = new MessageDao();
        message = new Message("1", "ran", "test");

    }

    @Test
    public void testAddMessage() throws Exception {
        int messageId = dao.addMessage(message);
        assertTrue(messageId > 0);
    }

    @Test
    public  void testGetMessageById() throws Exception {
        messages = dao.getMessagesByContactId("1");
        assertTrue(messages.size() > 1);
        assertFalse(messages.size() < 2);
    }

}