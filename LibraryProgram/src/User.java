




public class User {

	public static final int MAXDAYSLATE = 20;
	public static final int MAXFINE = 20;
	public static final double FINEPERDAY = .25;
	
	private boolean isLoggedIn;
	private String username;
	private String passWord;
	
	public double getFine(int daysLate){
		
		return (daysLate * FINEPERDAY);
	}
	
	public double getTotalFine (int daysLate){
		
		if (daysLate > MAXDAYSLATE)
			return MAXFINE + getFine(daysLate);
		else 
			return getFine(daysLate);
	}
	
	
	
	
	

}
