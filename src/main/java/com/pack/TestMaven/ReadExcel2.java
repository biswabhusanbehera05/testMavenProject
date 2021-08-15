package com.pack.TestMaven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
//passed the data from the Excel to your application.

public class ReadExcel2 {

/*	public static void main(String[] args) throws BiffException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		WebElement unm = driver.findElement(By.id("email"));	
	    WebElement pwd = driver.findElement(By.id("pass"));
		
		Workbook wb = Workbook.getWorkbook(new File("C:\\Users\\Dell\\Desktop\\sample.xls"));

		Sheet sh = wb.getSheet("abc");
		
		for(int i=0; i<sh.getRows() ; i++) { 
			
            //System.out.println("u name: "+sh.getCell(0,i).getContents());
			
			//System.out.println("password: "+sh.getCell(1,i).getContents());
			
	    
	    unm.sendKeys(sh.getCell(0,i).getContents());
	    pwd.sendKeys(sh.getCell(1,i).getContents());
	    
	    Thread.sleep(2000);
	    pwd.clear();
	    unm.clear();
	    
		}

	}*/

	 WebDriver driver=null;
	@Test(testName="My_testcase")
	public void myTestcase() throws BiffException, IOException, InterruptedException
	{
		System.out.println("test");
		MyTestCaseLogic obj = new MyTestCaseLogic();
		obj.callingMylogic(driver);
	}
	@BeforeTest
	public void loadDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("before test");
	}
	
	@AfterTest
	public void closeDriver()
	{
		System.out.println("after test");
		driver.close();
	}
	
	/*@BeforeTest
	public void setup(ITestContext ctx) {
	    TestRunner runner = (TestRunner) ctx;
	    runner.setOutputDirectory("D:\\testNg-report");
	}*/

}
