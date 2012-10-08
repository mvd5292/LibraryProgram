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
	private final int MAXDAYSLATE = 20;
	private final double MAXFINE = 20.0;
	private final double FINEPERDAY = 0.25;
	//public constants:
	public final int MAXBOOKS = 20;
	
	public boolean isLoggedIn;
	public boolean isLibrarian;                                                 
	public String username;
	public int currentDate = 1;
	
	public int[] myBooks = new int[MAXBOOKS];
	
	//password is protected so that it will be private for subclasses
	protected String password;
	
	/**
	* Calculates the fine from a single book.
	*
	* @param i the index of the global collection of the book
	* @return the total fine from the book
	*/
	public double getFine(int i)
	{
		//If it is past due and we are the holder, we owe money.
		//an index of 0 means that there is no book, so check that first.
		if((i > 0) && (Library.collection[i].dateDue > currentDate) && (Library.collection[i].holder == username))
			return ((Library.collection[i].dateDue - currentDate) * FINEPERDAY);
		else 
			return 0; //it isn't due, so we don't owe anything.
		
	}
	
	/**
	* Gets the total fine owed by this user, from all of the books.
	*
	* @return the total fine from all books taken out by this user
	*/
	public double getTotalFine ()
	{
		double totalFine = 0.0;
		
		for(int curbook : myBooks)	
		{
			//each index in myBooks is an int that refers to the library collection.
			totalFine += getFine(curbook); //so we pass in that index instead of a loop counter here
		}
		
		return totalFine;
	}
	
	/**
	* checks out a book
	*
	* @param i the index of the global collection of the book
	* @return true if the operation was successful, false otherwise.
	*/
	public boolean checkOutBook(int i)
	{
		//first check if the book has no holder
		if(Library.collection[i].holder == "")
		{
		
			Library.collection[i].holder = username;
			Library.collection[i].dateDue = currentDate + 7;
		
		
			int j = 0;		
			while(myBook[j] != 0)
				j++;
		
			myBooks[j] = i;
			
			return true;
		}
		
		else 
			return false;
	}
	
	public boolean returnBook(int i){
		
		if (Library.collection[i].holder = username)
		{
			Library.collection[i].holder = "";
			Library.collection[i].dateDue = 0;
		
			myBooks[i] = 0;
		
			return true;
		}
		else 
			return false;
		
	}
	
	public boolean renewBook(int i){
		
		if (Library.collection[i].holder = username)
		{
			Library.collection[i].dateDue += 7;

			return true;
		}
		else
			return false;
	}
	
	
	public int getWhenDue(int i){
		
		return (Library.collection[i].dateDue);
		
	}
	
	
	
	

}
