package reece.code.ReeceCodeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class AddressBookDAOTest {

	@Test
	public void testGetAddressBook() {
		AddressBookDAO dao = new AddressBookDAO();
		List<Contact> addressBook1 = dao.getAddressBook();
		Contact contact = new Contact("Juan Dela Cruz", "02-547923");
		dao.addToAddressBook(contact);
		List<Contact> addressBook2 = dao.getAddressBook();
		assertEquals(addressBook2.size(), 1);

	}

	@Test
	public void testAddToAddressBook() {
		AddressBookDAO dao = new AddressBookDAO();
		List<Contact> addressBook = dao.getAddressBook();
		Contact contact = new Contact("Juan Dela Cruz", "02-547923");
		dao.addToAddressBook(contact);
		assertEquals(addressBook.get(0).getName(), "Juan Dela Cruz");
		assertEquals(addressBook.get(0).getPhone(), "02-547923");
	}

	@Test
	public void testRemoveFromAddressBook() {
		AddressBookDAO dao = new AddressBookDAO();
		List<Contact> addressBook = dao.getAddressBook();
		Contact contact = new Contact("Juan Dela Cruz", "02-547923");
		dao.addToAddressBook(contact);
		assertEquals(addressBook.size(), 1);
		dao.removeFromAddressBook(contact);
		assertEquals(addressBook.size(), 0);
	}

	@Test
	public void testPrintAddressBook() {
		AddressBookDAO dao = new AddressBookDAO();
		List<Contact> addressBook = dao.getAddressBook();
		Contact contact = new Contact("Juan Dela Cruz", "02-547923");
		dao.addToAddressBook(contact);
		contact = new Contact("Abby Jones", "02-4556678");
		dao.addToAddressBook(contact);
		contact = new Contact("Zooey Deschanel", "02-4523678");
		dao.addToAddressBook(contact);
		List<Contact> test = dao.printSortedAddressBook(addressBook);
		assertTrue(test.get(0).getName().compareTo(test.get(1).getName()) < 0);
		assertTrue(test.get(1).getName().compareTo(test.get(2).getName()) < 0);
		dao.printAddressBook();
	}

	@Test
	public void testPrintUniqueContacts() {
		AddressBookDAO dao = new AddressBookDAO();
		List<Contact> addressBook1 = dao.getAddressBook();
		Contact contact = new Contact("Juan Dela Cruz", "02-547923");
		dao.addToAddressBook(contact);
		contact = new Contact("Abby Jones", "02-4556678");
		dao.addToAddressBook(contact);
		contact = new Contact("Zooey Deschanel", "02-4523678");
		dao.addToAddressBook(contact);

		AddressBookDAO dao2 = new AddressBookDAO();

		contact = new Contact("Juan Dela Cruz", "02-547923");
		dao2.addToAddressBook(contact);
		contact = new Contact("Stephen Curry", "02-4556678");
		dao2.addToAddressBook(contact);
		contact = new Contact("Conor McGregor", "02-4523678");
		dao2.addToAddressBook(contact);

		List<Contact> test = dao2.printUniqueContacts(addressBook1);
		assertEquals(test.size(), 4);

	}

}
