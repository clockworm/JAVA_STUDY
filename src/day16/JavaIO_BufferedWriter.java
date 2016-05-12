package day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//BufferedWriter可以写一行了 必須自己換行
public class JavaIO_BufferedWriter {
	public static void main(String[] args) {
		String path = "C:\\job1.java";
		read(path);
	}

	public static void read(String path) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\job2.txt"));
			String str = null;
			while ((str = in.readLine()) != null) {
				out.write(str); //写入
				out.newLine();//写入一行
				out.flush();
			}
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}