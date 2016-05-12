package day13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex {
	public static void main(String[] args) {
		String s1 = "1abbb+2abb+3abbbb+4abbbbb+5abbbb+";
		String[] s2 = s1.split("ab+\\+");
		System.out.println(Arrays.toString(s2));

		String s3 = "ab+\\+";
		Pattern pn = Pattern.compile(s3);
		Matcher match = pn.matcher(s1);
		System.out.println(match.find()); // pn是否能够匹配上
		while (match.find()) {
			System.out.println(match.group());
		}
		// 找出数字 //^非 “^$” 开头结尾
		// \\d代表一个数字 \\D除数字之外的任意字符 \\s代表空格[\n\t\r\f] \\S代表非空白 \\w代表0-9 a-z
		// A-Z还有_ \\W 非0-9 a-z A-Z和下划线
		// ? 0或1次 + 一次或多次 * 0次或多次
		String a = "abc123def4567";
		// System.out.println(Arrays.toString(a.split("[a-z]+"))); //一样的
		// System.out.println(Arrays.toString(a.split("\\D+"))); //一样的
		String regex = "\\d+";
		Pattern pns = Pattern.compile(regex);
		Matcher matchs = pns.matcher(a);
		while (matchs.find()) {
			System.out.println(matchs.group());
		}

		Scanner sc = userNameRegex();

		tellRegex(sc);
	}

	// 用户名 字母开头 长度必须为5-10
	public static Scanner userNameRegex() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入日期：");
		// String nameRegex = "^[a-zA-Z]\\w{4,9}$";
		String regex = "^\\d{4}[-]\\d{1,2}[-]\\d{2}$";
		while (true) {
			String str1 = sc.nextLine();
			if (str1.matches(regex)) {
				System.out.println("用户名" + str1);
				break;
			} else {
				System.out.println("请重新输入");
			}
		}
		return sc;
	}

	// 手机号码
	public static void tellRegex(Scanner sc) {
		String tellRegex = "^[1][358]\\d{9}$";
		while (true) {
			String str1 = sc.nextLine();
			if (str1.matches(tellRegex)) {
				System.out.println("手机" + str1);
				break;
			} else {
				System.out.println("请重新输入");
			}
		}
	}
}
