import java.util.*;

class Contact {
    private String name;
    private String phoneNum;
    private String email;

    public Contact(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNum;
    }

    public String getEmailAddress() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNum + ", Email : " + email;
    }
}

class PhoneBook {
    private Map<String, Contact> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getName(), contact);
        System.out.println("\nContact added: " + contact.getName());
    }

    public void removeContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("\nContact removed: " + name);
        } else {
            System.out.println("\nContact not found.");
        }
    }

    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            Contact contact = contacts.get(name);
            System.out.println("\nContact details:\n" + contact);
        } else {
            System.out.println("\nContact not found.");
        }
    }
}

public class PhoneBookApp {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nPhone Book Application");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = sc.nextLine();

                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    phoneBook.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter contact name to remove: ");
                    String removeName = sc.nextLine();
                    phoneBook.removeContact(removeName);
                    break;
                case 3:
                    System.out.print("Enter contact name to search: ");
                    String searchName = sc.nextLine();
                    phoneBook.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
