package day12.Movie;

import day12.Movie.Client;
import day12.Movie.Movie;
import day12.Movie.Rent;

public class Test {
	public static void main(String[] args) {
		//影片信息
		Movie m1 = new Movie("我们曾是战斗者");
		m1.setMovieType(Movie.COMMON_MOVIE);
		Movie m2 = new Movie("海賊王");
		m2.setMovieType(Movie.CHILD_MOVIE);
		Movie m3 = new Movie("功夫");
		m3.setMovieType(Movie.COMMON_MOVIE);
		Movie m4 = new Movie("美人鱼");
		m4.setMovieType(Movie.NEW_MOVIE);
		//客户信息
		Client c1 = new Client("张三");
		Client c2 = new Client("李斯");
		//租赁信息
		Rent r1 = new Rent(m1, 2);
		Rent r2 = new Rent(m4, 3);
		Rent r3 = new Rent(m3, 2);
		Rent r4 = new Rent(m2, 2);
		//客户租赁
		c1.addRent(r1);
		c1.addRent(r2);
		c1.addRent(r4);
		c1.printMessage();
		c2.addRent(r1);
		c2.addRent(r3);
		c2.printMessage();
	}
}
