package reece.code.ReeceCodeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBookDAO {

	private static List<Contact> addressBook;

	public AddressBookDAO() {
		addressBook = new ArrayList<Contact>();
	}

	public List<Contact> getAddressBook() {
		return addressBook;
	}

	public void addToAddressBook(Contact contact) {
		addressBook.add(contact);
	}

	public void removeFromAddressBook(Contact contact) {
		int position = 0;
		int positionToBeRemoved = 0;
		loop: for (Contact address : addressBook) {
			if (address.equals(contact)) {
				positionToBeRemoved = position;
				break loop;
			}
			position++;
		}
		addressBook.remove(positionToBeRemoved);
	}

	public List<Contact> printAddressBook() {
		System.out.println("----- Printing Unsorted Address Book -------");
		for (Contact address : addressBook) {
			System.out.println(address.getName() + " " + address.getPhone());
		}
		return addressBook;
	}

	public List<Contact> printSortedAddressBook(List<Contact> addressBook) {
		System.out.println("----- Printing Sorted Address Book -------");
		List<Contact> contacts = new ArrayList<Contact>();
		copyContacts(contacts, addressBook);   // make a copy of address book so that the original order will not change
		sort(contacts);
		for (Contact address : contacts) {
			System.out.println(address.getName() + " " + address.getPhone());
		}
		return contacts;
	}
    
	public List<Contact> printUniqueContacts(List<Contact> contacts) {
		List<Contact> ret = new ArrayList<Contact>();
		
		System.out.println("----- Printing Unique Contact From Address Book 1 -------");
		for (Contact address : contacts) {
			try {
				if (!addressBook.contains(address)) {
					System.out.println(address.getName() + " " + address.getPhone());
					ret.add(address);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		System.out.println("----- Printing Unique Contact From Address Book 2 -------");
		for (Contact address : this.addressBook) {
			try {
				if (!contacts.contains(address)) {
					System.out.println(address.getName() + " " + address.getPhone());
					ret.add(address);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		return ret;
	}

	private List<Contact> sort(List<Contact> contacts) {
		int n = contacts.size();
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (contacts.get(i).getName().compareTo(contacts.get(k).getName()) > 0) {
					// swap
					Contact temp = contacts.get(i);
					contacts.set(i, contacts.get(k));
					contacts.set(k, temp);
				}
			}

		}
		return contacts;

	}

	private static void copyContacts(List<Contact> destination, List<Contact> source) {
		for (Contact contact : source) {
			destination.add(contact);
		}
	}

}
