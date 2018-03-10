
public class SmallCar extends CarType{

	private final Registration reg;
	private static int noOfSCars = 0;



	public SmallCar(){
		super(49);
		noOfSCars++;
		reg = Registration.getInstance(noOfSCars);
	}

	public String getReg(){
		return reg.toString();
	}

	public int drive(int distance){
		int consumption = Math.round(distance/20);
		if(rented){
			if(fLevel >0){
				fLevel -= consumption;
				return consumption;
			} else{
				return 0;
			}
		} else{
			return 0;
		}
	}

}
