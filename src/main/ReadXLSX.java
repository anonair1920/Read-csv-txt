package DataReplace.DataReplace;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSX {
    public static void main(String[] args) {
		readXLSXFile("D:\\test\\example.xlsx");
	}

	public static void readXLSXFile(String file) {
	try {
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = null;
		
		int i = 0;
		while ((row = sheet.getRow(i)) != null ) {
			double a = row.getCell(0).getNumericCellValue();
			double b = row.getCell(1).getNumericCellValue();
			double c = row.getCell(2).getNumericCellValue();
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			System.out.println("c = " + c);
			System.out.println("result : " + (a+b));
			if((a+b)==c) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
			Cell cell = row.createCell(3);
			cell.setCellValue(a+b==c);
			i++;
		}	
		OutputStream fileout = new FileOutputStream("D:\\test\\example_out.xlsx");
		wb.write(fileout);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
