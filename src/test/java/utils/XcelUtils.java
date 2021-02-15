package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XcelUtils {
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public XcelUtils(String sPath,String sName) throws IOException
	{
		wb = new XSSFWorkbook(sPath);
		sheet = wb.getSheet(sName);
	}
	
	public static void getRowCount()
	{
		System.out.println(sheet.getPhysicalNumberOfRows());
	}

	public static void getCellData()
	{
		
		DataFormatter frmtr  = new DataFormatter();
		Object value = frmtr.formatCellValue(sheet.getRow(0).getCell(1));
		System.out.println(value);
	}
	
	public static void callEm()
	{
		getRowCount();
		getCellData();
	}
	
	
}
