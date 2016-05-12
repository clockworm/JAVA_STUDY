package day22.examSystem.entity;

import java.io.Serializable;

public class User  implements Serializable{
	private String id;
	private String name;
	private String password;
	private String e_mail;

	public User() {
	}

	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param e_mail
	 */
	public User(String id, String name, String password, String e_mail) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.e_mail = e_mail;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", e_mail=" + e_mail + "]";
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
}
