package day12.Movie.Version5;

public class CommonMoviePrice extends Price {

	@Override
	public double getPrice(int days) {
		if (days <= 3) {
			return 2;
		}
		return (days - 3) * 2 + 1.5;
	}

}
