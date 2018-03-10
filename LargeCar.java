
public class LargeCar extends CarType {
	
	private final Registration reg;
	private static int noOfLCars = 0;

	public LargeCar(){
		super(60);
		noOfLCars++;
		reg = Registration.getInstance(noOfLCars);
	}
	
	public String getReg(){
		return reg.toString();
	}
	
	public int drive(int distance){
		int consumption1 = Math.round(distance/10);
		int consumption2 = Math.round((distance-50)/15);
		if(rented){
			if(distance <=50){
				if(fLevel >0){
					fLevel -= consumption1;
					return consumption1;
				}
			} else if(distance >50){
				if(fLevel >0){
					fLevel-=consumption1;
					fLevel-=consumption2;
					return consumption1 + consumption2;
				}
			} else{
				return 0;
			}
		}
		return -1;
	}

}
