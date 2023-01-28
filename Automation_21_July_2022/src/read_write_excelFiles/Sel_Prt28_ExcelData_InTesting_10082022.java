package read_write_excelFiles;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt28_ExcelData_InTesting_10082022 {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		
		String filePath="C:\\Users\\DELL\\Desktop\\GDCA.xlsx";
		FileInputStream file=new FileInputStream(filePath);
		
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(filePath);
		XSSFSheet sh=wb.getSheet("ID_Pswd");//open particular sheet
		
		Sheet a=WorkbookFactory.create(file).getSheetAt(1);//additional method to open sheet
		
		String id=sh.getRow(1).getCell(0).toString();
		String pd=a.getRow(1).getCell(1).toString();
		System.out.println(id+ " "+pd);
		
		
		Thread.sleep(1000);
		driver.findElement(By.id("txtUsername")).sendKeys(id);
		driver.findElement(By.id("txtPassword")).sendKeys(pd);
		
		js.executeScript("window.confirm('do u want to login')");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.id("btnLogin")).click();
		

	}

}
