package day12.Movie;

//租赁类
public class Rent {
	private Movie movie; // 电影
	private int day; // 多少天

	public Rent() {
	}

	public Rent(Movie movie, int day) {
		this.movie = movie;
		this.day = day;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
