import java.util.HashMap;
import java.util.Map;

public final class Registration {
	
		private static final Map<String, Registration> Registrations = new HashMap<String, Registration>();
		private final String strRep;
		
		private Registration(int carNo){
			strRep = "b" + String.format("%04d", carNo);
		}
		
		public static Registration getInstance(int carNo){
			String strRep = "b" + String.format("%04d", carNo);
			Registration reg = Registrations.get(strRep);
			if(reg == null){
				reg = new Registration(carNo);
				Registrations.put(strRep, reg);
			}
			return reg;
		}
		
		public String toString(){
			return strRep;
		}
}
