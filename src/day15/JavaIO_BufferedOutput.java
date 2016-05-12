package day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaIO_BufferedOutput {
	public static void main(String[] args) {
		String path = "E:\\JAVA\\day5\\Job.java";
		writeBuffered(path);
	}

	public static void writeBuffered(String path) {
		try {
			InputStream in = new FileInputStream(path);
			BufferedInputStream bfin = new BufferedInputStream(in);
			OutputStream out = new FileOutputStream("C:\\Job4.java");// 直接写入磁盘
			BufferedOutputStream bfout = new BufferedOutputStream(out); // 也可以直接用out来写入不用写入缓存再写入磁盘
			byte[] bytes = new byte[1024 * 5];
			int b;
			while ((b = bfin.read(bytes, 0, bytes.length)) != -1) {
				// String s = new String(bytes, 0, b);
//				out.write(bytes, 0, b);// 直接写入磁盘
				bfout.write(bytes, 0, b);
				bfout.flush();// 刷新缓存区
			}
			bfout.close();
			out.close();
			bfin.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
