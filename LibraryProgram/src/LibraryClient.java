/* Project: Library System (Zach Kehs, Meeten Doshi, Zac Clark)
 * 
 * This is going to be the client system for the project (phase 2)
 * This is not finished yet because we are not supposed to create
 * tests that work across multiple classes yet.
 * 
 * @author Zach Kehs
 * @version 1.0 10/8/2012
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class LibraryClient extends JPanel implements ActionListener, ItemListener
{
	//do it this way instead
	//http://www.apl.jhu.edu/~hall/java/Swing-Tutorial/Swing-Tutorial-JPanel.html
		
	//create constants to keep track of our current panel number
	public static final int LOGIN = 0;
	public static final int CUSTOMER = 1;
	public static final int LIBRARIAN = 2;
	
	private int currentPanel; //this is a numbering system for the panel so we know what one to use
	private JPanel panelObj; //this is the current panel we are using
	private int userinput;
	private int usercount;
	private String username, password, stringinput;
	private int logged_user;
	
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	///////////////////  VARIABLES FOR LOGIN ////////////////////////////
	/////////////////////////////////////////////////////////////////////
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	///////////////////  VARIABLES FOR CUSTOMER /////////////////////////
	/////////////////////////////////////////////////////////////////////
		
	
	
		
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	///////////////////  VARIABLES FOR LIBRARIAN ////////////////////////
	/////////////////////////////////////////////////////////////////////
	
	
	
	//helper functions to create each panel
	
	//Creating the LogIn panel
	public JPanel createLogInPanel()
	{
		//because layout managers are required you might want to try one here?
		//create all the buttons and stuff here and return the panel
		JPanel temp = new JPanel();
		
		GridLayout layout = new GridLayout(2,2,10,10);
		temp.setLayout(layout);
		
		//Labels for username and password with login button
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		temp.add(usernameLabel);
		temp.add(usernameField);
		//break here
		temp.add(passwordLabel);
		temp.add(passwordField);
		
		return temp;
	}
	
	//Creating the Customer panel
	public JPanel createCustomerPanel()
	{
		//create all the buttons and stuff here and return the panel
		JPanel temp = new JPanel();
		
		
		return temp;
	}
	
	//Creating the Librarian panel
	public JPanel createLibrarianPanel()
	{
		//create all the buttons and stuff here and return the panel
		JPanel temp = new JPanel();
		
		
		return temp;
	}
	
	//Reactions to buttons
	public void actionPerformed(ActionEvent e)
	{
		//Switch by panel; then react by button
		switch(currentPanel)
		{
			//login screen. One button to handle; the "login" button.
			case LOGIN:
			{
				//handle the login button
				break;
			}
			
			///////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			////////////   ACTION HANDLING FOR CUSTOMER INTERFACE   ///////////////////////
			///////////////////////////////////////////////////////////////////////////////
			case CUSTOMER:
			{
				
				break;
			}
			
			///////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			////////////   ACTION HANDLING FOR LIBRARIAN INTERFACE   ///////////////////////
			///////////////////////////////////////////////////////////////////////////////
			case LIBRARIAN:
			{
				
				break;
			}
		}
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		//Switch by panel; then react by button
		switch(currentPanel)
		{
			//login screen. One button to handle; the "login" button.
			case LOGIN:
			{
				//handle the login button
				break;
			}
			
			///////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			////////////   ITEM HANDLING FOR CUSTOMER INTERFACE   ///////////////////////
			///////////////////////////////////////////////////////////////////////////////
			case CUSTOMER:
			{
				
				break;
			}
			
			///////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			////////////   ITEM HANDLING FOR LIBRARIAN INTERFACE   ///////////////////////
			///////////////////////////////////////////////////////////////////////////////
			case LIBRARIAN:
			{
				
				break;
			}
		}
	}
	
	public static void main(String [] args)
	{
		//start the program from here because the main runs in a static context
		LibraryClient panel = new LibraryClient();
		
		JFrame app = new JFrame();
		
		//make it exit when you close
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add panel and start
		app.add(panel);
		app.setSize(400,300);
		app.setVisible(true);
		app.setTitle("Library System");
		
		
	}
	
	public LibraryClient()
	{
		super();

		//set all the default values
		userinput = 0;
		usercount = 0;
		logged_user = 0;

		currentPanel = LOGIN;
		panelObj = createLogInPanel(); //done.
		
		add(panelObj);
		
		//switching to other panels should be handled in button presses
		
		
		
		////////////////////////////////////////
		//////  EVERYTHING BELOW HERE IS OLD STUFF WE NEED TO ADAPT TO THE GUI
		/*
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
		Library.userTable[0] = new Librarian(username, password);
		
		System.out.println("\nInitial Librarian Added.\n"); //extra line between starting instructions
		
		//main system will run through an infinite loop.
		while(true)
		{
		
			if (logged_user != -1)
			{
			
				//so the user is logged in.
				System.out.println("Welcome to the Library " + Library.userTable[logged_user].username + ".");
				
				System.out.println("Enter a number corresponding with an action to perform that action.");
				//now display the options
				
				System.out.println("1: Check out a book");
				System.out.println("2: Renew a book");
				System.out.println("3: Return a book");
				System.out.println("4: Book search");
				System.out.println("5: Put book on hold");
				System.out.println("6: Check fines / balance");
				
				if (Library.userTable[logged_user].isLibrarian)
				{
					System.out.println("7: Access Librarian Options");
				}
				else
				{
					System.out.println("7: N/A");
				}
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
						if (Library.userTable[logged_user].CheckOutBook(userinput))
						{
							System.out.println("Book checked out successfully! It's due in " + Library.userTable[logged_user].GetWhenDue(userinput) + " days.");
							
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
						if (Library.userTable[logged_user].RenewBook(userinput))
						{
							System.out.println("Book renewed successfully! Now it's due in " + Library.userTable[logged_user].GetWhenDue(userinput) + " days.");
							
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
						if (Library.userTable[logged_user].ReturnBook(userinput))
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
						
						int[] results = new int[Library.collectionSize];
						
						//now do another switch...
						switch(userinput)
						{
							case 1: //search by title
							{
								System.out.println("Enter the title you want to search for: ");
								
								//read input
								stringinput = input.nextLine();
								
								//the search will return an array of potential matches
								results = Library.SearchByName(stringinput);
								
								break;
							}
							
							case 2: //search by author
							{
								System.out.println("Enter the author you want to search for: ");
								
								//read input
								stringinput = input.nextLine();
								
								//the search will return an array of potential matches
								results = Library.SearchByAuthor(stringinput);
								
								break;
							}
							
							case 3: //search by subject
							{
								System.out.println("Enter the subject you want to search for: ");
								
								//read input
								stringinput = input.nextLine();
								
								//the search will return an array of potential matches
								results = Library.SearchBySubject(stringinput);
								
								break;
							}
							
							default:
							{
								System.out.println("That wasn't a valid option.");
								results[0] = 0; //0's are invalid indeces, so this will mean an empty array.
								break;
							}
						
						}//end switch
						
						//now that we have the array of potential matches, we need to show them all to the user
						if (results[0] == 0)
						{
							System.out.println("There are no results to display.");
						}
						else
						{
							System.out.println("\nID#   TITLE\t\tAUTHOR");
							//print everything out, and the associated ID's
							for(int i = 0; (i < Library.collectionSize)&&(results[i] != 0); i++)
							{
								//so the loop will not enter if results[i] == 0.
								System.out.println(results[i] + "   " + Library.collection[results[i]].title + "\t" + Library.collection[results[i]].author);
							}
						}
						
						break;
					} //end book search, case 4
					
					case 5: //putting a book on hold
					{
						System.out.println("\nEnter the ID of the book you would like to put on hold: ");
						
						//we can overwrite userinput now because we already checked the value for the switch
						userinput = input.nextInt();
						
						//renewing a book
						if (Library.userTable[logged_user].PutOnHold(userinput))
						{
							System.out.println("Book is now reserved for you!");
							
						}
						else
						{
							//you can't return this book
							System.out.println("You cannot put this title on hold.");
						}
						
						break;
					} //end case 5, putting on hold
					
					case 6: //check fines and balance
					{
						System.out.println("Your currently owe " + Library.userTable[logged_user].GetTotalFine());
						
						break;
					}
					
					//////////////////////////////////////////////////////////////////
					///// LIBRARIAN OPTIONS
					case 7:
					{
						//first we need to check and see if they are actually a librarian
						if (!Library.userTable[logged_user].isLibrarian)
						{
							System.out.println("You do not have access to these options.")
						}
						else
						{
							//they're a librarian
							
							//now we need to provide options for adding new users, books, and other administrative tasks
							System.out.println("\n-- LIBRARIAN MENU --\nEnter a number corresponding with an action to perform that action.");
							//now display the options
							
							System.out.println("1: Add User");
							System.out.println("2: Add Book");
							System.out.println("3: Exit");
							
							System.out.println("-----------------------\n\nEnter Your Action Here: ");
							
							//new read
							userinput = input.nextInt();
							
							//now switch through these options
							switch(userinput)
							{
								case 1:
								{
									//trying to add a new user
									System.out.println("\nEnter 1 if the new user is a librarian, or 2 otherwise.");
									
									userinput = input.nextInt(); 
									//first check if he's a librarian or not
									
									// !!! add a new user here and ask for password/username
									
									break;
								}
								
								case 2:
								{
									
									// !!! add a new book here after asking for relevant info
									break;
								}
								case 3:
								{
									//leave this empty
									break;
								}
								default:
								{
									System.out.println("\nThat was not a valid option.");
								}
							}//end switch
							
							
						}
						break;
					} //end case 7
					
						
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
			 *
			}
			else
			{
				//they need to log in
				
				//immediately after logging in, check for books that are due (or near due) and warn the user.
				
				//show a balance owed, if any
				
			}
			
		}
*/
		
	}//end main

	

	
	
}
