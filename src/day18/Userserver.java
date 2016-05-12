package day18;

//同一个线程同一个对象
public class Userserver {
	private static Userserver user;

	private static ThreadLocal<Userserver> tl = new ThreadLocal<Userserver>();

	private Userserver() {
	}

	public static Userserver getInstance() {
		if (tl.get() == null) {
			user = new Userserver();
			tl.set(user);
		}
		return tl.get();
	}
}
