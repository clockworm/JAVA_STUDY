package day15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//缓存读入流 把读入的字节直接放入内存
public class JavaIO_BufferedInput {

	public static void main(String[] args) {
		String path = "E:\\JAVA\\day7\\Point.java";
		readBuff1(path);
	}

	public static void readBuff1(String path) {
		try {
			InputStream in = new FileInputStream(path);
			BufferedInputStream bfin = new BufferedInputStream(in); // 写入缓存
			byte[] bytes = new byte[1024 * 5];
			int b;
			while ((b = bfin.read(bytes, 0, bytes.length)) != -1) {
				String s = new String(bytes, 0, b);
				System.out.println(s);
			}
			bfin.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
