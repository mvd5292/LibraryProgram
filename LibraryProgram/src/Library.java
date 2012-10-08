class Library
{
	//!!! zkehs: The static variables might need to be initialized to start. The collection/usertable should be 999 big or something, with the count vars being 0? don't remember how exactly
	private static final int MAX_SIZE = 500;
	public static int collectionSize = 1;
	public static int userCount = 0;
	public static Book[] collection = new Book[MAX_SIZE];
	public static User[] userTable = new User[MAX_SIZE];
	public static int currentDate = 0; //added by zkehs
	
	public static void main(String args[])
	{
		collection[collectionSize] = new Book();
		collection[collectionSize].title = "Harry Potter 1";
		collectionSize++;
		collection[collectionSize] = new Book();
		collection[collectionSize].title = "Hunger Games 1";
		collectionSize++;
		collection[collectionSize] = new Book();
		collection[collectionSize].title = "The Great Gatsby";
		System.out.println("Test 1 - Search by name of the book");
		for(int i = 1; i <= collectionSize; i++)
		{
			System.out.println("Index: " + i + " Book: " +collection[i].title);
		}
		System.out.println();
		int[] titleResult  = new int[collectionSize];
		titleResult = SearchByName("Harry Potter 1");
		for(int i = 0; i <collectionSize; i++)
		{
			if(titleResult[i]!=0)
			{
				System.out.print("Search Result: ");
				System.out.println(titleResult[i]);
			}
		}
		collectionSize=1;
		collection[collectionSize].author = "J.K. Rowling";
		collectionSize++;
		collection[collectionSize].author = "F. Scott Fitzgerald";
		collectionSize++;
		collection[collectionSize].author = "Suzanne Collins";
		collectionSize++;
		collection[collectionSize] = new Book();
		collection[collectionSize].author = "J.K. Rowling";
		collection[collectionSize].title = "Harry Potter 2";
		System.out.println();
		System.out.println("Test 2 - Search by name of the author");
		for(int i = 1; i <= collectionSize; i++)
		{
			System.out.println("Index: " + i + " Book: " +collection[i].title + "; Author: " +collection[i].author);
		}
		int [] authorResult = new int[collectionSize];
		authorResult = SearchByAuthor("J.K. Rowling");
		for(int i = 0; i<collectionSize; i++)
		{
			if(authorResult[i]!=0)
			{
				System.out.print("Search Result: ");
				System.out.println(authorResult[i]);
			}
		}
		collectionSize=1;
	}
	public static int[] SearchByName(String name)
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
	public static int[] SearchByAuthor(String author)
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
	public static int[] SearchBySubject(String subject)
	{
		int indexArray[] = new int[collectionSize];
		int ctr=0;
		for(int i=1; i<collectionSize; i++)
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
