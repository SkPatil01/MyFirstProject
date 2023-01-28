package read_write_excelFiles;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Sel_Prt25_ReadWrite_ExcelFiles {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		//Locating the required excel sheet using it's path in File object
		File src=new File("C:\\Users\\DELL\\Desktop\\GDCA.xlsx");
		
		//To load the file as Input 
		FileInputStream fis=new FileInputStream(src);   
		
		
		//To load the WorkBook from Excel Sheet 
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		//To get the Particular sheet from workbook use getSheet() method from XSSFWorkbook class
		XSSFSheet sh=wb.getSheet("Shares_1");
		
		int rowCount=sh.getLastRowNum();
		short cellCount_row2=sh.getRow(2).getLastCellNum();
		
		System.out.println("Total rows are: "+rowCount +"\n"+"Total cell in 2nd row are: "+cellCount_row2);
		
		for(int i=1; i<=sh.getLastRowNum();i++) {
			for(int j=3; j<=sh.getRow(i).getLastCellNum()-1;j++) {
				XSSFCell data=sh.getRow(i).getCell(j);
				System.out.print(data+"  ");
			}
			System.out.println();
		}
		System.out.println("Excel Printed Successfully");
		
		
		

	}

}
