import java.util.*;
/* Class Address Book to read contact details and displaying it
 * @param firstName to store first name of contact
 * @param lastName to store last name of contact
 * @param address to store address of contact
 * @param city to store city of contact
 * @param state to store state of contact
 * @param email to store email address of contact
 * @param zip to store ZIP of contact
 * @param phoneNumber to phone number name of contact
 * contact object created to store value of contacts
 * function readContactDetails to read contact details
 * function displayContactDetails to display contact details
 */
public class AddressBookMain 
{
	Scanner reader=new Scanner(System.in).useDelimiter("\n");
	public static String firstName,lastName,address,city,state,email,zip,phoneNumber;
	
	void readContactDetails()
	{
		System.out.println("Enter contact details:");
		System.out.print("First Name:");
		firstName=reader.next();
		System.out.print("Last Name:");
		lastName=reader.next();
		System.out.print("Address:");
		address=reader.next();
		System.out.print("City:");
		city=reader.next();
		System.out.print("State:");
		state=reader.next();
		System.out.print("Zip:");
		zip=reader.next();
		System.out.print("Email:");
		email=reader.next();
		System.out.print("Phone Number:");
		phoneNumber=reader.next();
	}
	
	void displayContactDetails(String firstName,String lastName,String address,String city,String state,String email,String zip,String phoneNumber)
	{
		System.out.println("Contact details are:");
		System.out.print("First Name:"+firstName);
		System.out.print("Last Name:"+lastName);
		System.out.print("Address:"+address);
		System.out.print("City:"+city);
		System.out.print("State:"+state);
		System.out.print("Zip:"+zip);
		System.out.print("Email:"+email);
		System.out.print("Phone Number:"+phoneNumber);

	}
	public static void main(String[] args) 
	{	
		System.out.println("Welcome to Address Book Program");
		
		AddressBookMain contact=new AddressBookMain();
		
		contact.readContactDetails();
		contact.displayContactDetails(firstName, lastName, address, city, state, email, zip, phoneNumber);
	}
	
}