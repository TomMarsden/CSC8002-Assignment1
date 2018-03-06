
public class SmallCar implements Car{
	
	private final int fCap;
	private final String reg;
	private int fLevel;
	private boolean tankFull;
	private boolean rented;
	private static int noOfSCars = 0;
	
	

	public SmallCar(){
		noOfSCars++;
		fCap = 49;
		fLevel = 0;
		tankFull = false;
		rented = false;
		reg = "a" + String.format("%04d", noOfSCars);
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
		return tankFull;
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
