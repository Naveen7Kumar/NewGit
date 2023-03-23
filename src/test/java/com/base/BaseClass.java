package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void browserLaunch(String url) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.get(url);
		driver.manage().window().maximize();

	}

	public static String stringData(int row, int cell) throws IOException {
		File loc = new File("C:\\Users\\www.abcom.in\\eclipse-workspace\\CucumberAutomation\\testdata\\pom1.xlsx");
		FileInputStream input = new FileInputStream(loc);

		Workbook w = new XSSFWorkbook(input);

		Sheet s = w.getSheet("sheet1");

		Row r = s.getRow(row);

		Cell c = r.getCell(cell);
		
		String stringCellValue = c.getStringCellValue();
		
		return stringCellValue;
		
		
	}
	public static String numericData(int row, int cell) throws IOException {
		File loc = new File("C:\\Users\\www.abcom.in\\eclipse-workspace\\CucumberAutomation\\testdata\\pom1.xlsx");
		FileInputStream input = new FileInputStream(loc);
		
		Workbook w = new XSSFWorkbook(input);
		
		Sheet s = w.getSheet("sheet1");
		
		Row r = s.getRow(row);
		
		Cell c = r.getCell(cell);
		
		double numericCellValue = c.getNumericCellValue();
		long l = (long)numericCellValue;
		
		String valueOf = String.valueOf(l);
		return valueOf;
		
		
	}

	public static void currentUrl() {
		driver.getCurrentUrl();
	}

	public static void title() {
		driver.getTitle();
	}

	public static void drpDown(WebElement element, String Value) {
		Select s = new Select(element);
		s.selectByVisibleText(Value);

	}

	public static void btnClick(WebElement element) {
		element.click();

	}

	public static void inputText(WebElement element, String Value) {
		element.sendKeys(Value);
	}

	public static void quitBrowser() {
		driver.quit();
	}

}
