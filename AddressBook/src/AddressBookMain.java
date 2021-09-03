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
 * switch case menu options for user to decide whether to enter,edit or display contacts
 * and while editing it asks which field to be edited and displays the updated contact
 */
public class AddressBookMain 
{
	private String firstName,lastName,address,city,state,email,zip,phoneNumber;
	
	public AddressBookMain(String firstName,String lastName,String address,String city,String state,String email,String zip,String phoneNumber)
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
	
	void displayContactDetails()
	{
		System.out.println("Contact details are:");
		System.out.println("First Name:"+firstName);
		System.out.println("Last Name:"+lastName);
		System.out.println("Address:"+address);
		System.out.println("City:"+city);
		System.out.println("State:"+state);
		System.out.println("Zip:"+zip);
		System.out.println("Email:"+email);
		System.out.println("Phone Number:"+phoneNumber);
	}
	public static void main(String[] args) 
	{	
		System.out.println("Welcome to Address Book Program");
		Scanner reader=new Scanner(System.in);
		int i=0,totalContacts=0,choice=1;
		String firstName="",lastName="",address="",city="",state="",email="",zip="",phoneNumber="";
		AddressBookMain [] contact=new AddressBookMain[10];
		while(choice!=4)
		{
			System.out.println("Enter choice to\n1.Enter Contact\n2.Edit Contact\n3.Display Contacts\n4.Delete\n5.Exit");
			choice=reader.nextInt();
			reader.nextLine();
			switch(choice)
			{
				case 1:if(i<10)
					   {
					   		System.out.println("Enter contact details:"+(i+1));
					   		System.out.print("First Name:");
					   		firstName=reader.nextLine();
					   		System.out.print("Last Name:");
					   		lastName=reader.nextLine();
					   		System.out.print("Address:");
					   		address=reader.nextLine();
					   		System.out.print("City:");
					   		city=reader.nextLine();
					   		System.out.print("State:");
					   		state=reader.nextLine();
					   		System.out.print("Zip:");
					   		zip=reader.nextLine();
					   		System.out.print("Email:");
					   		email=reader.nextLine();
					   		System.out.print("Phone Number:");
					   		phoneNumber=reader.nextLine();
				
					   		contact[i]=new AddressBookMain(firstName, lastName, address, city, state, email, zip, phoneNumber);
					   		i++;
					   		totalContacts++;
					   }
					   break;
				case 2:System.out.println("Enter contact number to edit it's detail");
					   int contactNumber=reader.nextInt();
					   contactNumber-=1;
					   System.out.println("Enter field to be edited:\n1.First Name\n2.Last Name\n3.Address\n4.City\n"
					   		+ "5.State\n6.Email\n7.Zip\n8.PhoneNumber");
					   int field=reader.nextInt();
					   reader.nextLine();
					   switch(field)
					   {
					   	case 1:System.out.println("Enter new First name");
					   		   contact[contactNumber].firstName=reader.nextLine();
					   		   break;
					   	case 2:System.out.println("Enter new Last name");
					   		   contact[contactNumber].lastName=reader.nextLine();
					   		   break;
					   	case 3:System.out.println("Enter new Address");
						       contact[contactNumber].address=reader.nextLine();
						       break;
					   	case 4:System.out.println("Enter new City name");
						       contact[contactNumber].city=reader.nextLine();
						       break;
					   	case 5:System.out.println("Enter new City name");
						       contact[contactNumber].state=reader.nextLine();
						       break;
					   	case 6:System.out.println("Enter new Email address");
						       contact[contactNumber].email=reader.nextLine();
						       break;
					   	case 7:System.out.println("Enter new ZIP code");
						      contact[contactNumber].zip=reader.nextLine();
						      break;
					   	case 8:System.out.println("Enter new Phone number");
					   		   contact[contactNumber].phoneNumber=reader.nextLine();
						       break;
					   	default:System.out.println("Enter a valid field");
					   			break;
					   }
					   System.out.print("Updated ");
					   contact[contactNumber].displayContactDetails();
					   break;
				case 3:for(i=0;i<totalContacts;i++)
					   {
							System.out.println("Contact detail of:"+(i+1));
							contact[i].displayContactDetails();
					   }
					   break;
				case 4:
				default:System.exit(0);
			}
		}
		
		reader.close();
	}
}