package day12.Movie.Version5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//租赁类
public class Rent {
	private Movie movie; // 电影
	public static MyArrayList list = new MyArrayList();// 一个影片只能租赁一次。
	private String rentDate; // 租赁日期 yyyy-mm-d
	private int day; // 多少天

	public Rent() {
	}

	public Rent(Movie movie, String rentDate, int day) {
		if (list.add(movie) == 1) {
			if (isDateTime(rentDate)) {
				this.movie = movie;
				this.day = day;
				this.rentDate = rentDate;
			} else
				System.out.println("日期输入有误");
		} else {
			System.out.println("影片已经被租赁");
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Movie getMovie() {
		return movie;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		if (isDateTime(rentDate))
			this.rentDate = rentDate;
		else
			System.out.println("日期输入有误");
	}

	public void setMovie(Movie movie) {
		if (list.add(movie) == 1) {
			this.movie = movie;
		} else {
			System.out.println("影片已经被租赁");
		}
	}

	// 获取积分
	public double getPrice() {
		return movie.getPrice(this.getDay());
	}

	// 获取价格
	public int getFre() {
		return movie.getFre(this.getDay());
	}

	@Override
	public String toString() {
		String type = "";
		switch (movie.getMovieType()) {
		case Movie.NEW_MOVIE:
			type = "新电影";
			break;
		case Movie.COMMON_MOVIE:
			type = "普通电影";
			break;
		case Movie.CHILD_MOVIE:
			type = "儿童电影";
			break;
		}
		Calendar ca = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		Date d;
		try {
			d = sdf.parse(rentDate);
			ca.setTime(d);
			ca.add(Calendar.DATE, day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie.getMovieName() + "," + type + "," + day + "天" + ",租赁日期:" + rentDate + ",到期日期:"
				+ ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DATE);
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
