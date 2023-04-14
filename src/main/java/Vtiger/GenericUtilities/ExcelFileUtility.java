package Vtiger.GenericUtilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of generic methods related to excel sheet
 * @author A
 *
 */
public class ExcelFileUtility {
/**
 * this method will read data from excel sheet
 * 
 * @param SheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws IOException
 */
	public String readDataFromExcel(String SheetName,int rowNo,int cellNo) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelfilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * this method write data into excel
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String SheetName,int rowNo,int cellNo,String value) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.excelfilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row rw=sh.createRow(rowNo);
		Cell cel=rw.createCell(cellNo);
		cel.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.excelfilePath);
		wb.write(fos);
		wb.close();
	}
		
public Object[][] readDataFromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IConstantsUtility.excelfilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(SheetName);
	int lastRow=sh.getLastRowNum();
	int lastCell=sh.getRow(0).getLastCellNum();
	
	Object[][] data =new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
	
}
		
		
		
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	

