package day15;

import java.io.UnsupportedEncodingException;

//编码方式怎么序列化就用什么编码编译，否则出现乱码
public class JavaEncode {

	public static void main(String[] args) {

		String str = "ADC成";
		byte[] b = str.getBytes();// 默认的是项目编码UTF-8 字母1個字節 漢字3個字節
		for (byte c : b) {
			System.out.print(Integer.toHexString(c & 0xFF) + " ");
		}
		print();
		try {
			byte[] b1 = str.getBytes("GBK");// GBK 字母1個字節 漢字2個字節
			for (byte c : b1) {
				System.out.print(Integer.toHexString(c & 0xFF) + " ");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		print();
		try {
			byte[] b1 = str.getBytes("utf-16be");// jdk的编码utf-16be 字母2個字節 漢字2個字節
			for (byte c : b1) {
				System.out.print(Integer.toHexString(c & 0xFF) + " ");
			}
			String s = new String(b1, "utf-16be"); //编码方式怎么序列化就用什么编码构建字符串，否则出现乱码
			System.out.println(s);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public static void print() {
		System.out.println();
		System.out.println("====================华丽分割线====================");
	}
}
