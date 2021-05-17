package DataReplace.DataReplace;

import java.io.*;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReplaceString {	
	
	public static void main(String[] args) throws IOException, CsvException {
		String[] headers = readCSV("E:\\test\\newInput.csv");
		readTXT("E:\\test\\data\\e.txt");
		writeXLSX("E:\\test\\output\\out.xlsx", headers);
	}
	
	public static String[] readCSV(String file) throws IOException, CsvException {
		CSVReader reader = new CSVReader( new FileReader(file));
		List<String[]> allRows;
		allRows = reader.readAll();
		return allRows.get(0);
		}
	
	public static void readTXT(String file) throws IOException {
		FileReader fr = new FileReader("E:\\test\\data\\e.txt");
		BufferedReader br = new BufferedReader(fr);
		String oldContent = "";
		String line = br.readLine();
		while(line != null) {
			oldContent = oldContent + line + System.lineSeparator();
			line = br.readLine();
			System.out.println("->" +line);
		}
		System.out.println(oldContent);
		String newContent = oldContent.replaceAll("${$1_$}" , "new word");
		System.out.println(newContent);
		FileWriter writer = new FileWriter("E:\\test\\data\\b.txt");
		writer.write(newContent);
		br.close();
		writer.close();
	}
	
	public static void writeXLSX(String file, String[] headers) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook( new FileInputStream(file));
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = null;		
		int i = 0;
		while((row = sheet.getRow(i)) != null){
			Cell cell = row.createCell(0);
			cell.setCellValue(headers[i]);
			i++;
}
		FileOutputStream fileout = new FileOutputStream("E:\\test\\output\\new.xlsx");
		wb.write(fileout);
	}		
}
	

