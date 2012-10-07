class Librarian extends User
{
	public static Book[] collection;
	
	void AddBook(String title, String author, String subject, int pageCount)
	{
		Library.collectionSize++;
		collection[Library.collectionSize].title=title;
		collection[Library.collectionSize].author = author;
		collection[Library.collectionSize].subject = subject;
		collection[Library.collectionSize].pageCount = pageCount;
	}
	void AddBook(String title, String author)
	{
		Library.collectionSize++;
		collection[Library.collectionSize].title=title;
		collection[Library.collectionSize].author = author;
		collection[Library.collectionSize].subject = "";
		collection[Library.collectionSize].pageCount = -1;
	}
	void changeBookTitle(int index, String title)
	{
		collection[index].title = title;
	}
	void changeBookAuthor(int index, String author)
	{
		collection[index].author = author;
	}
	void changeBookSubject(int index, String Subject)
	{
		collection[index].Subject = Subject;
	}
	void changeBookPageCount(int index, String pageCount)
	{
		collection[index].pageCount = pageCount;
	}
}
