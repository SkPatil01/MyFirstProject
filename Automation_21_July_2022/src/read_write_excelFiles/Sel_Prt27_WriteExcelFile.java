package read_write_excelFiles;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sel_Prt27_WriteExcelFile {

	public static void main(String[] args) throws IOException {
	
		
		//created a empty workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//created a empty sheet in a workbook
		XSSFSheet sheet=workbook.createSheet("Emp Data"); //assigned sheet name
		
		//created a 2D array of Object class so that any data can be stored
		Object sheetData[][]= {
				 	 	 	 	{"Emp_ID","Emp_Name","City"},
				 	 	 	 	{1001,"Rahul Salve","SamabhajiNagar"},
				 	 	 	 	{1002,"Rakesh Bhadane","Beed"},
				 	 	 	 	{1003,"Divya Shirole","Pune"},
				 	 	 	 	{1004,"Kishor Kere","SambhajiNagar"},
				 	 	 	 	{1005,"Renu Dhokte","Pune"}
				 	 	 	 	
		                       };
		
		int row=sheetData.length; //total rows in array
		int col=sheetData[0].length; //total columns in particular row
		
		System.out.println("Rows in 2D array are: "+row);
		System.out.println("Columns in 2D array are: "+col);
		
		for(int i=0; i<row;i++) {
			XSSFRow rows=sheet.createRow(i); //created the i row
			for(int j=0; j<col;j++) {
				XSSFCell cell=rows.createCell(j); //created the j cells for i row
				Object value=sheetData[i][j]; //getting data from array and storing it in value variable
				
				if(value instanceof String)    //checking the value variable data is of which type
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
				}
		}
	System.out.println("Successfully stored the data in sheet");

	//giving a filepath that i want to create with file name
	String filePath="E:\\Testing\\Kishor.xlsx";
	
	//opened a empty excel file at given location using outputstream
	FileOutputStream fileOp=new FileOutputStream(filePath);
	
	//writing all data in a empty file created at given location using created workbook
	workbook.write(fileOp);
	
	System.out.println("Workbook created finally");
	
	//closing the workbook
	
	workbook.close();
	
	
		
		
		
		
		
		

	}

}
