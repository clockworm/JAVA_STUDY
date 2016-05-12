package day16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//bufferedReader可以读一行了
public class JavaIO_BufferedReader {
	public static void main(String[] args) {
		String path = "C:\\job1.java";
		read(path);
	}

	public static void read(String path) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String str = null;
			while ((str = in.readLine()) != null) {
				System.out.print(str + "\n");
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}