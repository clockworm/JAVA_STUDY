package day15;

//怎么读怎么写
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件读写操作
public class JavaIO_FileOutput {

	public static void main(String[] args) {
		String path = "E:\\JAVA\\day4\\Job.java";
		// write1(path);
		write2(path);
		// write3(path);
		write4();
	}

	public static void write1(String path) {
		try {
			FileInputStream in = new FileInputStream(path);
			// 如果没有文件创建 有则自动删除重新创建 写入时不会出现乱码 会拼接自动编译
			FileOutputStream out = new FileOutputStream("C:\\job1.java");
			int b;
			while ((b = in.read()) != -1) {
				out.write(b); // 写
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write2(String path) {
		try {
			FileInputStream in = new FileInputStream(path);
			FileOutputStream out = new FileOutputStream("C:\\job2.java");
			byte[] bytes = new byte[1024 * 5];
			int b;
			while ((b = in.read(bytes, 0, bytes.length)) != -1) {
				out.write(bytes, 0, b);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write3(String path) {
		try {
			FileInputStream in = new FileInputStream(path);
			FileOutputStream out = new FileOutputStream("C:\\job3.java");
			int size = in.available();
			byte[] bytes = new byte[size];
			in.read(bytes);
			out.write(bytes);
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// txt文件编码显示问题。 是什麼編碼就得轉化成什麼編碼顯示 用String構造重寫encode編碼
	// 读写没有问题
	public static void write4() {
		try {
			FileInputStream in = new FileInputStream("E:\\1.txt");
			FileOutputStream out = new FileOutputStream("E:\\11.txt");
			int length = in.available();
			byte[] bytes = new byte[length];
			in.read(bytes);
			out.write(bytes);
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
