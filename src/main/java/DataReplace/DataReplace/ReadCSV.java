package DataReplace.DataReplace;

import java.io.*;
import com.opencsv.*;

public class ReadCSV {
    public static void main(String[] args) throws Exception {
		String[] thisLine;
		int i = 0;
		CSVReader reader = new CSVReader(new FileReader("E:\\test\\input\\newInput.csv"));
		while ((thisLine = reader.readNext()) != null) {
			i++;
			String filename = "E:\\test\\output\\output" + i +".txt";
			FileOutputStream outputStream = new FileOutputStream(filename, true);
			OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-16");
			BufferedWriter bw = new BufferedWriter(osw);
			System.out.print(thisLine);
		}
		bufferedWriter.write(thisLine);
		bufferedWriter.newLine();
		bufferedWriter.close();
}
