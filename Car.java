
public interface Car {

	public String getReg();

	public int getFuelCap();

	public int getFuel();

	public boolean tankFull();

	public boolean isRented();

	public void rentCar();

	public void returnCar();

	public int addFuel(int fuel);

	public int drive(int distance);

}
