package day16;

import java.io.FileReader;
import java.io.FileWriter;

public class JavaIO_FileWriter {
	public static void main(String[] args) {
		String path = "C:\\job1.java";
		write(path);
	}

	public static void write(String path) {
		try {
			FileReader in = new FileReader(path);
			FileWriter out = new FileWriter("C:\\job2.txt");
			char[] chars = new char[1024 * 5];
			int c;
			while ((c = in.read(chars, 0, chars.length)) != -1) {
//				String s = new String(chars, 0, c);
//				out.write(s); //可以写入字符串
				out.write(chars, 0, c);
				out.flush();
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
