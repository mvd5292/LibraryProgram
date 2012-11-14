/** Project: Library System (Zach Kehs, Meeten Doshi, Zac Clark)
 * 
 *	This class creates and manages the database for all the other classes to use. 
 * 
 * @author Meeten Doshi
 * @version 1.0 10/8/2012
 */
class Library
{
	
	private static final int MAX_SIZE = 500;				//MAX_SIZE would be how large the array would be.
	public static int collectionSize = 1;					//collectionSize keeps how many books are in the database right now.
	public static int userCount = 0;						//Keeps a count of how many users are there in the database.
	public static Book[] collection = new Book[MAX_SIZE];	//This is the actual database for book.
	public static User[] userTable = new User[MAX_SIZE];	//This is the database to store users information.
	public static int currentDate = 0; 						//Keeps track of the current date. 
	
	//Main method/Test Driver.
	public static void main(String args[])
	{
		//Test 1 for SearchByName.
		collection[collectionSize] = new Book();
		collection[collectionSize].title = "Harry Potter 1";
		collectionSize++;
		collection[collectionSize] = new Book();
		collection[collectionSize].title = "Hunger Games 1";
		collectionSize++;
		collection[collectionSize] = new Book();
		collection[collectionSize].title = "The Great Gatsby";
		System.out.println("Test 1 - Search by name of the book: Harry Potter 1");
		for(int i = 1; i <= collectionSize; i++)
		{
			System.out.println("Index: " + i + " Book: " +collection[i].title);
		}
		System.out.println();
		int[] titleResult  = new int[collectionSize];
		titleResult = searchByName("Harry Potter 1");
		for(int i = 0; i <collectionSize; i++)
		{
			if(titleResult[i]!=0)
			{
				System.out.print("Search Result: ");
				System.out.println(titleResult[i]);
			}
		}
		//Test 2 for SearchByAuthor.
		collectionSize=1;
		collection[collectionSize].author = "J.K. Rowling";
		collectionSize++;
		collection[collectionSize].author = "Suzanne Collins";
		collectionSize++;
		collection[collectionSize].author = "F. Scott Fitzgerald";
		collectionSize++;
		collection[collectionSize] = new Book();
		collection[collectionSize].author = "J.K. Rowling";
		collection[collectionSize].title = "Harry Potter 2";
		System.out.println();
		System.out.println("Test 2 - Search by name of the author: J.K. Rowling");
		for(int i = 1; i <= collectionSize; i++)
		{
			System.out.println("Index: " + i + " Book: " +collection[i].title + "; Author: " +collection[i].author);
		}
		int [] authorResult = new int[collectionSize];
		authorResult = searchByAuthor("J.K. Rowling");
		for(int i = 0; i<collectionSize; i++)
		{
			if(authorResult[i]!=0)
			{
				System.out.print("Search Result: ");
				System.out.println(authorResult[i]);
			}
		}
		
		//Test 3 for SearchBySubject.
		collectionSize=1;
		collection[collectionSize].subject = "Fiction";
		collectionSize++;
		collection[collectionSize].subject = "Fiction";
		collectionSize++;
		collection[collectionSize].subject = "Classic";
		collectionSize++;
		collection[collectionSize].subject = "Fiction";
		System.out.println();
		System.out.println("Test 3 - Search by subject: Fiction");
		for(int i = 1; i <= collectionSize; i++)
		{
			System.out.println("Index: " + i + " Book: " +collection[i].title + "; Author: " +collection[i].author + "; Subject: " +collection[i].subject);
		}
		int [] subjectResult = new int[collectionSize];
		subjectResult = searchBySubject("Fiction");
		for(int i = 0; i<collectionSize; i++)
		{
			if(subjectResult[i]!=0)
			{
				System.out.print("Search Result: ");
				System.out.println(subjectResult[i]);
			}
		}
	}
	
	//SearchByName checks the entire database with the string passed in (name) and returns all the index
	//which are equal.
	//Parameter 1 - String name: Passed in from the main. Whatever the user wants to search for. 
	public static int[] searchByName(String name)
	{
		int indexArray[] = new int[collectionSize];
		int ctr=0;
		
		for(int i=1; i<=collectionSize; i++)
		{			
			if(name==collection[i].title)
			{
				indexArray[ctr]=i;
				ctr++;					
			}
		}
		return indexArray;
	}
	
	//SearchByAuthor checks the entire database with the authors name which is passed in and returns all the indices
	//which have the same authors name. 
	//Parameter 1 - String author: The user can search books for a particular author. 
	public static int[] searchByAuthor(String author)
	{
		int indexArray[] = new int[collectionSize];
		int ctr=0;
		for(int i=1; i<=collectionSize; i++)
		{
			if(author==collection[i].author)
			{
				indexArray[ctr]=i;
				ctr++;	
			}
		}
		return indexArray;
	}
	
	//SearchBySubject checks the entire database with the subject that the user is looking for and returns the indices
	//Parameter 1 - String subject: Whatever subject the user wants to search for. 
	public static int[] searchBySubject(String subject)
	{
		int indexArray[] = new int[collectionSize];
		int ctr=0;
		for(int i=1; i<=collectionSize; i++)
		{
			if(subject==collection[i].subject)
			{
				indexArray[ctr]=i;
				ctr++;
			}
		}
		return indexArray;
	}
}
