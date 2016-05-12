package day9;

public class JobTest {
	public static void main(String[] args) {
		JobUser user = new JobUser();
		user.setUsername("张三");
		user.setPassword("123456");
		user.login();
		JobUser user1 = new JobUser("张三", "123456");
		user1.login();
		String name = "李王";
		String password = "1234";
		JobUser user2 = new JobUser();
		user2.register(name, password);
		user2.login();
		user2.register(name, password);
		user2.login();
	}
}
