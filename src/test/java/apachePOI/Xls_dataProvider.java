package apachePOI;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class Xls_dataProvider {

		static Workbook book;
		static Sheet sheet;
		
		public static String testdata_sheet_path = "C:\\Users\\vishal mittal\\Desktop\\testdata.xlsx";
		
		public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException 
		{
			
			FileInputStream file=  new FileInputStream(testdata_sheet_path);
					
				book = WorkbookFactory.create(file);
			
			sheet = book.getSheet(sheetName);
			
            int row= sheet.getLastRowNum();
			
			int col= sheet.getRow(0).getLastCellNum();
			
			Object[][] inputData= new Object[row][col];
			for(int i=0; i<row;i++)
			{
				for( int j=0; j<col;j++)
				{
					inputData[i][j]= sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return inputData;
			
					
			
			
			}
			
			
		}
		
		
		



