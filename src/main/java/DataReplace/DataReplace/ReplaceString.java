package DataReplace.DataReplace;

import java.io.*;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReplaceString {	
	
	public static void main(String[] args) throws IOException, CsvException {
		try {
			ReplaceString replaceString = new ReplaceString();
			replaceString.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void execute() throws Exception {
		try {
			String[] headers = readCSV("E:\\test\\newInput.csv");
			this.readTXT("E:\\test\\data\\e.txt");
			this.writeXLSX( "E:\\test\\out.xlsx" , headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] readCSV(String file) throws IOException, CsvException {
		CSVReader reader = new CSVReader( new FileReader(file));
		List<String[]> allRows;
		allRows = reader.readAll();
		return allRows.get(0);
		}
	
	public void readTXT(String file) throws IOException {
		FileReader fr = new FileReader("E:\\test\\data\\e.txt");
		BufferedReader br = new BufferedReader(fr);
		String oldContent = "";
		String line = br.readLine();
		while(line != null) {
			oldContent = oldContent + line + System.lineSeparator();
			line = br.readLine();
		}
		String newContent = oldContent.replaceAll("$1_$" , "new word");
		FileWriter writer = new FileWriter("E:\\test\\data\\b.txt");
		writer.write(newContent);
		br.close();
		writer.close();
	}
	
	public void writeXLSX(String file, String[] headers) {
		try {
			String excelFileName = "E:\\test\\output.xlsx";
			String sheetName = "Sheet1" ;
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(sheetName);
			for ( int r = 0; r < headers.length; r++) {
				XSSFRow row = sheet.createRow(r);
				XSSFCell cell = row.createCell(0);
				XSSFCell cell1 = row.createCell(1);
				cell.setCellValue(headers[r]);
				cell1.setCellValue("nw");
			}
			FileOutputStream fos = new FileOutputStream(excelFileName);
			wb.write(fos);
			fos.flush();
			fos.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}		
}
	

