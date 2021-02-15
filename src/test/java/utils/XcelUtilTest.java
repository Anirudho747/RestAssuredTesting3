package utils;

import java.io.IOException;

import org.testng.annotations.Test;

public class XcelUtilTest {

	@Test
	public void callXcelUtils() throws IOException
	{
		XcelUtils xu = new XcelUtils("./Data/Book1.xlsx", "Sheet1");
		xu.callEm();
	}
	
}
