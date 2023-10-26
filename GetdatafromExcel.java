package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetdatafromExcel {

	public static Map<String, String> getTestData(String TCID) throws IOException {
		Map<String, String> testData = new HashMap<String, String>();
		Map<String, Integer> columnHeaders;
		Cell val;
		
		// Create an object of File class to open xlsx file
		try {
			FileReader reader = new FileReader("TestData.properties");
			Properties p = new Properties(System.getProperties());
			p.load(reader);
			FileInputStream file = new FileInputStream(new File(p.getProperty("Enrollment.DataSheet")));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Login");
			columnHeaders = getColumnIndexes(sheet);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getCell(columnHeaders.get("TC_ID")).toString().trim().equalsIgnoreCase(TCID)) {
					@SuppressWarnings("unused")
					int rowNumidenf = row.getRowNum();
					System.out.println();
					for (String key : columnHeaders.keySet()) {
						val = row.getCell(columnHeaders.get(key));
						if (val != null)
							testData.put(key, val.toString().trim());
					}
					break;
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return testData;
	}

	public static Map<String, Integer> getColumnIndexes(XSSFSheet sheet) {
		// TODO Auto-generated method stub
		Map<String, Integer> headerIndexes = new HashMap<String, Integer>();
		Row headerRow = sheet.getRow(0);
		Iterator<Cell> cellIterator = headerRow.cellIterator();
		while (cellIterator.hasNext()) {
			
		Cell cell = cellIterator.next();
		headerIndexes.put(cell.getStringCellValue(), cell.getColumnIndex());
		}
		return headerIndexes;
	}

}
