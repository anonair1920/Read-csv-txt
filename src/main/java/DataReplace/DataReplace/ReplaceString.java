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
			this.readTXT("E:\\test\\data\\e.txt", headers);
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
	
	public void readTXT(String file, String[] headers){
		try {
			FileReader fr = new FileReader("E:\\test\\data\\01.txt");
			BufferedReader br = new BufferedReader(fr);
			String oldContent = "";
			String line = br.readLine();
			while(line != null) {
				oldContent = oldContent + line +System.lineSeparator();
				line = br.readLine();
			}
//			for (int i = 1; i < headers.length; i++) {
			int i = 1;
				String s = Integer.toString(i);
				String key = "\\$"+ s +"_\\$";
				System.out.println("keyy     " +key);
				String newContent = oldContent.replaceAll(key, headers[i]);
				
//			}
			System.out.println(newContent);
			File fi = new File("E:\\test\\data\\"+s+".txt");
			FileWriter writer = new FileWriter(fi);
			writer.write(newContent);
			br.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeXLSX(String file, String[] headers) {
		try {
			String excelFileName = "E:\\test\\output.xlsx";
			String sheetName = "Sheet1" ;
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(sheetName);		
			XSSFRow row = sheet.createRow(0);
				for ( int c = 0; c < headers.length; c++) {
					XSSFCell cell = row.createCell(c);
					cell.setCellValue(headers[c]);
			}
//				for ( int f = 0; )
			FileOutputStream fos = new FileOutputStream(excelFileName);
			wb.write(fos);
			fos.flush();
			fos.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}		
}
	

