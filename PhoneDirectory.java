import java.util.ArrayList;
import java.util.Scanner;

public class phonedirectory {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        
        // Loop for taking user input
        while (true) {
            System.out.println("Enter a command (add, search, exit):");
            String command = scanner.nextLine();
            if (command.equals("add")) {
                System.out.println("Enter first name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter last name:");
                String lastName = scanner.nextLine();
                System.out.println("Enter phone number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter birth date (MM/DD/YYYY):");
                String birthDate = scanner.nextLine();
                Contact contact = new Contact(firstName, lastName, phoneNumber, birthDate);
                contacts.add(contact);
                System.out.println("Contact added.");
            } else if (command.equals("search")) {
                System.out.println("Enter search query:");
                String query = scanner.nextLine();
                ArrayList<Contact> searchResults = new ArrayList<Contact>();
                for (Contact contact : contacts) {
                    if (contact.matchesQuery(query)) {
                        searchResults.add(contact);
                    }
                }
                if (searchResults.size() == 0) {
                    System.out.println("No results found.");
                } else {
                    System.out.println("Search results:");
                    for (Contact contact : searchResults) {
                        System.out.println(contact);
                    }
                }
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
        
        scanner.close();
    }
    
}

class Contact {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthDate;
    
    public Contact(String firstName, String lastName, String phoneNumber, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }
    
    public boolean matchesQuery(String query) {
        return this.firstName.contains(query) ||
               this.lastName.contains(query) ||
               this.phoneNumber.contains(query) ||
               this.birthDate.contains(query);
    }
    
    public String toString() {
        return this.firstName + " " + this.lastName + " (" + this.phoneNumber + ", " + this.birthDate + ")";
    }
    
}
