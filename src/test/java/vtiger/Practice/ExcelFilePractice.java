package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args) throws IOException {
		// Step 1:load the file in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step2:create a workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//step 3:get control over a sheet
		Sheet sheet=wb.getSheet("Organization");
		
   //step 4:get control over a row
		Row rw=sheet.getRow(0);
		
		//step 5:get control over a cell
		Cell ce=rw.getCell(2);
		
		//step 6:read the data inside the cell
		String value=ce.getStringCellValue();
		System.out.println(value);
		
		
		
	}

}
