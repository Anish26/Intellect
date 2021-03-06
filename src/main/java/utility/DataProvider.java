package utility;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {

	public static String[][] getSheet(String dataSheetName) {
		System.out.println("The file name :::::"+dataSheetName);
		String[][] data = null ;

		try {
			FileInputStream fis = new FileInputStream("./data/"+dataSheetName+".xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// get the number of row
			int rowCount = sheet.getLastRowNum();
			System.out.println(rowCount);

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println(columnCount);
			data = new String[rowCount][columnCount];
			
			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){

							}

							data[i-1][j]  = cellValue; // add to the data array
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
