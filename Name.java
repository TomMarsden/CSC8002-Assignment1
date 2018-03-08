import java.util.HashMap;
import java.util.Map;

public final class Name {
	
	private static final Map<String, Name> NAMES = new HashMap<String, Name>();
	private final String firstName, lastName, strRep;
	
	private Name(String firstName, String lastName,String stRep) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.strRep = stRep;
	}
	
	public static Name getInstance(String firstName, String lastName){
		String stRep = firstName + " " + lastName;
		Name n = NAMES.get(stRep);
		if (n == null) {
			n = new Name(firstName, lastName, stRep); // unique instance
			NAMES.put(stRep , n);
		}
		return n;
	}
	
	public String getFirstName(){
		return firstName; 
	}
	
	
	public String getLastName(){ 
		return lastName; 
	}
	
	public String toString(){ 
		return strRep; 
	}
	
	public String getFirstInitial(){
		return firstName.split("")[0];
	}
	
	public String getSecondInitial(){
		return lastName.split("")[0];
	}
}
