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
	
	private static JFrame app;
	
	private int currentPanel; //this is a numbering system for the panel so we know what one to use
	private JPanel panelObj; //this is the current panel we are using
	private int usercount;
	private String username, password;
	private int logged_user;
	
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	///////////////////  VARIABLES FOR LOGIN ////////////////////////////
	/////////////////////////////////////////////////////////////////////
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	///////////////////  VARIABLES FOR CUSTOMER /////////////////////////
	/////////////////////////////////////////////////////////////////////
		
	private JLabel spaceLabel;
	private JLabel searchLabel;
	private JLabel actionLabel;
	private JComboBox actionsDropDown;
	private static final String[] ACTIONCATAGORIES = {"Check out", "Get Due Date", "Hold", "Renew", "Return"};

	private JTextField idNumberInput;
	private JLabel myBooksLabel;
	private JComboBox searchDropDown;
	private static final String[] SEARCHCATAGORIES = {"Author", "Genre", "Title"};
	private static final int S_AUTHOR = 0;
	private static final int S_GENRE = 1;
	private static final int S_TITLE = 2;
	private JTextField searchTextField;
	private JTextArea searchResults;
	private JTextArea myBooksTextArea;
	private JButton getFines;
	private JButton dueDate;
	private JTextField showFines;
	private JLabel idLabel;
	
	private double totalFines;
	
		
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	///////////////////  VARIABLES FOR LIBRARIAN ////////////////////////
	/////////////////////////////////////////////////////////////////////
	
	private JLabel librarianIdLabel;
	private JTextField librarianGetId;
	private JLabel libAuthorLabel;
	private JTextField libGetAuthor;
	private JLabel librarianTitle;
	private JLabel libSpaceTitle;
	private JButton libAddBookButton;
	private JButton libEditBookButton;
	private JLabel libGenreLabel;
	private JTextField libGetGenre;
	private JLabel libPageCountLabel;
	private JTextField libGetPageCount;
	private JLabel libTitleLabel;
	private JTextField libGetTitle;
	private JLabel libAddUserLabel;
	private JLabel libNewUserName;
	private JTextField libGetNewUserName;
	private JLabel libNewPasswordLabel;
	private JTextField libGetNewPassword;
	private JCheckBox libIsLibrarian;
	private JButton libAddNewUserButton;

	//helper functions to create each panel
	
	//Creating the LogIn panel
	public JPanel createLogInPanel()
	{
		//change application size to the login panel size
		app.setSize(260,155);
		
		//because layout managers are required you might want to try one here?
		//create all the buttons and stuff here and return the panel
		JPanel temp = new JPanel();
		
		GridBagLayout layout = new GridBagLayout();//(0,2,10,10);
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		
		temp.setLayout(layout);
		
		
		//Labels for username and password with login button
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		
		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		
		loginButton = new JButton("Log In");
		
		int PADDING = 5; //pixels of cushioning
		
		Insets padobj = new Insets(PADDING, PADDING, PADDING, PADDING);
 		 
		constraints.insets = padobj;
		
		//Username Label
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		layout.setConstraints(usernameLabel, constraints);
		temp.add(usernameLabel);
		
		//user field
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		layout.setConstraints(usernameField, constraints);
		temp.add(usernameField);
		
		//password label
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		layout.setConstraints(passwordLabel, constraints);
		temp.add(passwordLabel);
		
		//passwordfield
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		layout.setConstraints(passwordField, constraints);		
		passwordField.addActionListener(this);
		temp.add(passwordField);
		
		//and the login button
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		layout.setConstraints(loginButton, constraints);
		loginButton.addActionListener(this);
		temp.add(loginButton);
		
		return temp;
	}//end create loginpanel
	
	//Creating the Customer panel
	public JPanel createCustomerPanel()
	{
		//create all the buttons and stuff here and return the panel
		JPanel temp = new JPanel();
		
		if (currentPanel == LIBRARIAN)
		{
			app.setSize(800,700);
		}
		else
		{
			app.setSize(700,500);
		}
		
				
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		
	
		temp.setLayout(layout);
		
		spaceLabel = new JLabel("   ");
		searchLabel = new JLabel("Search by: ");
		myBooksLabel = new JLabel("My Books");
		actionLabel = new JLabel("Actions: ");
		searchDropDown = new JComboBox(SEARCHCATAGORIES);
		actionsDropDown = new JComboBox(ACTIONCATAGORIES);
		actionsDropDown.addActionListener(this);
		
		idNumberInput = new JTextField(15);
		idNumberInput.addActionListener(this);
		
		searchTextField = new JTextField(15);
		searchTextField.addActionListener(this);
		
		showFines = new JTextField(15);
		showFines.setEditable(false);
		
		searchResults = new JTextArea("Search Results", 10,10);
		myBooksTextArea = new JTextArea("My Books", 10,10);
		
		getFines = new JButton("Fines");
		getFines.addActionListener(this);
		
		dueDate = new JButton("Due Date");
		idLabel = new JLabel("Id Number: ");
		
		constraints.gridx = 0;
		constraints.gridy = 0; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(searchLabel, constraints);
		temp.add(searchLabel);

		constraints.gridx = 1;
		constraints.gridy = 0; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(searchDropDown, constraints);
		temp.add(searchDropDown);
		
		constraints.gridx = 2;
		constraints.gridy = 0; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(searchTextField, constraints);
		temp.add(searchTextField);
		
		
		
		constraints.gridx = 3;
		constraints.gridy = 5; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(actionLabel, constraints);
		temp.add(actionLabel);
		
		
		constraints.gridx = 0;
		constraints.gridy = 1; 
		constraints.gridwidth = 3;
		constraints.gridheight = 3;
	
		layout.setConstraints(searchResults, constraints);
		temp.add(searchResults);
		

		constraints.gridx = 0;
		constraints.gridy = 5; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(spaceLabel, constraints);
		temp.add(spaceLabel);
		
		
		
		constraints.gridx = 0;
		constraints.gridy = 6; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(myBooksLabel, constraints);
		temp.add(myBooksLabel);
		
		constraints.gridx = 0;
		constraints.gridy = 7; 
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
	
		layout.setConstraints(myBooksTextArea, constraints);
		temp.add(myBooksTextArea);
		
		

		constraints.gridx = 3;
		constraints.gridy = 0; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(getFines, constraints);
		temp.add(getFines);
		

		constraints.gridx = 4;
		constraints.gridy = 0; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(showFines, constraints);
		temp.add(showFines);
		
		
		constraints.gridx = 4;
		constraints.gridy = 5; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(actionsDropDown, constraints);
		temp.add(actionsDropDown);
		
		constraints.gridx = 3;
		constraints.gridy = 6; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(idLabel, constraints);
		temp.add(idLabel);
		
		constraints.gridx = 4;
		constraints.gridy = 6; 
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
	
		layout.setConstraints(idNumberInput, constraints);
		temp.add(idNumberInput);
		
		//add on if librarian
		if(currentPanel == LIBRARIAN)
		{
			

			librarianIdLabel = new JLabel("ID Number:");
			librarianGetId = new JTextField(10);
			libAuthorLabel = new JLabel("Author:");
			libGetAuthor = new JTextField(15);
			librarianTitle = new JLabel("Librarian Options");
			libSpaceTitle = new JLabel("     ");
			libAddBookButton = new JButton("Add Book");
			libEditBookButton = new JButton("Edit Book");
			libGenreLabel = new JLabel ("Genre:");
			libGetGenre = new JTextField();
			libPageCountLabel = new JLabel("Page Count:");
			libGetPageCount = new JTextField();
			libTitleLabel = new JLabel("Title:");
			libGetTitle = new JTextField();
			libAddUserLabel = new JLabel("Add User");
			libNewUserName = new JLabel ("New username: ");
			libGetNewUserName = new JTextField();
			libNewPasswordLabel = new JLabel ("New Password:");
			libGetNewPassword = new JTextField();
			libIsLibrarian = new JCheckBox("Librarian");
			libAddNewUserButton = new JButton("Add User");
			
			
			constraints.gridx = 0;
			constraints.gridy = 8; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libSpaceTitle, constraints);
			temp.add(libSpaceTitle);
			
			constraints.gridx = 0;
			constraints.gridy = 9; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(librarianTitle, constraints);
			temp.add(librarianTitle);
			
			
			constraints.gridx = 0;
			constraints.gridy = 10; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(librarianIdLabel, constraints);
			temp.add(librarianIdLabel);

			constraints.gridx = 0;
			constraints.gridy = 11; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(librarianGetId, constraints);
			temp.add(librarianGetId);
			
			constraints.gridx = 3;
			constraints.gridy = 11; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libAuthorLabel, constraints);
			temp.add(libAuthorLabel);
			
			constraints.gridx = 4;
			constraints.gridy = 11; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libGetAuthor, constraints);
			temp.add(libGetAuthor);
			
			constraints.gridx = 3;
			constraints.gridy = 12; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libGenreLabel, constraints);
			temp.add(libGenreLabel);
			
			constraints.gridx = 4;
			constraints.gridy = 12; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libGetGenre, constraints);
			temp.add(libGetGenre);
			
			constraints.gridx = 3;
			constraints.gridy = 13; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libPageCountLabel, constraints);
			temp.add(libPageCountLabel);
			
			constraints.gridx = 4;
			constraints.gridy = 13; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libGetPageCount, constraints);
			temp.add(libGetPageCount);

			
			constraints.gridx = 3;
			constraints.gridy = 14; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libTitleLabel, constraints);
			temp.add(libTitleLabel);
			
			constraints.gridx = 4;
			constraints.gridy = 14; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libGetTitle, constraints);
			temp.add(libGetTitle);
		
			
			constraints.gridx = 0;
			constraints.gridy = 12; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libAddBookButton, constraints);
			temp.add(libAddBookButton);
			
			constraints.gridx = 0;
			constraints.gridy = 13; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libEditBookButton, constraints);
			temp.add(libEditBookButton);
			
			constraints.gridx = 0;
			constraints.gridy = 15; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libAddUserLabel, constraints);
			temp.add(libAddUserLabel);
			
			constraints.gridx = 0;
			constraints.gridy = 16; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libNewUserName, constraints);
			temp.add(libNewUserName);
			
			constraints.gridx = 1;
			constraints.gridy = 16; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libGetNewUserName, constraints);
			temp.add(libGetNewUserName);
			
			
			constraints.gridx = 0;
			constraints.gridy = 17; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libNewPasswordLabel, constraints);
			temp.add(libNewPasswordLabel);
			
			constraints.gridx = 1;
			constraints.gridy = 17; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libGetNewPassword, constraints);
			temp.add(libGetNewPassword);
			
			constraints.gridx = 2;
			constraints.gridy = 16; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libIsLibrarian, constraints);
			temp.add(libIsLibrarian);
			
			constraints.gridx = 2;
			constraints.gridy = 17; 
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
		
			layout.setConstraints(libAddNewUserButton, constraints);
			temp.add(libAddNewUserButton);
			
		}
							
		return temp;
	}
	
	//Creating the Librarian panel
	public JPanel createLibrarianPanel()
	{
		//create all the buttons and stuff here and return the panel
		JPanel temp = createCustomerPanel();
		return temp; //dont do anything for now
	}
	
	//Reactions to buttons
	public void actionPerformed(ActionEvent e)
	{
		//Switch by panel; then react by button
		//////////////////////////////////////////////////
		//////// ACTION HANDLING FOR LOGIN SCREEN
		//////////////////////////////////////////////////
			//handle the login button
			if ((e.getSource() == loginButton) || (e.getSource() == passwordField))
			{
				//handle the login button
				
				if (Library.userCount == 0)
				{
					//initial user
					username = usernameField.getText();
					//getPassword returns a char[], and we need a String...
					password = (passwordField.getPassword()).toString();
					
					//now create the first library user
					Library.userTable[0] = new Librarian(username, password);
					
					//switch to the librarian panel
					switchPanel(LIBRARIAN);
					
					popupBox("Initial Librarian Created.", "Information");
				}
				else
				{
					//see if the username matches anyone preexisting.
					//loop through users.
					boolean failed = false;
					
					for(int i = 0; i < Library.userCount; i++)
					{
						if (Library.userTable[i].logIn(username, password))
						{
							//log in successful
							failed = false;
							
							logged_user = i;
							
							//check if the user is a libraria
							if (Library.userTable[i].isLibrarian)
							{
								//not sure if I have to delete this panel first
								currentPanel = LIBRARIAN;
								panelObj = createLibrarianPanel();
							}
							else
							{
								currentPanel = CUSTOMER;
								panelObj = createCustomerPanel();
							}
							
							break; //get out of the loop
						}
						else
						{
							//incorrect!
							failed = true;
						}
					}
					
					if (failed)
					{
						popupBox("The username or password is incorrect.", "LOG IN FAILED");
					}
				}//end needed to log in
				
			}//end loginbutton
			

			///////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			////////////   ACTION HANDLING FOR CUSTOMER INTERFACE   ///////////////////////
			///////////////////////////////////////////////////////////////////////////////

		
			if(e.getSource() == getFines)
			{
				totalFines = Library.userTable[logged_user].getTotalFine();
				String stringFine = totalFines + "";
				showFines.setText(stringFine);
			}
			
			if(e.getSource() == idNumberInput)
			{
				switch(actionsDropDown.getSelectedIndex())
				{
				
					case 0:
					{
						
						if(Library.userTable[logged_user].checkOutBook(Integer.parseInt(idNumberInput.getText())))
						{
							popupBox("The book was succesfully checked out!", "Checkout");
						}
						else
						{
							popupBox("Invalid ID Number", "Error");
						}
						
						
					}
					case 1:
					{
						if(Library.userTable[logged_user].getWhenDue(Integer.parseInt(idNumberInput.getText())) == -1)
						{
							popupBox("Invalid ID Number", "Error");
						}
						else
						{
							popupBox("The due date is:" + Library.userTable[logged_user].getWhenDue(Integer.parseInt(idNumberInput.getText())), "Due Date" );
						}
						
						
					}
					case 2:
					{
						if(Library.userTable[logged_user].putOnHold(Integer.parseInt(idNumberInput.getText())))
						{
							popupBox("The book was succesfully put on hold!", "Hold");
						}
						else
						{
							popupBox("Invalid ID Number", "Error");
						}
						
					}
					case 3:
					{
						if(Library.userTable[logged_user].renewBook(Integer.parseInt(idNumberInput.getText())))
						{
							popupBox("The book was successfully renewd", "Renew");
						}
						else
						{
							popupBox("Invalid ID Number", "Error");
						}
						
					}
					case 4:
					{
						if(Library.userTable[logged_user].returnBook(Integer.parseInt(idNumberInput.getText())))
						{
							popupBox("The book was successfully returned", "Return");
						}
						else
						{
							popupBox("Invalid ID Number", "Error");
						}
					}
					
				
				}//end switch
				
				
			}//end idnumber input
			
			
			///////////////////////////////////////////////////////
			//// SEARCHING - (zach kehs)
			//TODO
			//test searching
			if (e.getSource() == searchTextField)
			{
				//the user is running a search
				int[] results = new int[Library.collectionSize];
				
				//switch based on the drop down
				switch(searchDropDown.getSelectedIndex())
				{
					case S_GENRE:
					{
						results = Library.searchBySubject(searchTextField.getText());
						break;
					}
					case S_TITLE:
					{
						popupBox("Passing {" + searchTextField.getText() + "}", "");
						results = Library.searchByName(searchTextField.getText());
						
						for(int i = 1; i <= Library.collectionSize; i++)
						{
							//crashes here
							popupBox(i + "th index is " + results[i-1] + ", title {" + Library.collection[i].title + "}", "");
						}
						
						break;
					}
					case S_AUTHOR:
					{
						results = Library.searchByAuthor(searchTextField.getText());
						break;
					}
				}//end switch
				
				
				//now we need to paste the results into the text area
				//String[] formattedResults = new String[Library.collectionSize];
				String formattedResults = "";
				int count = 0;
				
				for(int i = 0; i < Library.collectionSize; i++)
				{
					//popupBox("Result " + i + " is " + results[i], "");
					//check if this slot is filled
					if (results[i] > 0) //0 is an empty result
					{
						formattedResults += "\nID: " + results[i] + "\t" + Library.collection[results[i]].title + "\t" + Library.collection[results[i]].author; 
						count++;
					}
					
				}//end for
				
				//and now set the text
				searchResults.setText(formattedResults);
				
				popupBox("Search complete! " + count + " results found.", "Results");
				
			}//text field enter
				
			
			///////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////
			////////////   ACTION HANDLING FOR LIBRARIAN INTERFACE   ///////////////////////
			///////////////////////////////////////////////////////////////////////////////

		
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
		//LibraryClient panel = new LibraryClient();
		app = new JFrame();
		
		//app is created before the panel so taht we can change the size from within the panel
		LibraryClient panel = new LibraryClient();
		
		app.add(panel);
		//make it exit when you close
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		app.setResizable(false);
		app.setVisible(true);
		app.setTitle("Library System");
		
	}
	
	//This makes a popupBox to annoy the user with a message
	public static void popupBox(String messageBody, String heading)
    {
		//use JOptionPane to show a message
        JOptionPane.showMessageDialog(null, messageBody, heading, JOptionPane.INFORMATION_MESSAGE);
    }
	
	
	//switch panel to CUSTOMER, LIBRARIAN, or LOGIN.
	public void switchPanel(int newPanel)
	{
		remove(panelObj);
		currentPanel = newPanel;
		
		switch(currentPanel)
		{
			case CUSTOMER:
			{
				panelObj = createCustomerPanel();
				break;
			}
			case LIBRARIAN:
			{
				panelObj = createLibrarianPanel();
				break;
			}
			case LOGIN:
			{
				panelObj = createLogInPanel();
				break;
			}
		}
		
		add(panelObj);
	}
	
	
	public void createData()
	{
		//creates the library data. later this will be moved to a SQL server
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "Harry Potter 1";
				Library.collection[Library.collectionSize].author = "J. K. Rowling";
				Library.collection[Library.collectionSize].subject = "fantasy";
				Library.collection[Library.collectionSize].pagecount = 326;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "The Great Gatsby";
				Library.collection[Library.collectionSize].author = "F. Scott Fitzgerald";
				Library.collection[Library.collectionSize].subject = "fiction";
				Library.collection[Library.collectionSize].pagecount = 123;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "Lord of the Rings";
				Library.collection[Library.collectionSize].author = "JRR Tolkein";
				Library.collection[Library.collectionSize].subject = "fantasy";
				Library.collection[Library.collectionSize].pagecount = 311;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "Catcher in the Rye";
				Library.collection[Library.collectionSize].author = "J.D. Salinger";
				Library.collection[Library.collectionSize].subject = "Novel";
				Library.collection[Library.collectionSize].pagecount = 231;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "Harry Potter and the Chamber of Secrets";
				Library.collection[Library.collectionSize].author = "J. K. Rowling";
				Library.collection[Library.collectionSize].subject = "fantasy";
				Library.collection[Library.collectionSize].pagecount = 399;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "Paterno";
				Library.collection[Library.collectionSize].author = "Joe Posnaski";
				Library.collection[Library.collectionSize].subject = "Biography";
				Library.collection[Library.collectionSize].pagecount = 267;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "I am America(And so can you)";
				Library.collection[Library.collectionSize].author = "Stephen Colbert";
				Library.collection[Library.collectionSize].subject = "Satirical";
				Library.collection[Library.collectionSize].pagecount = 184;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "America (The Book)";
				Library.collection[Library.collectionSize].author = "Stephen Colbert";
				Library.collection[Library.collectionSize].subject = "Satirical";
				Library.collection[Library.collectionSize].pagecount = 467;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "Green Hams and Eggs";
				Library.collection[Library.collectionSize].author = "Dr. Seuss";
				Library.collection[Library.collectionSize].subject = "Childrens Book";
				Library.collection[Library.collectionSize].pagecount = 13;
				Library.collectionSize++;
				Library.collection[Library.collectionSize] = new Book();
				Library.collection[Library.collectionSize].title = "A Tale of two Cities";
				Library.collection[Library.collectionSize].author = "Charles Dickens";
				Library.collection[Library.collectionSize].subject = "Historical Novel";
				Library.collection[Library.collectionSize].pagecount = 379;
	}
	
	
	public LibraryClient()
	{
		super();
		
		new Library(); //necessary?
		
		createData(); //create the library for us to use

		//set all the default values
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
