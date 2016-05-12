package day12.Movie.Version4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//租赁类
public class Rent {
	private Movie movie; // 电影
	public static MyArrayList list = new MyArrayList();// 一个影片只能租赁一次。
	private int day; // 多少天

	public Rent() {
	}

	public Rent(Movie movie, int day) {
		if (list.add(movie) == 1) {
			this.movie = movie;
			this.day = day;
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
		return movie.getMovieName() + "," + type + "," + day + "天";
	}
}
