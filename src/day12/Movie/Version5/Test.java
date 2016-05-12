package day12.Movie.Version5;

//添加租赁的日期和归还日期   判斷了日期的合法性

public class Test {
	public static void main(String[] args) {
		// 影片信息
		Movie m1 = new Movie("我们曾是战斗者");
		m1.setMovieType(Movie.COMMON_MOVIE);
		Movie m2 = new Movie("海賊王");
		m2.setMovieType(Movie.CHILD_MOVIE);
		Movie m3 = new Movie("功夫");
		m3.setMovieType(Movie.COMMON_MOVIE);
		Movie m4 = new Movie("美人鱼");
		m4.setMovieType(Movie.NEW_MOVIE);
		Movie m5 = new Movie("美人鱼2");
		m5.setMovieType(Movie.NEW_MOVIE);
		// 客户信息
		Client c1 = new Client("张三");
		Client c2 = new Client("李斯");
		// 租赁信息
		Rent r1 = new Rent(m1, "2015-9-18", 31 - 18 + 1);
		Rent r2 = new Rent(m2, "2015-7-18", 3);
		Rent r3 = new Rent(m3, "2015-7-18", 18);
		Rent r4 = new Rent(m4, "2015-7-18", 3);
		Rent r5 = new Rent(m5, "2016-1-1", 368);
		// Rent r5 = new Rent(m5, "2015-27-18", 3); //日期有误 r5不能被创建
		c1.addRent(r1);
		c1.addRent(r2);
		c1.addRent(r4);
		for (int i = 0; i < c1.getList().getIndex(); i++) {
			System.out.println(c1.getList().getOject(i)); // 遍历客户1的租赁影片信息
		}
		c1.printMessage();

		c2.addRent(r2);
		c2.addRent(r3);
		c2.addRent(r5);
		for (int i = 0; i < c2.getList().getIndex(); i++) {
			System.out.println(c2.getList().getOject(i)); // 遍历客户2的租赁影片信息
		}
		c2.printMessage();
	}
}
