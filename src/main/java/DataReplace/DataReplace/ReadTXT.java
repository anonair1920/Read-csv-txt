package DataReplace.DataReplace;

import java.io.*;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ReadTXT {

	public static void main(String a, String b) throws IOException {
		// TODO Auto-generated method stub
		String input = "$1_$";
		FileInputStream fis = new FileInputStream("E:\\test\\data\\b.txt");
		String content = IOUtils.toString(fis, Charset.defaultCharset());
		content = content.replaceAll(input ,b);
		
	}

}
