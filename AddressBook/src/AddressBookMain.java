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
 * array of contact object created to store value of multiple contacts
 * function readContactDetails to read contact details
 * function displayContactDetails to display contact details
 */
public class AddressBookMain 
{
	public String firstName=" ",lastName=" ",address=" ",city=" ",state=" ",email=" ",zip=" ",phoneNumber=" ";
	
	void readContactDetails(String firstName,String lastName,String address,String city,String state,String email,String zip,String phoneNumber)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.email=email;
		this.zip=zip;
		this.phoneNumber=phoneNumber;
	}
	
	void displayContactDetails(String firstName,String lastName,String address,String city,String state,String email,String zip,String phoneNumber)
	{
		System.out.println("Contact details are:");
		System.out.println("First Name:"+firstName);
		System.out.println("Last Name:"+lastName);
		System.out.print("Address:"+address);
		System.out.println("City:"+city);
		System.out.println("State:"+state);
		System.out.println("Zip:"+zip);
		System.out.println("Email:"+email);
		System.out.println("Phone Number:"+phoneNumber);
	}
	public static void main(String[] args) 
	{	
		System.out.println("Welcome to Address Book Program");
		System.out.println("Enter number of contacts to add in address book:");
		Scanner reader=new Scanner(System.in);
		Scanner reader1=new Scanner(System.in).useDelimiter("\n");//This delimiter used to avoid space as delimiter in address
		int totalContacts=reader.nextInt();
		String firstName="",lastName="",address="",city="",state="",email="",zip="",phoneNumber="";
		AddressBookMain [] contact=new AddressBookMain[10];
		for(int i=0;i<totalContacts;i++)
		{
			
			System.out.println("Enter contact details:");
			System.out.print("First Name:");
			firstName=reader.next();
			System.out.print("Last Name:");
			lastName=reader.next();
			System.out.print("Address:");
			address=reader1.next();
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
			
			contact[i]=new AddressBookMain();
			contact[i].readContactDetails(firstName, lastName, address, city, state, email, zip, phoneNumber);
		}
		reader.close();
		reader1.close();
		for(int i=0;i<totalContacts;i++)
		{
			contact[i].displayContactDetails(firstName, lastName, address, city, state, email, zip, phoneNumber);
		}
	}
}