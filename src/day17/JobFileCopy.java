package day17;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件类使用字节流操作
public class JobFileCopy {
	public static void main(String[] args) {
		String filepath = "E:\\开发工具\\W.P.S.5597.50.379.exe";
		String toAddress = "D:\\W.P.S.5597.50.379.exe";
		long start = System.currentTimeMillis();
		try {
			copyFile(filepath, toAddress);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	// 先读取文件 拷贝到目的地
	public static void copyFile(String filepath, String toAddress) throws IOException {
		BufferedInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filepath));
			out = new FileOutputStream(toAddress);
			byte[] bytes = new byte[1024 * 5];
			int b;
			while ((b = in.read(bytes, 0, bytes.length)) != -1) {
				out.write(bytes, 0, b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			in.close();
		}
	}

}
