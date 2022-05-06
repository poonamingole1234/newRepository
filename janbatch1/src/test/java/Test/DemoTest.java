package Test;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ListenerTest.class)
public class DemoTest {
	
	@Test
	public void test() {
		System.out.println("I have modified the test ");
	}
	
	
	@Test
	public void test2() {
		Assert.assertTrue(false);
		System.out.println("I have modified the test2 ");
		
	}
	
	@Test(dependsOnMethods = {"test2"})
	public void test3() {
		
	}
	
	@Test
	public void sample() {
		System.out.println("Sample");
	}
}
