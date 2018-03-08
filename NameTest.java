import org.junit.Assert;

public class NameTest {
	
	final static NameTest nt = new NameTest();

	public static void main(String[] args){
		final Name n = Name.getInstance("Thomas", "Marsden");
		nt.testName();
		nt.testGetFirstName(n);
		nt.testGetLastName(n);
		nt.testGetFirstInitial(n);
		nt.testGetSecondInitial(n);
	}
	
	private void testName(){
		Name n = Name.getInstance("Kenneth", "Brown");
		
		Assert.assertEquals("Kenneth",n.getFirstName());
		Assert.assertEquals("Brown", n.getLastName());
		
		System.out.println("testName success");
	}
	
	private void testGetFirstName(Name n){
		Assert.assertEquals("Thomas",n.getFirstName());
		Assert.assertNotEquals(null, n.getFirstName());
		
		System.out.println("testGetFirstName success");
	}
	
	private void testGetLastName(Name n){
		Assert.assertEquals("Marsden", n.getLastName());
		Assert.assertNotEquals(null, n.getLastName());
		
		System.out.println("testGetLastName success");
	}
	
	private void testGetFirstInitial(Name n){
		Assert.assertEquals("T", n.getFirstInitial());
		
		System.out.println("testGetFirstInitial success");
	}
	
	private void testGetSecondInitial(Name n){
		Assert.assertEquals("M", n.getSecondInitial());
		
		System.out.println("testGetSecondInitial success");
	}
}
