package DataReplace.DataReplace;

import java.io.*;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class ReplaceString {

	public static void main(String[] args) throws IOException {
		try {
			ReplaceString replaceString = new ReplaceString();
			replaceString.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		try {
			String[] headers = readCSV("E:\\test\\input\\newInput.csv");
			this.readTXT("E:\\test\\input\\e.txt", headers);
			this.writeXLSX("E:\\test\\out.xlsx", headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] readCSV(String file) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(file));
		List<String[]> allRows;
		allRows = reader.readAll();
		System.out.println(allRows.get(0));
		return allRows.get(0);
	}

	public void readTXT(String file, String[] headers) {
		try {
			FileReader fr = new FileReader("E:\\test\\input\\01.txt");
			BufferedReader br = new BufferedReader(fr);
			String oldContent = "";
			String line = br.readLine();
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				line = br.readLine();
			}
			int i = 1;
			String s = Integer.toString(i);
			String key = "\\$" + s + "_\\$";
			System.out.println("keyy     " + key);
			String newContent = oldContent.replaceAll(key, headers[i]);
			File fi = new File("E:\\test\\data\\" + s + ".txt");
			FileWriter writer = new FileWriter(fi);
			writer.write(newContent);
			br.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeXLSX(String file, String[] headers) throws CsvValidationException {
		try {
			int i = 1;
			CSVReader reader = new CSVReader(new FileReader("E:\\test\\input\\newInput.csv"));
			String[] thisLine;
			reader.readNext();
			while ((thisLine = reader.readNext()) != null) {
				XSSFWorkbook wb = new XSSFWorkbook();
				XSSFSheet sheet = wb.createSheet("Sheet1");
				for (int r = 0; r < headers.length; r++) {
					XSSFRow row = sheet.createRow(r);
					XSSFCell cell0 = row.createCell(0);
					XSSFCell cell1 = row.createCell(1);
					cell0.setCellValue(headers[r]);
					cell1.setCellValue(thisLine[r]);
				}
				String fn = "E:\\test\\out\\" + i + ".xlsx";
				FileOutputStream fos = new FileOutputStream(fn, false);
				wb.write(fos);
				fos.flush();
				// fos.close();
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
