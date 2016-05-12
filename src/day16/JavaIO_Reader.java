package day16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//字符流都是字节流构造而来（适配器模式） 适合文本的操作  
//字符流都带缓冲区
public class JavaIO_Reader {
	public static void main(String[] args) {
		String path = "C:\\aa.txt";
		read1(path);
		// read2(path);
	}

	// 读取方式1
	public static void read1(String path) {
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(path),"gbk");
			int c;
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 读取方式2
	public static void read2(String path) {
		try {
			InputStreamReader in = new InputStreamReader(new FileInputStream(path));
			char[] chars = new char[1024 * 5];
			int c;
			while ((c = in.read(chars, 0, chars.length)) != -1) {
				String s = new String(chars, 0, c);
				System.out.print(s);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
