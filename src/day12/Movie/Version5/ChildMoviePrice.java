package day12.Movie.Version5;

public class ChildMoviePrice extends Price {

	@Override
	public double getPrice(int days) {
		if (days <= 3)
			return 1.5;
		return (days - 3) * 1.5 + 1.5;
	}

}
