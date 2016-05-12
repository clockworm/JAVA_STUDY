package day16;

import java.io.IOException;
import java.io.RandomAccessFile;

//随机读取 有指针  //文件下载 迅雷 多个文件 下载后开始合并重写 
public class JavaIO_RandomAccessFile {
	public static void main(String[] args) {
		String path = "C:\\2.txt";
		try {
			RandomAccessFile raf = new RandomAccessFile(path, "rw");
			raf.writeInt(1000);
			raf.writeUTF("Hello");
			raf.writeUTF("world");
			raf.seek(11); // 设置指针位置
			System.out.println(raf.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
