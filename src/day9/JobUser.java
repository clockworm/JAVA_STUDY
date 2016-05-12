package day9;

/*
 * 使用面向对象的方式实现一个用户登录、注册的功能(要求同一个账号不能同时登录)
 * */
public class JobUser {

	private String username;
	private String password;
	static JobUser user;

	public JobUser() {

	}

	public JobUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobUser other = (JobUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	// 注册
	public void register(String name, String password) {
		if (user != null) {
			if (user.equals(this)) {
				System.out.println("该用户已经被注册");
				return;
			}
		}
		this.username = name;
		this.password = password;
		System.out.println("注册成功");
	}

	// 登录
	public void login() {
		if (user == null)
			user = this;
		else {
			if (user.equals(this)) {
				System.out.println("该用户已经登录，登录失败！");
				return;
			}
		}
		System.out.println("您好：" + this.username + "登录成功!");
		user = this;
	}
}
