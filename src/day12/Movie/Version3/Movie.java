package day12.Movie.Version3;

//影片类
public class Movie {
	private String movieName;
	private int movieType;
	public static final int NEW_MOVIE = 1;
	public static final int COMMON_MOVIE = 2;
	public static final int CHILD_MOVIE = 3;

	public Movie() {
	}
	public Movie(String name) {
		this.movieName = name;
	}
	public Movie(String name, int type) {
		this.movieName = name;
		this.movieType = type;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieType() {
		return movieType;
	}

	public void setMovieType(int movieType) {
		this.movieType = movieType;
	}
}
