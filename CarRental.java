import java.util.ArrayList;
import java.util.HashMap;

public class CarRental {
	
	//Initialising ArrayLists to hold the 30 small cars and 20 large cars.
	
	static final ArrayList<Car> smallCars = new ArrayList<>(30);
	static final ArrayList<Car> largeCars = new ArrayList<>(20);
	static HashMap<DrivingLicence, Car> carMap = new HashMap<>();
	
	public static void main(String[] args) {
		
		//Populating ArrayLists with cars.
		
		for(int i = 0; i < 30; i++){
			SmallCar c = new SmallCar();
			smallCars.add(c);
		}
		
		for(int i = 0; i < 20; i++){
			LargeCar c = new LargeCar();
			largeCars.add(c);
		}
		
		//Testing code
		
		/**
		Car c = smallCars.get(3);
		Car c2 = largeCars.get(3);
		
		System.out.println(availableCars(c));
		System.out.println(availableCars(c2));
		
		c.rentCar();
		c2.rentCar();
		
		System.out.println(availableCars(c));
		System.out.println(availableCars(c2));
		
		for(int i = 0; i < 1; i++){
			System.out.println(getRentedCars().get(0));
			System.out.println(getRentedCars().get(1));
		}
		*/

	}
	
	public static int availableCars(Car car){
		int count = 0;
		
		if(car instanceof SmallCar){
			for(Car c: smallCars){
				if(!c.isRented()){
					count++;
				}
			}
		} else if(car instanceof LargeCar){
			for(Car c: largeCars){
				if(!c.isRented()){
					count++;
				}
			}
		}
		return count;
	}
	
	public static ArrayList<Car> getRentedCars(){
		ArrayList<Car> rentedCars = new ArrayList<>();
		
		for(Car c: smallCars){
			if(c.isRented()){
				rentedCars.add(c);
			}
		}
		for(Car c: largeCars){
			if(c.isRented()){
				rentedCars.add(c);
			}
		}
		return rentedCars;
	}
	
	public static boolean issueCar(DrivingLicence d, Car c){
		
		if(d.isFull() && d.getAge() > 21){
			if(c instanceof SmallCar && !c.isRented()){
				if(d.rentSmallCheck()){
					carMap.put(d, c);
					c.addFuel(c.getFuelCap());
					c.rentCar();
				}
				
			} else if(c instanceof LargeCar){
				if(d.getAge() > 25 && !c.isRented()){
					if(d.rentLargeCheck()){
						carMap.put(d, c);
						c.addFuel(c.getFuelCap());
						c.rentCar();
					}
				}
			}
		}
		
		return false;
		
	}
	
	public static Car getCar(DrivingLicence d){
		return carMap.get(d);
	}

	public static int terminateRental(DrivingLicence d){
		int fuel = -1;
		
		if(carMap.get(d) instanceof Car){
			Car c = carMap.get(d);
			carMap.remove(d);
			if(c.getFuel()==c.getFuelCap()){
				fuel = 0;
			} else if(c.getFuel() < c.getFuelCap()){
				fuel = c.getFuelCap() - c.getFuel();
			}
		}
		
		return fuel;
	}
}
