package models;

import models.Contact;
import java.util.ArrayList;

public class PhoneBook{

	private ArrayList<Contact> contacts;

	public PhoneBook() {
		this.contacts = new ArrayList<Contact>();
	}

	// Create
	public void addContact(Contact newContact) {
		this.contacts.forEach((contact) -> {
			if (contact.getPhone().equals(newContact)){
				System.out.println("Um usuário com esse número já existe!");
				return;
			}
		});

		this.contacts.add(newContact);
	}

	// Read
	public ArrayList<Contact> getAllContacts(){return this.contacts;}

	public Contact getContactByName(String name) {
		return this.contacts.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
	}

	// Update
	public void updateContacts(ArrayList<Contact> contacts) {this.contacts = contacts;}

	public void updateContactByName(String name, Contact newContact) {
		Contact cont = this.contacts.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
		this.contacts.set(this.contacts.indexOf(cont), newContact);
	}

	// Delete
	public void deleteAllContacts() {this.contacts.clear();}

	public boolean deleteContactByName(String name) {
		return this.contacts.removeIf(c -> c.getName().equals(name));
	}


	// View
	public void show() {
		this.contacts.forEach((contact) -> {
			System.out.println(contact.toString());
		});
	}
}
