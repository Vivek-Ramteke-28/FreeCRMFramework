package com.crm.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	static Workbook book;
	static Sheet sheet;
	

	
	public static long page_load_timeout = 20;
	public static long implicit_wait = 10;
	
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName)	{
		FileInputStream file = null;
		try {
			file = new FileInputStream("D:\\Vivek\\SeleniumWorkSpace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xls");
			}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;

}
}
