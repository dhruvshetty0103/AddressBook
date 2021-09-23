package com.AddressBook.AddressBookProblem;

import java.util.Hashtable;
import java.util.Scanner;
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
		reader.nextLine();
		int choice=1;
		while(choice!=6)
		{
			while(true) //it repeats till the user wants to end
			{
				System.out.println("Enter your choice\n1.Add Contact\n2.Edit Contact\n3.Delete Contact\n4.Display Address Book\n"
						+ "5.Create Another Address Book\n6.Exit"); //options for different actions
				choice=reader.nextInt();
				reader.nextLine();
				if(choice==5)  //to create a new address book
				{
					System.out.println("Enter the name of AddressBook to create");
					addressBookName = reader.nextLine();
					AddressBookMain object1=new AddressBookMain();  // a new address book object is created
					multipleAddressBook.put(addressBookName, object1);
				}
				else if(choice==6)				//to exist from the program
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
