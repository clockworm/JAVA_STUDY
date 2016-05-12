package day11;

public class JobTest {
	public static void main(String[] args) {
		Register r = new Register();
		User u = r.registerUser(1, "张三0", "123");
		User u2 = r.registerUser(2, "王无2", "123");
		User u1 = r.registerUser(1, "王无1", "123");
		Login login = new Login();
		login.loginUser(u);
		login.loginUser(u2);
		login.loginUser(u);
		login.loginUser(u1);

	}
}
