import models.PhoneBook;
import models.Contact;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
import java.util.ArrayList;


public class Main {

	public static String showMenu() {
		Scanner scan = new Scanner(System.in);
		String menu = """
		====== Agenda ======
		1- Criar contato
		2- Mostrar todos contatos
		3- Pesquisar contato
		4- Atualizar contato
		5- Deletar contato
		6- Sair
		""";

		System.out.println(menu);
		System.out.print("Opção: ");
		String opt = scan.nextLine();
		return opt;
	}

	public static int validateOption(String opt, int maxValue){
		int option;
		try {
			option = Integer.parseInt(opt);
		} catch (NumberFormatException error) {
			return -1;
		}
		if (option < 0 || option > maxValue) { return -1; }

		return option;
	}

	public static Contact createContact() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o nome do novo contato: ");
		String name = scan.nextLine();

		System.out.print("Digite o número do novo contato: ");
		String number = scan.nextLine();

		System.out.print("Digite a idade do novo contato: ");
		int age = scan.nextInt();

		System.out.print("Digite o endereço do novo contato: ");
		String address = scan.next();

		return new Contact(name, number, age, address);
	}

	public static Contact searchContact(PhoneBook phoneBook) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o nome: ");
		String name = scan.next();

		return phoneBook.getContactByName(name);
	}

	public static void handleOption(int opt, PhoneBook phoneBook) {
		Contact contact;

		switch (opt) {
			case 1:
				phoneBook.addContact(createContact());
				break;

			case 2:
				phoneBook.show();
				break;

			case 3:
				contact = searchContact(phoneBook);
				if (contact == null) {
					System.out.println("O número digitado não está na lista de contatos.");
					break;
				}
				System.out.println("Encontrei o contato, aqui estão os dados: ");
				System.out.println(contact.toString());
				break;

			case 4:
				contact = searchContact(phoneBook);
				if (contact == null) {
					System.out.println("O número digitado não está na lista de contatos.");
					break;
				}
				Contact newContact = createContact();
				phoneBook.updateContactByName(contact.getName(), newContact);
				break;

			case 5:
				contact = searchContact(phoneBook);
				if (contact == null) {
					System.out.println("O número digitado não está na lista de contatos.");
					break;
				}

				phoneBook.deleteContactByName(contact.getName());
				break;
		}
	}

	public static void main (String args[]) {
		PhoneBook phoneBook = new PhoneBook();
		int maxOption = 6;
		int option;

		do {
			String opt = showMenu();
			option = validateOption(opt, maxOption);
			handleOption(option, phoneBook);
		} while (option == -1 || option != maxOption);

	}
}
