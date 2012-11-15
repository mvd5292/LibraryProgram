/** Project: Library System (Zach Kehs, Meeten Doshi, Zac Clark)
 * 
 * This class is a superclass for Librarian and Customer.
 * It contains all methods needed for users of the library system.
 * 
 * @author Zach Kehs
 * @author Zac Clark
 * @version 1.0 10/8/2012
 */
public abstract class User
	{
	//classwide constants, private:
	protected final double MAXFINE = 20.0; //this is the most a user can be fined for one book
	protected final double FINEPERDAY = 0.25; //this is the charge per day the book is late
	//public constants:
	public final int MAXBOOKS = 20; //this is the most books a single user can have associated with their account
	
	public boolean isLoggedIn = false; //true if the user is logged in
	public boolean isLibrarian = false; //true if the user has librarian priveleges.
	
	public String username; //username, used for logging in and recording the holder of a book
	
	public int[] myBooks = new int[MAXBOOKS]; //this is the collection of books for htis user
	
	//password is protected so that it will be private for subclasses
	protected String password; //this is what is used to log into the account
	
	/**
	* set the username and pasword in the constructor
	*
	* @param username - the username attempt to log in
	* @param password - the password attempt to log in
	*/
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	
	
	/**
	* Logs the user into the system.
	*
	* @param username - the username attempt to log in
	* @param password - the password attempt to log in
	* @return true if the user was logged in, false otherwise
	*/
	public boolean logIn(String username, String password)
	{
		if ((username.equals(this.username)) && (password.equals(this.password)))
		{
			isLoggedIn = true;
			return true;
		}
		else return false;
	}
	
	
	/**
	* Calculates the fine from a single book.
	*
	* @param i the index of the global collection of the book
	* @return the total fine from the book
	*/
	public abstract double getFine(int i);
	
	/**
	* Gets the total fine owed by this user, from all of the books.
	*
	* @return the total fine from all books taken out by this user
	*/
	public abstract double getTotalFine();
	
	/**
	* checks out a book
	*
	* @param i the index of the global collection of the book
	* @return true if the operation was successful, false otherwise.
	*/
	public boolean checkOutBook(int i)
	{
		if ((i > Library.collectionSize) || (i <= 0))
		{
			return false;
		}
		//first check if the book has no holder
		if((Library.collection[i].holder == "") || (Library.collection[i].onHold && Library.collection[i].holder == username))
		{
			//check the book out for one week.
			Library.collection[i].holder = username;
			Library.collection[i].dateDue = Library.currentDate + 7;
			Library.collection[i].onHold = false; //checked out books cannot be on hold
		
			//find the first empty slot in the mybooks list, and replace it with this index.
			int j = 0;		
			while((myBooks[j] != 0) && myBooks[j] != i)
				j++;
		
			myBooks[j] = i;
			
			return true;
		}
		else 
			return false; //someone else checked this book out so we can't.
	}
	
	
	/**
	* puts a book on hold
	*
	* @param i the index of the global collection of the book
	* @return true if the operation was successful, false otherwise.
	*/
	public boolean putOnHold(int i)
	{
		if ((i > Library.collectionSize) || (i <= 0))
		{
			return false;
		}
		//first check if the book has no holder
		if((Library.collection[i].holder == "") || (Library.collection[i].onHold && Library.collection[i].holder == username))
		{
			//put the book on hold
			Library.collection[i].holder = username;
			Library.collection[i].onHold = true;
		
			//find the first empty slot in the mybooks list, and replace it with this index, even though we didn't check it out
			int j = 0;		
			while((myBooks[j] != 0) && myBooks[j] != i) //the second part here tests if we already  had it on hold for some reason.
				j++;
		
			myBooks[j] = i;
			
			return true;
		}
		else 
			return false; //someone else checked this book out or put it on hold so we can't.
	}
	
	
	/**
	* returns a book
	*
	* @param i the index of the global collection of the book
	* @return true if the operation was successful, false otherwise.
	*/
	public boolean returnBook(int i)
	{
		if ((i > Library.collectionSize) || (i <= 0))
		{
			return false;
		}
		//make sure we're trying to return a book we checked out in the first place
		if (Library.collection[i].holder == username)
		{
			Library.collection[i].holder = "";
			Library.collection[i].dateDue = 0;
		
			
			//loop and find this index and reset it
			for(int a = 0; a < myBooks.length; a++)
			{
				if (myBooks[a] == i)
					myBooks[a] = 0;
			}
		
			return true;
		}
		else 
			return false;
	}
	
	/**
	* renews a book for another week.
	*
	* @param i the index of the global collection of the book
	* @return true if the operation was successful, false otherwise.
	*/
	public boolean renewBook(int i)
	{
		if ((i > Library.collectionSize) || (i <= 0))
		{
			return false;
		}
		//You can't renew a book if it isn't checked out or if it isn't due for another week.
		if ((Library.collection[i].holder == username) && (!Library.collection[i].onHold) && (Library.collection[i].dateDue < Library.currentDate + 7))
		{
			Library.collection[i].dateDue += 7;

			return true;
		}
		else
			return false;
	}
	
	/**
	* returns the due date for a book
	*
	* @param i the index of the global collection of the book
	* @return the date the book is supposedly due, or -1 if it isn't your book
	*/
	public int getWhenDue(int i)
	{
		if (Library.collection[i].holder != username)
		{
			return -1;
		}
		else return (Library.collection[i].dateDue);
	}
	
	//virtual
	void addBook(String title, String author, String subject, int pageCount)
	{
		
	}
	
	void addBook(String title, String author)
	{
		
	}
	
	//This function takes in the index of the book name to be changed and the title it should be changed to and it changes it. 
	void changeBookTitle(int index, String title)
	{
	//	Library.collection[index].title = title;
	}
	
	//This function takes the index where the librarian wants to make a change and the name of the author and makes the change.
	void changeBookAuthor(int index, String author)
	{
	//	Library.collection[index].author = author;
	}
	
	//This function changes the subject by taking in the index where it needs to be changed and the new subject. 
	void changeBookSubject(int index, String Subject)
	{
		//Library.collection[index].subject = Subject;
	}
	
	//This function changes the pageCount by taking in the index where it needs to be changed and the new pagecount. 
	void changeBookPageCount(int index, int pageCount)
	{
		//Library.collection[index].pagecount = pageCount;
	}
	
	
	
	/**
	* Test driver
	*
	*/
	public static void main(String [] args)
	{
		//Initialize a quick collection
		Library.collection[Library.collectionSize] = new Book();
		Library.collection[Library.collectionSize].title = "Harry Potter 1";
		Library.collection[Library.collectionSize].author = "J.K. Rowling";
		Library.collectionSize++;
		Library.collection[Library.collectionSize] = new Book();
		Library.collection[Library.collectionSize].title = "Hunger Games 1";
		Library.collection[Library.collectionSize].author = "Suzanne Collins";
		Library.collectionSize++;
		Library.collection[Library.collectionSize] = new Book();
		Library.collection[Library.collectionSize].title = "The Great Gatsby";
		Library.collection[Library.collectionSize].author = "F. Scott Fitzgerald";
		
		User testUser = new Customer("test", "test");
		
		testUser.username = "Mary";
		testUser.password = "123abc";
		
		//test logging in
		System.out.println("Testing login, first test should fail, second should succeed.");
		System.out.println(testUser.logIn("Mary", "abc123"));
		System.out.println(testUser.logIn("Mary", "123abc"));
		
		//now test checking out a book
		System.out.println("Checkout: " + testUser.checkOutBook(1));
		System.out.println("GetWhenDue: " + testUser.getWhenDue(1));
		
		//accelerate time
		Library.currentDate += 3;
		
		System.out.println("RenewBook: " + testUser.renewBook(1));
		
		System.out.println("ReturnBook: " + testUser.returnBook(1));
		System.out.println("PutOnHold: " + testUser.putOnHold(1));
		
		//test fines for the customer

		testUser.checkOutBook(1);
		Library.currentDate += 13;
		
		System.out.println("Fines, total and single (should be the same): " + testUser.getFine(1) + ", " + testUser.getTotalFine());
		
		System.out.println("Done!");
	}
	

}
