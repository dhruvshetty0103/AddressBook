package com.AddressBook.AddressBookProblem;
import java.util.ArrayList;
import java.util.Scanner;
/* Class Address Book to read contact details and displaying it
 * @param firstName to store first name of contact
 * @param lastName to store last name of contact
 * @param address to store address of contact
 * @param city to store city of contact
 * @param state to store state of contact
 * @param email to store email address of contact
 * @param zip to store ZIP of contact
 * @param phoneNumber to phone number name of contact
 */
public class AddressBookMain
{
	//collection class array list is used to store different contacts in address book
	public  ArrayList<AddressBookMain> contact=new ArrayList<AddressBookMain>();
	public String firstName,lastName,address,city,state,email,zip,phoneNumber;
	Scanner reader=new Scanner(System.in);
	int i=0,totalContacts=0,choice=1;

	public AddressBookMain()
	{
		System.out.println("Welcome to Address Book Program");
	}

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
	//function readContactDetails to read contact details
	void readContacts()
	{
		System.out.println("Enter contact details:"+(totalContacts+1));
		System.out.print("First Name:");
		firstName=reader.nextLine();
		System.out.print("Last Name:");
		if(duplicateCheck(firstName)==false)
		{
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

			contact.add(new AddressBookMain(firstName, lastName, address, city, state, email, zip, phoneNumber));
			totalContacts++;
		}
		
	}

	//function editContact to edit contact details
	void editContact()
	{
		System.out.println("Enter contact number to edit it's detail");
		   int contactNumber=reader.nextInt();
		   contactNumber-=1;
		   System.out.println("Enter field to be edited:\n1.First Name\n2.Last Name\n3.Address\n4.City\n"
		   		+ "5.State\n6.Email\n7.Zip\n8.PhoneNumber");
		   int field=reader.nextInt();
		   reader.nextLine();
		   //while editing it asks which field to be edited and displays the updated contact
		   switch(field)
		   {
		   	case 1:System.out.println("Enter new First name");
		   		   contact.get(contactNumber).firstName=reader.nextLine();
		   		   break;
		   	case 2:System.out.println("Enter new Last name");
		   		   contact.get(contactNumber).lastName=reader.nextLine();
		   		   break;
		   	case 3:System.out.println("Enter new Address");
			       contact.get(contactNumber).address=reader.nextLine();
			       break;
		   	case 4:System.out.println("Enter new City name");
			       contact.get(contactNumber).city=reader.nextLine();
			       break;
		   	case 5:System.out.println("Enter new City name");
		   		   contact.get(contactNumber).state=reader.nextLine();
			       break;
		   	case 6:System.out.println("Enter new Email address");
		           contact.get(contactNumber).email=reader.nextLine();
			       break;
			case 7:System.out.println("Enter new ZIP code");
		           contact.get(contactNumber).zip=reader.nextLine();
				   break;
		   	case 8:System.out.println("Enter new Phone number");
		   		   contact.get(contactNumber).phoneNumber=reader.nextLine();
		           break;
			default:System.out.println("Enter a valid field");
		   			break;
		   }
		   System.out.print("Updated ");
		   contact.get(contactNumber).displayContactDetails();
	}

	//function displayContactDetails to display contact details
	void displayContactDetails()
	{
		System.out.println("First Name:"+firstName);
		System.out.println("Last Name:"+lastName);
		System.out.println("Address:"+address);
		System.out.println("City:"+city);
		System.out.println("State:"+state);
		System.out.println("Zip:"+zip);
		System.out.println("Email:"+email);
		System.out.println("Phone Number:"+phoneNumber);
	}
	
		
	void displayAddressBook()
	{
		if(totalContacts==0)//if no contacts exists
		   	   System.out.println("No contacts to display");
		else
		{
			for(i=0;i<totalContacts;i++)
			{
				System.out.println("Contact detail of:"+(i+1));
	    		System.out.println("First Name:"+contact.get(i).firstName);
	    		System.out.println("Last Name:"+contact.get(i).lastName);
	    		System.out.println("Address:"+contact.get(i).address);
	    		System.out.println("City:"+contact.get(i).city);
	    		System.out.println("State:"+contact.get(i).state);
	    		System.out.println("Zip:"+contact.get(i).zip);
	    		System.out.println("Email:"+contact.get(i).email);
	    		System.out.println("Phone Number:"+contact.get(i).phoneNumber);
	    	}
		}
	}

	void deleteContact()
	{
		if(totalContacts==0)
		{
			System.out.println("There are no contacts to delete");
		}
		else
		{
			System.out.println("Enter new First name");
			String deleteName=reader.nextLine();
			for(i=0;i<totalContacts;i++)
			{
				if(deleteName.compareTo(contact.get(i).firstName)==0)
				{
					System.out.println("Deleted Contact:");
					contact.get(i).displayContactDetails();
					contact.remove(i);//this is to remove the object from the list
					totalContacts--;
				}
				else
					System.out.println("Enter First Name that exists in the record");
	   		   }
		}
	}
	
	//method to check for duplicate first name
	public Boolean duplicateCheck(String name)
	{
		for (int j=0;j<contact.size();j++)
		{   
			AddressBookMain object=contact.get(j);
			if(object.firstName.equals(name))
			{
				System.out.println("Contact already exists!!Please enter a different contact name"); 
				return true;
			}
		}
			return false;
	}

	/* Method to search a particular contact based on city or state
	 */
    public void search(String place) 
    {
        for (int j=0;j<contact.size();j++)
        {   
            AddressBookMain object=contact.get(j);
            if(object.city.equals(place)||object.state.equals(place))
            {
                System.out.println(object.firstName+" "+object.lastName);  
            }
        }    
    }
	
}
