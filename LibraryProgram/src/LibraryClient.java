/*
 * Zach Kehs
 * CS221 Project: Library Client
 */
import java.util.Scanner;

public class Library_Client
{
	public static void main(String [] args)
	{
		int userinput, usercount = 0;
		String username, password;
		int logged_user = 0;
		
		Scanner input = new Scanner(System.in);
		
		//because there are no users to start with , require that a librarian is made
		System.out.println("--LIBRARY SYSTEM STARTING--");
		System.out.print("\nInitial librarian required. Please enter the librarian Username: ");
		
		//read this in with scanner
		username = input.nextLine();
		
		System.out.println("\nPlease enter the initial password: ");
		
		//read in w/scanner
		password = input.nextLine();
		
		//create the librarian object
		//usertable is a static array from the "Library" class
		usertable[0] = new Librarian(username, password);
		
		System.out.println("\nInitial Librarian Added.\n"); //extra line between starting instructions
		
		//main system will run through an infinite loop.
		while(true)
		{
		
			if (logged_user != -1)
			{
			
				//so the user is logged in.
				System.out.println("Welcome to the Library " + usertable[logged_user].username + ".");
				
				System.out.println("Enter a number corresponding with an action to perform that action.");
				//now display the options
				
				System.out.println("1: Check out a book");
				System.out.println("2: Renew a book");
				System.out.println("3: Return a book");
				System.out.println("4: Book search");
				System.out.println("5: Put book on hold");
				System.out.println("6: Check fines / balance");
				System.out.println("7: Access Librarian Options");
				System.out.println("\n8: Log Out");
				
				System.out.println("-----------------------\n\nEnter Your Action Here: ");
				
				//now read it in
				userinput = input.nextInt();
				
				//control what happens next with a switch
				switch(userinput)
				{
					case 1: //Checking out a book
					{
						System.out.println("\n- BOOK CHECK OUT -\nEnter the ID of the book you would like to check out: ");
						
						//we can overwrite userinput now because we already checked the value for the switch
						userinput = input.nextInt();
						
						//checking out a book.
						if (usertable[logged_user].CheckOutBook(userinput))
						{
							System.out.println("Book checked out successfully! It's due in " + usertable[logged_user].GetWhenDue(userinput) + " days.");
							
						}
						else
						{
							//you can't check that book out!
							System.out.println("That book isn't available, sorry.");
						}
						
						break;
					}
					case 2: //Renewing a book
					{
						System.out.println("\n- BOOK RENEWAL -\nEnter the ID of the book you would like to renew: ");
						
						//we can overwrite userinput now because we already checked the value for the switch
						userinput = input.nextInt();
						
						//renewing a book
						if (usertable[logged_user].RenewBook(userinput))
						{
							System.out.println("Book renewed successfully! Now it's due in " + usertable[logged_user].GetWhenDue(userinput) + " days.");
							
						}
						else
						{
							//you can't renew this book
							System.out.println("Error renewing the book. Did you check it out?");
						}
						
						break;
					}
					case 3: //Returning a book
					{
						System.out.println("\n- BOOK RETURN -\nEnter the ID of the book you would like to return: ");
						
						//we can overwrite userinput now because we already checked the value for the switch
						userinput = input.nextInt();
						
						//renewing a book
						if (usertable[logged_user].ReturnBook(userinput))
						{
							System.out.println("Book returned successfully!");
							
						}
						else
						{
							//you can't return this book
							System.out.println("Error on returning the book. Did you check it out?");
						}
						
						break;
					}
					case 4: //Book Search
					{
						System.out.println("\n- BOOK SEARCH -\nEnter 1 to search by title.\nEnter 2 to search by author.\nEnter 3 to search by Subject.\nEnter here: ");
						//first we're going to ask what category they want to search by, then we will ask for the string.
						
						//we can overwrite userinput now because we already checked the value for the switch
						userinput = input.nextInt();
						
						//now do another switch...
						switch(userinput)
						{
						
						
						}//end switch
						
						break;
					}
					
						
				}//end switch
				
				
				
				
				
			//Tasks the client needs to handle:
			/*
			 * The Librarian will have the option to:
			1)Add a new user
			2)Add a new book.
			3)Checkout the book
			4)Renew a book
			5)Find a book.
			6)Hold a book.
			7)Calculate the fine.
			
			The user will have options to:
			1)Checkout the book
			2)Renew the book
			3)Find a book
			4)Hold a book
			5)Calculate the fine
			 */
			}
			else
			{
				//they need to log in
				
				//immediately after logging in, check for books that are due (or near due) and warn the user.
				
				//show a balance owed, if any
				
			}
			
		}
		
	}
}
