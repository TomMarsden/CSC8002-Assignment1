import java.util.HashMap;
import java.util.Map;

public final class LicenceNumber {

	private static final Map<String, LicenceNumber> lNumbers = new HashMap<String, LicenceNumber>();
	private final String strRep;
	private final int driverNo;
	
	private LicenceNumber(String fInitial, String sInitial, int driverNo){
		strRep = fInitial+"-"+sInitial+"-"+Integer.toString(driverNo);
	}
	
	public static LicenceNumber getInstance(String fInitial, String sInitial, int driverNo){
		String strRep = fInitial+"-"+sInitial+"-"+Integer.toString(driverNo);
		LicenceNumber lNumber = lNumbers.get(strRep);
		if(lNumber == null){
			lNumber = new LicenceNumber(fInitial,sInitial,driverNo);
			lNumbers.put(strRep, lNumber);
		}
		return lNumber;
	}
	
	public String toString(){
		return lNumber;
	}
}
