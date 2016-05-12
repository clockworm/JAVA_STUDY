package day16;

import java.io.PrintWriter;

//写入缓存区
public class JavaIO_PrintWriter {
	public static void main(String[] args) {
		String path = "C:\\job1.java";
		writePrint(path);
	}

	public static void writePrint(String path) {
		try {
			PrintWriter out = new PrintWriter("C:\\job3.txt");
			/*
			 * PrintWriter out2 = new PrintWriter(new
			 * FileOutputStream("C:\\job4.txt"), true); //自动刷新缓存区
			 */
			out.print("hello,你好");
			out.println();
			out.write("你好吗？");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
