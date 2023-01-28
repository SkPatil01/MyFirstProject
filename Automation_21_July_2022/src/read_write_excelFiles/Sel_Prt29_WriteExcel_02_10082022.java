package read_write_excelFiles;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Sel_Prt29_WriteExcel_02_10082022 {

	public static void main(String[] args) throws Throwable {
		
		//create the empty workbook first
		
		XSSFWorkbook test1=new XSSFWorkbook();
		
		//now create empty sheet in a workbook and give name to the sheet
		XSSFSheet testSheet=test1.createSheet("td_KK_01");
		
		//use data structure to create the data that we want to store in excel
		//I'm using 2D array of Object type
		
		Object testData[][]= {
				 	 	 	 	{"TC_ID","TestScenario","TestData","Status"},
				 	 	 	 	{"KK_01","Verify textbox","admin","blocked"},
				 	 	 	 	{"KK_02","Verify btn spell","Button","pass"},
				 	 	 	 	{"KK_03","Verify pswd", 1234,"pass"},
				 	 	 	 	{"KK_04", "Verify OTP",15081947,"pass"},
				 	 	 	 	{"KK_05","Verify bandwitdth","40Mbps","Pass" },
				 	 	 	 	{"KK_06","Verify LTE Conn","4G", "failed"}
	
		};
		
		//now we have created the 2D array that means data is in row and column.
		//we will check the total row count and column count which are required in forloop index
		
		int row=testData.length; //this length; method of array will return the row size
		int col=testData[0].length;//here it will return the columns in particular row
		
		//now we have rows and columns size...we'll use forloop to store this data in
		//excel file which we have created above by the name "td_KK_01" .
		
		for(int i=0; i<row; i++) {
			XSSFRow iRow=testSheet.createRow(i); //here we created i row
			
			for(int j=0; j<col;j++) {
				XSSFCell iCell=iRow.createCell(j); //here we created j cell of i row
				//now get the ij location data from Object array store it in variable
				Object values=testData[i][j];   
				
				//now we have the ij location data in "values" variable 
				//check this data type before placing it in Excel Sheet Cell
				if(values instanceof String)
					iCell.setCellValue((String)values);  //here we are typecasting beacuase
				if(values instanceof Integer)           //values are in object type 
					iCell.setCellValue((Integer)values);
				if(values instanceof Boolean)
					iCell.setCellValue((Boolean)values);
			}
		}
		System.out.println("Data stored in excell sheet :td_KK_01");
		//now we need to open that particular new workbook using FileOutputStream class 
		//then write data on new open workbook and give name to file
		
		String path=".\\TestData_KK_01\\KK_01.xlsx";
		String filePath="E:\\Testing\\KK_02.xlsx";
		
		FileOutputStream newFile=new FileOutputStream(path);
		FileOutputStream newFile1=new FileOutputStream(filePath);
		//now workbook of name KK_01 blank created.. no write all data on it
		
		test1.write(newFile);
		test1.write(newFile1);
		
		System.out.println("Successfully created a new file");
		
		test1.close();
	}

}

