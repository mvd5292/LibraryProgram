class Library
{
	public static int collectionSize;
	public static int userCount;
	public static Book[] collection;
	public static User[] userTable;
	
	public static int SearchByName(String name)
	{
		int indexArray[] = new int[collectionSize];
		ctr=0;
		for(int i=0; i<collectionSize; i++)
		{
			if(name=collection.title)
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
		ctr=0;
		for(int i=0; i<collectionSize; i++)
		{
			if(name==collection[i].author)
			{
				indexArray[ctr]=i;
				ctr++;	
			}
		}
		return indexArray;
	}
	public static int SearchBySubject(String subject)
	{
		int indexArray[] = new int[collectionSize];
		ctr=0;
		for(int i=0; i<collectionSize; i++)
		{
			if(name=collection.subject)
			{
				indexArray[ctr]=i;
				ctr++;
			}
		}
		return indexArray;
	}
}
