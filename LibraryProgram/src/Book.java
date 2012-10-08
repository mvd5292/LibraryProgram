//Book Class
//Zach kehs
public class Book
{
	public String title;
	public String author;
	public String holder;
	public String subject;
	
	public int pagecount;
	
	public boolean onHold;
	
	public int dateDue; //we originally thought this was going to be a function, but a public int will work better
	
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
	
}

//No functions, so we don't need a test driver.
