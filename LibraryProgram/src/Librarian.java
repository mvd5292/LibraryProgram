class Librarian extends user
{
	public static Book[] collection;

	void AddBook(String title, String author, String subject, int pageCount)
	{
		collection.title = title;
		collection.author = author;
		collection.subject = subject;
		collection.pageCount = pageCount;
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
