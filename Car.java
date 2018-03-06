
public interface Car {
	
	public String getReg();
	public int getFuelCap();
	public int getFuel();
	public boolean tankFull();
	public boolean isRented();
	public int addFuel(int fuel);
	public int drive(int distance);
	public void rentCar();
	public void returnCar();
	
}
