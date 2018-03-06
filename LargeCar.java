
public class LargeCar implements Car {

	private final int fCap;
	private final String reg;
	private int fLevel;
	private boolean tankFull;
	private boolean rented;
	private static int noOfLCars;
	
	

	public LargeCar(){
		fCap = 49;
		fLevel = 0;
		tankFull = false;
		rented = false;
		reg = "a" + String.format("%04d", noOfLCars);
	}
	
	public String getReg(){
		return reg;
	}
	
	public int getFuelCap(){
		return fCap;
	}
	
	public int getFuel(){
		return fLevel;
	}
	
	public boolean tankFull(){
		if(tankFull){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isRented(){
		return rented;
	}
	
	public void rentCar(){
		rented = true;
	}
	
	public void returnCar(){
		rented = false;
	}
	
	public int addFuel(int fuel){
		if(rented){
			if(tankFull){
				return 0;
			} else if(fLevel+fuel>fCap){
				fLevel = fCap;
				return fCap-fLevel;
			}
		} else{
			return 0;
		}
		return -1;
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
