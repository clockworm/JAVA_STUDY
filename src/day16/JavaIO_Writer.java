package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//字符流的写入
public class JavaIO_Writer {
	public static void main(String[] args) {
		String path = "E:\\JAVA\\day3\\Job.java";
		write1(path);
		write2(path);

	}

	// 写入方式1
	public static void write1(String path) {
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(path));
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("C:\\job1.java"));
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
				out.flush();
			}
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 写入方式2
	public static void write2(String path) {
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(path));
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("C:\\job1.java"));
			char[] chars = new char[1024 * 5];
			int c;
			while ((c = in.read(chars, 0, chars.length)) != -1) {
				out.write(chars, 0, c);
				out.flush();
			}
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
