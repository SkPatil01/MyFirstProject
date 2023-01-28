package read_write_excelFiles;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sel_Prt_26_Excel_Reading {

	@SuppressWarnings({ "incomplete-switch", "rawtypes" })
	public static void main(String[] args) throws IOException {
		
		String filePath="E:\\Testing\\Testers_2022.xlsx";
		
		//Input file stream class will read the excel file of given path
		FileInputStream inputfile=new FileInputStream(filePath);
		
		//Open the workbook from selected excel sheet
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(inputfile);
		
		//Extracted the sheet as per index .. index zero is the first sheet
		XSSFSheet sh=wb.getSheetAt(0);
		
		//check the no.of rows and columns present in sheet
		int rows=sh.getLastRowNum();
		int columns=sh.getRow(1).getLastCellNum();
		
		//we need to write 2 for loops -- one for row and another for column
		for(int i=1; i<=rows;i++) {
			for(int j=0; j<=columns-1;j++) {
				XSSFCell data=sh.getRow(i).getCell(j);// fetch data from row i and column j
				System.out.print(data+"  "); //printing the data
			}
			System.out.println();
		}
		
		System.out.println("--------Printed all the data using for loop------ ");
		//for loop with methods checking the data type present in cell
		for(int i=1; i<=rows;i++) {
			XSSFRow row=sh.getRow(i); //rows in particular sheet
			for(int j=0; j<=columns-2;j++) {
				
				XSSFCell cell=row.getCell(j); //cells in particular row
				switch(cell.getCellType())   //checking the datatype of cell 
				{ 
				//if it is string then using getStringCellValue we will fetch the data
				case STRING:System.out.print(cell.getStringCellValue());
				break;
				
				//if it is Numeric then using getNumericCellValue we will fetch the data
				case NUMERIC:System.out.print(cell.getNumericCellValue());
				break;
				
				//if it is Boolean then using getBooleanCellValue we will fetch the data
				case BOOLEAN: System.out.print(cell.getBooleanCellValue());
				break;
								
				}
				System.out.print("  |  ");
			}
					
			System.out.println();
			
		}
		
		System.out.println("--------Printed by checking the datatype----------");
		
		System.out.println("----------Printing using iterator method-----------");
		Iterator iterator = sh.iterator(); //method from XSSFSheet class
		
		while(iterator.hasNext()) {
			XSSFRow row=(XSSFRow)iterator.next(); //typecasting
			Iterator cell = row.cellIterator(); //method for XSSFRow class
			while(cell.hasNext()) {
				XSSFCell celldata=(XSSFCell)cell.next();
				switch(celldata.getCellType())   //checking the datatype of cell 
				{ 
				//if it is string then using getStringCellValue we will fetch the data
				case STRING:System.out.print(celldata.getStringCellValue());
				break;
				
				//if it is Numeric then using getNumericCellValue we will fetch the data
				case NUMERIC:System.out.print(celldata.getNumericCellValue());
				break;
				
				//if it is Boolean then using getBooleanCellValue we will fetch the data
				case BOOLEAN: System.out.print(celldata.getBooleanCellValue());
				break;
								
				}
				System.out.print("  |  ");
			}
			System.out.println();
			
		}
		System.out.println("-------Successfully printed using iterator------");
		
		
		
		
		
	}

}
