package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaMath_Date {
	public static void main(String[] args) {
		int i = (int) (Math.random() * 100); // 随机生成0-100
		System.out.println(i);
		System.out.println(Math.round(13.2)); // round 四舍五入
		System.out.println(Math.ceil(13.1)); // 进位
		System.out.println(Math.floor(13.9));// 舍位
		System.out.println(Math.max(10, 9)); // 2个数比较
		System.out.println(Math.min(10, 9)); // 2个数比较
		char cr = (char) ('a' + Math.random() * ('z' - 'a' + 1));// 随机生成一个字符
		System.out.println(cr);
		Date date = new Date();
		System.out.println(date.toString());
		// 时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		System.out.println(date.getTime());
		System.out.println(System.currentTimeMillis());
		try {
			// 字符串生成date对象
			String n = sdf1.parse("2015-12-03").toString();
			System.out.println(n);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 过时不用。
		// System.out.println(date.getYear()+1900);
		// System.out.println(date.getMonth()+1);
		char c2r = (char) ('A'+Math.random()*('Z' - 'A'+1));// 随机生成一个字符
		System.out.println(c2r);
	}
}
