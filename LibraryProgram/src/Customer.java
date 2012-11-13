/* Project: Library System (Zach Kehs, Meeten Doshi, Zac Clark)
 * 
 * This class is a subclass of User.
 * It does not have librarian powers, just a customer
 * 
 * @author Zach Kehs
 * @version 1.0 10/8/2012
 */
public class Customer extends User
{
	/**
	* Calculates the fine from a single book.
	*
	* @param i the index of the global collection of the book
	* @return the total fine from the book
	*/
	@Override
	public double getFine(int i)
	{
		//If it is past due and we are the holder, we owe money.
		//an index of 0 means that there is no book, so check that first.
		if((i > 0) && (Library.collection[i].dateDue < Library.currentDate) && (Library.collection[i].holder == username) && !(Library.collection[i].onHold))
			return Math.min(MAXFINE, ((double)(Library.currentDate - Library.collection[i].dateDue) * FINEPERDAY));
		else 
			return 0.0; //it isn't due, so we don't owe anything.
		
	}
	
	/**
	* Gets the total fine owed by this user, from all of the books.
	*
	* @return the total fine from all books taken out by this user
	*/
	@Override
	public double getTotalFine ()
	{
		double totalFine = 0.0;
		
		for(int curbook : myBooks)	
		{
			if (curbook > 0)
			{
				//each index in myBooks is an int that refers to the library collection.
				totalFine += getFine(curbook); //so we pass in that index instead of a loop counter here
			}
		}
		
		return totalFine;
	}
	
	//Default constructor
	public Customer()
	{
		isLibrarian = false;
	}

}
