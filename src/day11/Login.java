package day11;
public class Login extends UserAdpter {
	private static User[] users = new User[20];
	private static int i = 0;

	@Override
	public void loginUser(User u) {
		if (u == null) {
			System.out.println("用户不存在,登陆失败");
			return;
		}
		if (users[0] != null) {
			for (int j = 0; j < i; j++) {
				if (users[j].equals(u)) {
					System.out.println("该已经登陆过了");
					return;
				}
			}
		}
		users[i++] = u;
		System.out.println("登陆成功");
	}
}
