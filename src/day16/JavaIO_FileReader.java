package day16;
//缓存流操作
import java.io.FileReader;

public class JavaIO_FileReader {

	public static void main(String[] args) {
		String path = "C:\\job1.java";
		read(path);
	}

	public static void read(String path) {
		try {
			FileReader in = new FileReader(path);
			char[] chars = new char[1024 * 5];
			int c;
			while ((c = in.read(chars, 0, chars.length)) != -1) {
				String s = new String(chars, 0, c);
				System.out.print(s);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
