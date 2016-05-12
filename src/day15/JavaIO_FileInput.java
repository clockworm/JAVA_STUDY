package day15;

//字节流 适合图片 视频 等 转出二进制字节
import java.io.FileInputStream;
import java.io.IOException;

public class JavaIO_FileInput {
	public static void main(String[] args) {
		String filepath = "E:\\JAVA\\day2\\Operator.java";
		// read1(filepath);
		read2(filepath);
		// read3(filepath);
		read4();
	}

	// 单个字节直接读取 不能识别汉字 因为中文是2个字节 即1个汉字被分解成1个字节输出 所以乱码 3M exe 18722
	public static void read1(String filepath) {
		try {
			FileInputStream in = new FileInputStream(filepath);
			int b;
			long start = System.currentTimeMillis();
			while ((b = in.read()) != -1) {
				System.out.print((char) b);
			}
			in.close();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 利用内存缓存 读取数据 先加载进内存再进行String构造出来打印读取 3M exe 7-11
	public static void read2(String filepath) {
		try {
			long start = System.currentTimeMillis();
			FileInputStream in = new FileInputStream(filepath);
			// 构造缓存区
			byte[] b = new byte[1024 * 4];
			// 返回读取的个数 把读出的字节放入b字节数组中.从0开始最多读b.length的个数
			// int count = in.read(b, 0, b.length); //一次性写入内存
			// int count = in.read(b);// 全部读入b字节数组中
			// 第一个参数 字节数组,从0开始到读取的个数count。构造出String
			// String s = new String(b, 0, count);
			// System.out.println(s);//一次性读取
			int i;
			while ((i = in.read(b, 0, b.length)) != -1) { // 写入内存一次 读一次
				String s = new String(b, 0, i);
				System.out.println(s);
			}
			/*
			 * 案例：字节数组转化成字符串
			 */
			// byte[] b2 = new byte[] { 'a', 'b', 'c', 'd', 'e', 'f' };
			// String s2 = new String(b2, 0, b2.length);
			// System.out.println(s2);
			in.close();
			long end = System.currentTimeMillis();
			System.out.println(end - start);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 一次性读入 可读文件大小 缺点是 文件过大内存使用超载 建議文件小於1M的情況下使用
	public static void read3(String filepath) {
		try {
			long start = System.currentTimeMillis();
			FileInputStream in = new FileInputStream(filepath);
			int length = in.available();// 可读文件大小 缺点是 文件过大内存使用超载
			byte[] by = new byte[length];
			in.read(by);
			String st = new String(by);
			System.out.println(st);
			in.close();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// txt文件编码显示问题。 是什麼編碼就得轉化成什麼編碼顯示 用String構造重寫encode編碼
	public static void read4() {
		try {
			FileInputStream in = new FileInputStream("E:\\2.txt");
			int length = in.available();
			byte[] bytes = new byte[length];
			in.read(bytes);
			// String s = new String(bytes, "gbk");
			// System.out.println(s);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
