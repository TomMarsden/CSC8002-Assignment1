

import org.junit.Assert;

public class SmallCarTest {
	final static SmallCarTest sct = new SmallCarTest();
	
	public static void main(String[] args){
		final SmallCar sc = new SmallCar();
		sct.testGetFuel(sc);
		sct.testIsRented(sc);
		sct.testGetReg(sc);
	}


	private void testGetFuel(SmallCar sc){
		
		Assert.assertEquals(0, sc.getFuel());
		
		System.out.println("testGetFuel success");

	}
	
	private void testIsRented(SmallCar sc){
		
		Assert.assertEquals(false, sc.isRented());
		
		sc.rentCar();
		
		Assert.assertEquals(true, sc.isRented());
		
		System.out.println("testIsRented success");
		
	}
	
	private void testGetReg(SmallCar sc){
		
		Car[] smallCars = new Car[10];
		
		for(int i=0; i<10; i++){
			SmallCar c = new SmallCar();
			smallCars[i] = c;
		}
		
		Assert.assertEquals("a0011", smallCars[9].getReg());
		
		System.out.println("testGetReg success");
	}
	
	
	
}