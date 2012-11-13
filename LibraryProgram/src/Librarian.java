/** Project: Library System (Zach Kehs, Meeten Doshi, Zac Clark)
 * 
 * Librarian.java is where the Librarian can add a book, and/or change the books information.
 *	
 * @author Meeten Doshi
 * @version 1.0 10/8/2012
 */
class Librarian extends User
{
	//Main method and the Test Driver. 
	public static void main(String args[])
	{
		//Test 1: Adding a book and printing it. 
		System.out.println("Test 1: Adding Book");
		Librarian Lib = new Librarian();
		Lib.addBook("Harry Potter 1", "J.K.Rowling", "Fiction", 567);
		System.out.println("\n" + Library.collection[1].toString());
		
		//Test 2: Adding a book with just a name of the book and author.
		System.out.println("\nTest 2: Adding Another Book");
		Lib.addBook("Hunger Games", "Suzanne Collins");
		System.out.println("\n" + Library.collection[2].toString());
		
		//Test 3: Changing the book title from Harry Potter 1 to Harry Potter 2
		Lib.changeBookTitle(1, "Harry Potter 2");
		System.out.println("\n" + Library.collection[1].toString());
		
		//Test 4: Changing the book from J K Rowling to Joanne Kathleen Rowling. 
		Lib.changeBookAuthor(1, "Joanne Kathleen Rowling");
		System.out.println("\n" + Library.collection[1].toString());
		
		//Test 5: Changing the second books subject from blank to Childrens fantasy.
		Lib.changeBookSubject(2, "Childrens Fantasy");
		System.out.println("\n" + Library.collection[2].toString());
		
		//Test 6: Changing the page count from -1 to 456.
		Lib.changeBookPageCount(2, 456);
		System.out.println("\n" + Library.collection[2].toString());
		
		//Test 7: Fines are 0.
		System.out.println("\n" + Lib.getFine(0));
		
		System.out.println("\n" + Lib.getTotalFine());
	}
	
	//This function takes in title, author, subject, and pageCount as parameters and add them to the database. 
	void addBook(String title, String author, String subject, int pageCount)
	{
		try
		{
			Library.collection[Library.collectionSize] = new Book();
			Library.collection[Library.collectionSize].title=title;
			Library.collection[Library.collectionSize].author = author;
			Library.collection[Library.collectionSize].subject = subject;
			Library.collection[Library.collectionSize].pagecount = pageCount;
			Library.collectionSize++;
		}
		catch(ArrayIndexOutOfBoundsException aioobe)
		{
		   System.out.println("You've entered an invalid array index.");
		}
	}
	
	//This function takes the books name and author and sets the other values which can later be changed. 
	void addBook(String title, String author)
	{
		Library.collection[Library.collectionSize] = new Book();
		Library.collection[Library.collectionSize].title=title;
		Library.collection[Library.collectionSize].author = author;
		Library.collection[Library.collectionSize].subject = "";
		Library.collection[Library.collectionSize].pagecount = -1;
		Library.collectionSize++;
	}
	
	//This function takes in the index of the book name to be changed and the title it should be changed to and it changes it. 
	void changeBookTitle(int index, String title)
	{
		Library.collection[index].title = title;
	}
	
	//This function takes the index where the librarian wants to make a change and the name of the author and makes the change.
	void changeBookAuthor(int index, String author)
	{
		Library.collection[index].author = author;
	}
	
	//This function changes the subject by taking in the index where it needs to be changed and the new subject. 
	void changeBookSubject(int index, String Subject)
	{
		Library.collection[index].subject = Subject;
	}
	
	//This function changes the pageCount by taking in the index where it needs to be changed and the new pagecount. 
	void changeBookPageCount(int index, int pageCount)
	{
		Library.collection[index].pagecount = pageCount;
	}
	
	//No fines for the librarian.
	@Override
	public double getFine(int i)
	{
		return 0.0; //No Fine for Librarian.
	}
	
	//No fines for the librarian.
	@Override
	public double getTotalFine()
	{
		return 0.0; //No Fine for Librarian.
	}
}
