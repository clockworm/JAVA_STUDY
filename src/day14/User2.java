package day14;

//重写了Comparable接口 才能添加进TreeSet集合中 指定比较方式即排序方式
public class User2 implements Comparable<User2> {

	private String no;
	private String username;
	private String password;

	public User2() {
	}

	public User2(String no, String username, String password) {
		this.no = no;
		this.username = username;
		this.password = password;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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
	public String toString() {
		return no + ", " + username + ";";
	}
	
	// 重写compareTo方法 根据名字
	// @Override
	// public int compareTo(User2 o) {
	// if (!this.username.equals(o.username))
	// return this.username.compareTo(o.username);
	// return 0;
	// }

	// 重写compareTo方法 根据编号
	@Override
	public int compareTo(User2 o) {
		if (!this.username.equals(o.username))
			return o.username.compareTo(this.username); // 交换比较的位置 倒置
		return 0;
	}

}
