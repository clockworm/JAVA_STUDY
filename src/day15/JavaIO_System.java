package day15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

//标准输入输出流
public class JavaIO_System {
	public static void main(String[] args) {
		// inSystem();z
		// outSystem();
	}

	// 标准输入流
	public static void inSystem() {
		byte[] bytes = new byte[1024 * 10];
		try {
			while (true) {
				System.out.println("请输入：");
				int b = System.in.read(bytes, 0, bytes.length);
				String s = new String(bytes, 0, b);
				if (s.trim().equals("end")) {
					System.in.close();
					System.out.print("退出!");
					break;
				}
				System.out.print(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 标准输出流
	public static void outSystem() {
		try {
			FileOutputStream out = new FileOutputStream("C:\\2.txt");
			PrintStream print = new PrintStream(out);
			print.print("中国加油,我们是黄种人");
			print.flush();
			print.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
