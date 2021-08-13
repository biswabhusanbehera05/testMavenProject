package com.pack.TestMaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MyTestCaseLogic {

	public void callingMylogic(WebDriver driver) throws BiffException, IOException, InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Dell\\Downloads\\chrome Driver\\chromedriver.exe");
// hello
		driver.get("https://www.facebook.com/");

		Workbook wb = Workbook.getWorkbook(new File("C:\\Users\\Dell\\Desktop\\sample.xls"));

		Sheet sh = wb.getSheet("abc");

		BufferedReader br = new BufferedReader(new FileReader("E:\\Java practice\\locator.csv"));
		String line = null;
		WebElement unm = null;
		WebElement pwd = null;
		while ((line = br.readLine()) != null) {
			String arr[] = line.split("\\|");
			if (arr[0].equals("fb_username")) {
				
				unm = returnLocatorElement(driver, arr);
			}

			if (arr[0].equals("fb_pass")) {

				pwd = returnLocatorElement(driver, arr);
			}

			if (unm != null && pwd != null) {

				for (int i = 0; i < sh.getRows(); i++) {

					// System.out.println("u name: "+sh.getCell(0,i).getContents());

					// System.out.println("password: "+sh.getCell(1,i).getContents());

					unm.sendKeys(sh.getCell(0, i).getContents());
					pwd.sendKeys(sh.getCell(1, i).getContents());

					Thread.sleep(2000);
					pwd.clear();
					unm.clear();

				}
			}
		}

		// WebElement unm = driver.findElement(By.cssSelector("input[id=\"email\"]"));
		// WebElement pwd = driver.findElement(By.cssSelector("input[id=\"pass\"]"));

	}

	public WebElement returnLocatorElement(WebDriver driver, String arr[]) {

		if (arr[2].equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(arr[1]));

		else if (arr[2].equalsIgnoreCase("xpath"))
			return driver.findElement(By.xpath(arr[1]));

		else
			return null;

	}
}
