package read_write_excelFiles;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class Sel_Prt30_WriteExcel_InExcel {

	public static void main(String[] args) throws Throwable {
		
		//Input file path stored in string variable
		String fPath="E:\\Testing\\KK_02.xlsx";
		//opened given file using FileInputStream class object
		FileInputStream iFile=new FileInputStream(fPath);//filepath given
		@SuppressWarnings("resource")
		XSSFWorkbook iWbook=new XSSFWorkbook(iFile);//reading the workbook
		XSSFSheet iSheet=iWbook.getSheetAt(0);//read 1st sheet at index 0
		
		XSSFWorkbook oWbook=new XSSFWorkbook(); //created new blank workbook
		XSSFSheet oSheet=oWbook.createSheet("KK_03");//created new sheet in workbook
		
		int row=iSheet.getLastRowNum(); //total rows in input sheet
		int col=iSheet.getRow(0).getLastCellNum();//total colmn in 1st row of ip sheet
		
		for(int i=0; i<row; i++) { 
			XSSFRow oRow=oSheet.createRow(i); //creating row in new sheet KK_03
			for(int j=0; j<col; j++) {
				XSSFCell oCell=oRow.createCell(j);//creating colmns for i row
				String value=iSheet.getRow(i).getCell(j).toString(); //reading data from ip sheet
				oCell.setCellValue(value);//storing data in new sheet KK_03
				
			}
			
		}
		System.out.println("Data stored in new sheet");
		String oPath="E:\\Testing\\KK_03.xlsx"; //new sheet file path with req.file name provided
		FileOutputStream oFile=new FileOutputStream(oPath);//opened new file 
		oWbook.write(oFile); //writing data in new file workbook using input workbook
		System.out.println("Successfully copied data on new sheet");
		oWbook.close(); //closing the workbook.
		

	}

}
