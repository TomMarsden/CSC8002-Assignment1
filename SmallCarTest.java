import org.junit.Assert;
import org.junit.Test;

public class SmallCarTest {
	final static SmallCarTest sct = new SmallCarTest();
	
	public static void main(String[] agrs){
		sct.testGetFuel();
		sct.testIsRented();
	}


	private void testGetFuel(){
		final SmallCar sc = new SmallCar();
		
		Assert.assertEquals(0, sc.getFuel());
		
		System.out.println("testGetFuel success");
	}
	
	private void testIsRented(){
		SmallCar sc = new SmallCar();
		
		Assert.assertEquals(false, sc.isRented());
		
		sc.rentCar();
		
		Assert.assertEquals(true, sc.isRented());
		
		System.out.println("testIsRented success");
		
	}

}