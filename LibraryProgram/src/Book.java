/* Project: Library System (Zach Kehs, Meeten Doshi, Zac Clark)
 * 
 * This class is the book, which makes up the collection[] array in Library.
 * 
 * @author Zach Kehs
 * @version 1.0 10/8/2012
 */
public class Book
{
	public String title;
	public String author;
	public String holder; //the username of the associated user
	public String subject;
	
	public int pagecount;
	
	public boolean onHold; //true if the book is not checked out but is on hold with a holder
	
	public int dateDue; //the date the book is due
	
	public Book()
	{
		//default constructor
		title = "";
		author = "";
		holder = "";
		subject = "";
		pagecount = -1;
		onHold = false;
		dateDue = 0;
	}
	
	public String toString()
	{
		return "Title: " + title + "\nAuthor: " + author + "\nHolder: " + holder + "\nSubject: " + subject + "\nPageCount: " + pagecount + "\nOn Hold: " + onHold + "\nDate Due: " + dateDue;
	}
	
}

//No functions, so we don't need a test driver.
