package day15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//数据类型 读写流
public class JavaIO_DataOutput {
	public static void main(String[] args) {
		// writeData();
		// out_Data();
		// in_Data();
	}

	public static void writeData() {
		String path = "E:\\JAVA\\day3\\Job.java";
		try {
			FileInputStream in = new FileInputStream(path);
			DataInputStream indata = new DataInputStream(in);
			FileOutputStream out = new FileOutputStream("C:\\Job5.java");
			DataOutputStream outdata = new DataOutputStream(out);
			byte[] bytes = new byte[1024 * 5];
			int b;
			while ((b = indata.read(bytes, 0, bytes.length)) != -1) {
				outdata.write(bytes, 0, b);
			}
			outdata.close();
			out.close();
			indata.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 文本写入操作
	public static void out_Data() {
		try {
			FileOutputStream out = new FileOutputStream("C:\\test.txt");
			DataOutputStream outdata = new DataOutputStream(out);
			outdata.writeInt(123);
			outdata.writeBoolean(false);
			outdata.writeDouble(12.35);
			outdata.writeUTF("中文");
			outdata.flush();
			outdata.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 文本读入操作 怎么写 就怎么读，不能只读某一处写入
	public static void in_Data() {
		try {
			String path = "C:\\test.txt";
			FileInputStream in = new FileInputStream(path);
			DataInputStream indata = new DataInputStream(in);
			int i = indata.readInt();
			boolean b = indata.readBoolean();
			double d = indata.readDouble();
			String s = indata.readUTF();
			System.out.println(i + "" + b + d + s + "");
			in.close();
			indata.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
