package persistence;

import entity.Contact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 5/1/2016.
 */
public class ContactDaoTest {
    Contact contact;
    ContactDao dao;

    @Before
    public void setUp() {
        contact = new Contact("java", "ran", "you", 33);
        contact.setContactId(33);
        dao = new ContactDao();

    }

    @Test
    public void testAddContact() throws  Exception {
        Integer contactAdded = dao.addContact(contact);
        assertTrue(contactAdded > 0);
    }

    @Test
    public void testDeleteContact() throws Exception {
        Integer contactAdded = dao.addContact(contact);
        dao.deleteContactById("33");
    }
}
