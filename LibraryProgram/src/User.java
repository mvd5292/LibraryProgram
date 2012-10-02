




public class User {

	public static final int MAXDAYSLATE = 20;
	public static final int MAXFINE = 20;
	public static final double FINEPERDAY = .25;
	
	//these 3 need to be public - zkehs
	public boolean isLoggedIn;
	public boolean isLibrarian;                                                 
	public String username;
	
	
	private String passWord;
	
	public double getFine(int daysLate){
		
		return (daysLate * FINEPERDAY);
	}
	
	public double getTotalFine (){
		
		if (daysLate > MAXDAYSLATE)
			return MAXFINE + getFine(daysLate);
		else 
			return getFine(daysLate);
	}
	
	
	
	
	

}
