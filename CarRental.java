import java.util.ArrayList;
import java.util.HashMap;

public class CarRental {
	
	//Initialising ArrayLists to hold the 30 small cars and 20 large cars.
	//Creates a HashMap to hold relations between drivers and the car they are renting. 
	
	static final Car[] smallCars = new Car[30];
	static final Car[] largeCars = new Car[20];
	static HashMap<DrivingLicence, Car> carMap = new HashMap<>();
	
	
	/*This method uses a for-each loop to run through every car in one of the two ArrayLists. It checks if they are rented and if so, it increments the count 
	 * of available cars and then returns the count when all have been checked.
	 */
	
	public static int availableCars(Car car){
		int count = 0; //Initialising count
		
		if(car instanceof SmallCar){  // checking to see which array to run through.
			for(Car c: smallCars){ 
				if(!c.isRented()){
					count++;  // If car is rented, then increment count and continue with for loop.
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
	
	// This method runs through every car in each ArrayList and if the car is rented, adds it to the ArrayList of rentedCars.
	
	public static ArrayList<Car> getRentedCars(){
		ArrayList<Car> rentedCars = new ArrayList<>(); // initialising array of cars.
		
		for(Car c: smallCars){ //Running through the array of small cars.
			if(c.isRented()){
				rentedCars.add(c);  // If the car is rented it is added to the ArrayList.
			}
		}
		for(Car c: largeCars){
			if(c.isRented()){
				rentedCars.add(c);
			}
		}
		return rentedCars;
	}
	
	// Method responsible for associating a driving licence and a car in the HashMap. Which is how we represent a person renting a car.
	
	public static boolean issueCar(DrivingLicence d, Car c){
		boolean success = false; // Boolean used to signify if the method executed properly or not. 
		
		if(!c.isRented()){  // Initial check to see if car is rented
			if(c instanceof SmallCar){ //checks what type of car c is.
				if(d.rentSmallCheck()){ //Calls method that verifies 3 requirements for renting small car.
					carMap.put(d, c); // adds the driving licence to HashMap and associates car with it. 
					c.addFuel(c.getFuelCap()); // fills car tank
					c.rentCar(); // sets car as rented so it cannot be rented again.
					success = true; // returns true to let the system know method executed fully.
				}
			} else if(c instanceof LargeCar){ 
				if(d.rentLargeCheck()){ //Calls method that verifies 3 requirements for renting large car.
					carMap.put(d, c);
					c.addFuel(c.getFuelCap());
					c.rentCar();
					success =  true;
				}
			}
		}
		
		return success;
		
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
