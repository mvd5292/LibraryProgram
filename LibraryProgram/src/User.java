/* Project: Library System (Zach Kehs, Meeten Doshi, Zac Clark)
 * 
 * This class is a superclass for Librarian and Customer.
 * It contains all methods needed for users of the library system
 * 
 * @author Zach Kehs
 * @author Zac Clark
 * @version 1.0 10/8/2012
 */
public class User
	{
	//classwide constants, private:
	private final double MAXFINE = 20.0;
	private final double FINEPERDAY = 0.25;
	//public constants:
	public final int MAXBOOKS = 20;
	
	public boolean isLoggedIn = false;
	public boolean isLibrarian = false;   
	
	public String username;
	
	public int[] myBooks = new int[MAXBOOKS];
	
	//password is protected so that it will be private for subclasses
	protected String password;
	
	
	/**
	* Logs the user into the system.
	*
	* @param username - the username attempt to log in
	* @param password - the password attempt to log in
	* @return true if the user was logged in, false otherwise
	*/
	public boolean LogIn(String username, String password)
	{
		if ((username == this.username) && (password == this.password))
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
	public double GetFine(int i)
	{
		//If it is past due and we are the holder, we owe money.
		//an index of 0 means that there is no book, so check that first.
		if((i > 0) && (Library.collection[i].dateDue > Library.currentDate) && (Library.collection[i].holder == username))
			return Math.min(MAXFINE, ((Library.collection[i].dateDue - Library.currentDate) * FINEPERDAY));
		else 
			return 0; //it isn't due, so we don't owe anything.
		
	}
	
	/**
	* Gets the total fine owed by this user, from all of the books.
	*
	* @return the total fine from all books taken out by this user
	*/
	public double GetTotalFine ()
	{
		double totalFine = 0.0;
		
		for(int curbook : myBooks)	
		{
			//each index in myBooks is an int that refers to the library collection.
			totalFine += GetFine(curbook); //so we pass in that index instead of a loop counter here
		}
		
		return totalFine;
	}
	
	/**
	* checks out a book
	*
	* @param i the index of the global collection of the book
	* @return true if the operation was successful, false otherwise.
	*/
	public boolean CheckOutBook(int i)
	{
		//first check if the book has no holder
		if((Library.collection[i].holder == "") || (Library.collection[i].onHold && Library.collection[i].holder == username))
		{
			//check the book out for one week.
			Library.collection[i].holder = username;
			Library.collection[i].dateDue = Library.currentDate + 7;
			Library.collection[i].onHold = false; //checked out books cannot be on hold
		
			//find the first empty slot in the mybooks list, and replace it with this index.
			int j = 0;		
			while(myBooks[j] != 0)
				j++;
		
			myBooks[j] = i;
			
			return true;
		}
		else 
			return false; //someone else checked this book out so we can't.
	}
	
	
	/**
	* returns a book
	*
	* @param i the index of the global collection of the book
	* @return true if the operation was successful, false otherwise.
	*/
	public boolean ReturnBook(int i)
	{
		//make sure we're trying to return a book we checked out in the first place
		if (Library.collection[i].holder == username)
		{
			Library.collection[i].holder = "";
			Library.collection[i].dateDue = 0;
		
			myBooks[i] = 0;
		
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
	public boolean RenewBook(int i)
	{
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
	public int GetWhenDue(int i)
	{
		if (Library.collection[i].holder != username)
		{
			return -1;
		}
		else return (Library.collection[i].dateDue);
	}
	
	/**
	* Test driver
	*
	*/
	public static void main(String [] args)
	{
	
		//use the collection initializer from meetens example
		
		
	}
	

}
