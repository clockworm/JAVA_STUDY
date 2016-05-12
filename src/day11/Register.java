package day11;

public class Register extends UserAdpter {
	private static User[] users = new User[20];
	private static int i = 0;

	@Override
	public User registerUser(int id, String username, String password) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		if (users[0] != null) {
			for (int j = 0; j < i; j++) {
				if (users[j].equals(user)) {
					System.out.println("注册失败，已经注册过了");
					return null;
				}
			}
		}
		System.out.println("注册成功");
		users[i++] = user;
		return user;
	}
}
