import java.time.LocalDate;
import java.time.Period;

public class DrivingLicence {
	private final Name n;
	private final LocalDate dob, doi;
	private final LocalDate curDate = LocalDate.now();
	private LicenceNumber lNumber;
	private boolean full;
	private static int noOfDrivers = 0;
	private Period age, p;
	
	public DrivingLicence(String fName, String lName, LocalDate dob, LocalDate doi, boolean full){
		noOfDrivers++;
		n = Name.getInstance(fName,lName);
		if(n.toString().length()==0) throw new IllegalArgumentException("Empty String");
		this.dob=dob;
		this.doi=doi;
		this.full=full;
		lNumber = LicenceNumber.getInstance(n.getFirstInitial(), n.getSecondInitial(), noOfDrivers);
	}

	public String getName() {
		return n.toString();
	}

	public LocalDate getDOB() {
		return dob;
	}

	public String getlNumber() {
		return lNumber.toString();
	}

	public LocalDate getDoi() {
		return doi;
	}
	
	public boolean isFull() {
		return full;
	}
	
	public boolean rentSmallCheck(){
		age = Period.between(curDate, dob);
		p = Period.between(curDate, doi);
		if(age.getYears() >=18 && p.getYears() >=1 && full){
			return true;
		}
		return false;
	}
	
	public boolean rentLargeCheck(){
		age = Period.between(curDate, dob);
		p = Period.between(curDate, doi);
		if(age.getYears() >=25 && p.getYears() >=5 && full){
			return true;
		}
		return false;
	}
	
	public int getAge(){
		age = Period.between(curDate, dob);
		return age.getYears();
	}

	
	
}
