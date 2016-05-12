package day14;

public class User3 {

	private String no;
	private String username;
	private String password;

	public User3() {
	}

	public User3(String no, String username, String password) {
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
		return username;
	}

}
