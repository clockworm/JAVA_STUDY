package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaCalendar {
	public static void main(String[] args) {
		Calendar ca = Calendar.getInstance();
		// Calendar 是个抽象类
		System.out.println(ca.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm:ss"); //唯一的 yyyy-M-dd
		// 获取时间信息
		getTimeMessage(ca, sdf);
		// 入职日期
		entryTime(ca, sdf);

	}

	// 获取时间信息
	public static void getTimeMessage(Calendar ca, SimpleDateFormat sdf) {
		System.out.println(sdf.format(ca.getTime()));
		System.out.println(ca.get(Calendar.YEAR)); // 年
		System.out.println(ca.get(Calendar.MONTH) + 1); // 月
		System.out.println(ca.get(Calendar.DATE)); // 日
		System.out.println(ca.get(Calendar.HOUR));// 时
		System.out.println(ca.get(Calendar.MINUTE));// 分
		System.out.println(ca.get(Calendar.SECOND));// 秒
	}

	// 入职日期
	public static void entryTime(Calendar ca, SimpleDateFormat sdf) {
		String s = "2012-11-13 00:00:00";
		try {
			Date date = sdf.parse(s);
			ca.setTime(date);
			// 3个月转正
			ca.add(Calendar.MONTH, 3);
			System.out.println(
					"转正日期" + ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DATE));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// 是否是日期格式
	public boolean isDateTime(String date) {
		String regex = "^[1-3]\\d{3}-\\d{1,2}-\\d{1,2}";
		String[] str = date.split("-");
		if (date.matches(regex)) {
			int year = Integer.parseInt(str[0]);
			int mm = Integer.parseInt(str[1]);
			int day = Integer.parseInt(str[2]);
			if (mm < 13 && mm > 0 && day < getEveryMouth_Days(year, mm)) {
				return true;
			}
		}
		return false;
	}

	// 拿到每月天数
	public int getEveryMouth_Days(int year, int m) {
		int count = 0;
		switch (m) {
		case 12:
			count = 31;
		case 11:
			count = 30;
		case 10:
			count = 31;
		case 9:
			count = 30;
		case 8:
			count = 31;
		case 7:
			count = 31;
		case 6:
			count = 30;
		case 5:
			count = 31;
		case 4:
			count = 30;
		case 3:
			count = 31;
		case 2:
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
				count = 29;
			else
				count = 28;
		case 1:
			count = 31;
		}
		return count;
	}
}
