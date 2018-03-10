
public abstract class CarType implements Car{
	
	protected final int fCap;
	protected int fLevel;
	protected boolean rented, tankFull;
	
	public CarType(int fCap){
		this.fCap = fCap;
		fLevel = 0;
		tankFull = false;
		rented = false;
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
	
	public int getFuelCap(){
		return fCap;
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
	
}
