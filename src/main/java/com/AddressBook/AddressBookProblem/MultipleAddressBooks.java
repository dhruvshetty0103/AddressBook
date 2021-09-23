package com.AddressBook.AddressBookProblem;
import java.util.*;

public class MultipleAddressBooks
{
	static String addressBookName;
	//to perform different operations on contacts
	public static void choice(int choice,AddressBookMain addressBookName)
	{
		switch(choice)
		{
		case 1:addressBookName.readContacts();				//add a new contact into address book
			   break;

		case 2:addressBookName.editContact();				//edit existing contact
			   break;

		case 3:addressBookName.deleteContact();				//delete the preferred contact
			   break;

		case 4:addressBookName.displayAddressBook();			//display whole address book
			   break;
		}

	}

	public static void main(String[] args)
	{
		Hashtable<String,AddressBookMain>  multipleAddressBook = new Hashtable<String, AddressBookMain>();
		AddressBookMain object=new AddressBookMain();  //First Address Book

		Scanner reader=new Scanner(System.in);
		System.out.println("Enter name for first address book");
		addressBookName=reader.nextLine();
		multipleAddressBook.put(addressBookName, object);
		int choice=1;
		while(choice!=6)
		{
			while(true) //it repeats till the user wants to end
			{
				System.out.println("Enter your choice\n"
						+ "1.Add Contact\n"
						+ "2.Edit Contact\n"
						+ "3.Delete Contact\n"
						+ "4.Display Address Book\n"
						+ "5.Create Another Address Book\n"
						+ "6.Search Person\n"
						+ "7.view person by state\n"
						+ "8.view person by city\n"
						+ "9.Exit"); //options for different actions
				choice=reader.nextInt();
				reader.nextLine();
				if(choice==5)  //to create a new address book
				{
					System.out.println("Enter the name of AddressBook to create");
					addressBookName = reader.nextLine();
					AddressBookMain object1=new AddressBookMain();  // a new address book object is created
					multipleAddressBook.put(addressBookName, object1);
				}
				else if(choice==6)
				{
				    System.out.println("Enter the name of city or state");
				    String place=reader.next();
				    System.out.println("Persons whose state or city is "+place);
				    for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
				    {
				        AddressBookMain object1=entry.getValue();
				        object1.search(place);
				    }
				      
				}
				//View person from a state
				else if(choice == 9)
				{
					System.out.println("Enter the name of state");
					String state=reader.next();
					System.out.println("Persons whose state "+state);
					for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
					{
						AddressBookMain object1=entry.getValue();
						object1.viewPersonByState(state);
					}

				}
				//View persons from a city
				else if(choice == 10)
				{
					System.out.println("Enter the name of city");
					String city=reader.next();
					System.out.println("Persons whose city "+city);
					for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
					{
						AddressBookMain object1=entry.getValue();
						object1.viewPersonByCity(city);
					}
				}
				
				else if(choice==9)				//to exit from the program
					System.exit(0);
				else
				{
					System.out.println("Enter the Name of AddressBook where you want to perform an activity!!");
					addressBookName=reader.nextLine();
					try 
					{
						choice(choice,multipleAddressBook.get(addressBookName));//to perform required operation on desired address book
					}
					catch(Exception e) 
					{
						System.out.println("Address book not found...create it first");

					}
				}
			}
		}
		reader.close();
	}
}
