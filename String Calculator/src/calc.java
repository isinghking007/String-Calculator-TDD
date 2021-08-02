import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

 
public class calc {
	
	private Calculator cal;
	
	@Before
	public void init()
	{
		cal=new Calculator();
	}
	

	@Test
	public void emptyCheck() {
		assertEquals(0, cal.calculate(""));
	}

	@Test
	public void singleNumberCheck() {
		assertEquals(1, cal.calculate("1"));
	}

	@Test
	public void twoNumberCheck(){
		assertEquals(3, cal.calculate("1,2"));
	}

	@Test
    public void threeNumberCheck(){
    	assertEquals(6, cal.calculate("1,2,3"));
    }

    @Test
    public void newLineCheck(){
    	assertEquals(6, cal.calculate("1\n2,3"));
    }
    @Test
    public void negativeNumberCheck(){
    	try {
    			cal.calculate("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			cal.calculate("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }

	public static void main(String[] args)
	{
		
	}
}
