import java.util.ArrayList;
import java.util.Scanner;
class Contact {
    String name;
    String phone;
    String email;
    Contact(String name,String phone,String email) 
    {
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
    void display() 
    {
        System.out.println("Name  : "+name);
        System.out.println("Phone : "+ phone);
        System.out.println("Email : "+email);
        System.out.println();
    }
}
public class ContactManagementSystem 
{

    static ArrayList<Contact> contacts=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) 
    {
        int choice;
        do 
        {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice!=5);
    }
    static void addContact() 
    {
        System.out.print("Enter Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone=sc.nextLine();
        System.out.print("Enter Email: ");
        String email=sc.nextLine();
        contacts.add(new Contact(name,phone,email));
        System.out.println("Contact added successfully!");
    }
    static void viewContacts() 
    {
        if (contacts.isEmpty()) 
        {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\nContact List");
        for (Contact c:contacts) 
        {
            c.display();
        }
    }
    static void updateContact() 
    {
        System.out.print("Enter name of contact to update: ");
        String name=sc.nextLine();
        for (Contact c:contacts) 
        {
            if (c.name.equalsIgnoreCase(name)) 
            {

                System.out.print("Enter new phone: ");
                c.phone=sc.nextLine();
                System.out.print("Enter new email: ");
                c.email=sc.nextLine();
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    static void deleteContact() 
    {
        System.out.print("Enter name of contact to delete: ");
        String name=sc.nextLine();
        for (Contact c:contacts) 
        {
            if (c.name.equalsIgnoreCase(name)) 
            {
                contacts.remove(c);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
