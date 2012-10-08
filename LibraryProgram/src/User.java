




public class User {

	public static final int MAXDAYSLATE = 20;
	public static final int MAXFINE = 20;
	public static final double FINEPERDAY = .25;
	public static final int MAXBOOKS = 20;
	
	//these 3 need to be public - zkehs
	public boolean isLoggedIn;
	public boolean isLibrarian;                                                 
	public String username;
	public int currentDate = 1;
	
	public int [] myBooks = new int [MAXBOOKS];
	
	
	private String passWord;
	
	public double getFine(int i){
		
		if(Library.collection[i].dateDue > currentDate)
			return ((Library.collection[i].dateDue - currentDate) * FINEPERDAY);
		else 
			return 0;
		
	}
	
	public double getTotalFine (){
		
		double totalFine;
		
		for(int i = 0; i < Library.collection[].length())
			totalFine += getFine(i);
				
		return totalFine;
		
	}
	
	public boolean checkOutBook(int i){
		
		if(Library.collection[i].holder = "")
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
			return false;''
			
		
		
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
