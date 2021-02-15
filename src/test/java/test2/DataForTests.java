package test2;

import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider(name="dataForPost")
	public Object[][] dataForPost()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0] = "Bordi";
		obj[0][1] = "Mother of Bride";
		
		obj[1][0] = "Anondo Da";
		obj[1][1] = "Father of Bride";
		
		return obj;
	}
	
	@DataProvider(name="dataForPost2")
	public Object[][] dataForPost2()
	{
		return new Object[][]
				{
					{"Sayan Mother","Mother of Groom"},
					{"Sayan Father","Father of Groom"}
				};
	}
	
	@DataProvider(name="dataForDelete")
	public Object[] dataForDelete()
	{
		return new Object[]
				{
					7,8,9
				};
	}
	
	
}
