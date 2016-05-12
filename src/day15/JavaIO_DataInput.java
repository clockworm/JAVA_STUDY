package day15;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//数据类型 读写流
public class JavaIO_DataInput {
	public static void main(String[] args) {
		readData();
	}

	public static void readData() {
		String path = "E:\\JAVA\\day3\\Job.java";
		try {
			FileInputStream in = new FileInputStream(path);
			DataInputStream indata = new DataInputStream(in);
			byte[] bytes = new byte[1024 * 5];
			int b;
			while ((b = indata.read(bytes, 0, bytes.length)) != -1) {
				String s = new String(bytes, 0, b);
				System.out.print(s);
			}
			indata.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
