package day13;

import java.util.Arrays;

public class JavaString {

	public static void main(String[] args) {
		char[] cr = { 'a', 'b', 'c', 'd' };
		String s1 = new String(cr, 0, 2); // 最后一个不包含 String s1 = new String(cr)
		System.out.println(s1);

		String s2 = "hello" + "world"; // String常量池
		String s3 = "helloworld";
		s2 = "a" + "b" + "c";
		s3 = "abc";
		System.out.println(s2 == s3); // 等价 jvm自动优化

		String s4 = "hello";
		String s5 = s4 + "world";
		// 不等价 new StringBuffer(s4).append("world");其中已经产生了一个新的空间
		System.out.println(s5 == s3);

		String s6 = "clock@qq.com";
		System.out.println(s6.endsWith("@qq.com")); // 是否为某某字符串结尾
		System.out.println(s6.substring(5, 6)); // 截取
		System.out.println(s6.indexOf("@"));
		System.out.println(s6.indexOf("ock"));
		System.out.println(s6.lastIndexOf("ock"));
		System.out.println(s6.substring(0, s6.indexOf("@")));

		String s7 = "abcccc";
		String s8 = "ABCccc";
		System.out.println(s7.equalsIgnoreCase(s8)); // 不区分
		System.out.println(String.valueOf(9).getClass());
		String s9 = "123";
		System.out.println(s9.compareTo("1234a2"));
		System.out.println(Integer.parseInt(s9));
		System.out.println(String.valueOf(8));
		String s10 = "a,b,c,d,e,f,g";
		String[] s11 = s10.split(",");
		System.out.println(Arrays.toString(s11));

		long startTime = System.currentTimeMillis();
		// String str = "hello";
		StringBuffer sb = new StringBuffer("hello");
		int index = 0;
		while (index < 10000) {
			// str = str + "world"; //354毫秒
			sb.append("world");// 2毫秒
			index++;
		}
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(getString(16));
	}

	// (?,?,?,?)
	public static String getString(int counts) {
		StringBuffer sb = new StringBuffer("(");
		for (int i = 0; i < counts; i++) {
			sb = i == 0 ? sb.append("?") : sb.append(",?");
		}
		return sb.append(")").toString();
	}
}
