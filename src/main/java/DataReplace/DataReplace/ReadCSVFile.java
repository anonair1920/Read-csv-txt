package DataReplace.DataReplace;

import java.io.*;
import java.util.*;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile {
	public static void main (String[] args) throws IOException, CsvException {
		System.out.println("working");		
	CSVReader reader = new CSVReader( new FileReader("E:\\test\\newInput.csv"));
	List<String[]> allRows = reader.readAll();
	String[] header = allRows.get(0);
		System.out.println(Arrays.toString(header));

	}
}
