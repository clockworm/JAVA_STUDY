package day12.Movie.Version4;

public class NewMoviePrice extends Price {

	@Override
	public double getPrice(int days) {
		return days * 3;
	}

	public int getFre(int days) {
		if (days > 1)
			return 2;
		return 1;
	}

}
