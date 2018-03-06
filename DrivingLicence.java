import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DrivingLicence {
	private final String name;
	private final Calendar dob;
	private String lNumber;
	private final Calendar doi;
	private boolean full;
	private static int noOfDrivers = 0;
	private final Calendar curDate = Calendar.getInstance();
	
	public DrivingLicence(String name,Calendar dob, Calendar doi,boolean full){
		noOfDrivers++;
		if(name.length()==0) throw new IllegalArgumentException("Empty String");
		String fInitial = name.split("s+")[0].split("")[0];
		String sInitial = name.split("s+")[1].split("")[0];
		this.name=name;
		this.dob=dob;
		this.doi=doi;
		this.full=full;
		lNumber = fInitial+"-"+sInitial+"-"+noOfDrivers;
		curDate.set(Calendar.HOUR_OF_DAY, 0);
	}

	public String getName() {
		return name;
	}

	public Calendar getDOB() {
		return dob;
	}

	public String getlNumber() {
		return lNumber;
	}

	public Calendar getDoi() {
		return doi;
	}
	
	public boolean rentSmallCheck(){
		int licAge;
		licAge = curDate.YEAR - doi.get(Calendar.YEAR);
		if(licAge >=1){
			return true;
		}
		return false;
	}
	
	public boolean rentLargeCheck(){
		int licAge;
		licAge = curDate.YEAR - doi.get(Calendar.YEAR);
		if(licAge >=5){
			return true;
		}
		return false;
	}
	
	public int getAge(){
		int age;
		age = curDate.YEAR - dob.get(Calendar.YEAR);
		return age;
	}

	public boolean isFull() {
		return full;
	}
	
	
}
