import org.junit.Assert;

public class SmallCarTest {
	final static SmallCarTest sct = new SmallCarTest();
	final SmallCar sc = new SmallCar();
	
	public static void main(String[] agrs){
		sct.testGetFuel();
		sct.testIsRented();
		sct.testGetReg();
	}


	private void testGetFuel(){
		
		Assert.assertEquals(0, sc.getFuel());
		
		System.out.println("testGetFuel success");

	}
	
	private void testIsRented(){
		
		Assert.assertEquals(false, sc.isRented());
		
		sc.rentCar();
		
		Assert.assertEquals(true, sc.isRented());
		
		System.out.println("testIsRented success");
		
	}
	
	private void testGetReg(){
		
		Car[] smallCars = new Car[10];
		
		for(int i=0; i<10; i++){
			SmallCar c = new SmallCar();
			smallCars[i] = c;
		}
		
		Assert.assertEquals("a0011", smallCars[9].getReg());
		
		System.out.println("testGetReg success");
	}
	
	
	
}