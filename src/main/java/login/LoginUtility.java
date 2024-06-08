package login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginUtility {
	FileInputStream file;
	Workbook workBook;
	public Object[][] getData(String sheetName)
	{
		try {
			file=new FileInputStream("./src/test/resources/LoginBookSheet.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		org.apache.poi.ss.usermodel.Sheet sheet=workBook.getSheet(sheetName);
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowCount-1][cellCount];
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				 data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return data;
	}
	
}
