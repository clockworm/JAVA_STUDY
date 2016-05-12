package day13;

public class Student {

	private String name;
	private String arrdrent;
	private int age;
	private int sex;

	public Student() {
	}

	public Student(String name, String add, int age, int sex) {
		this.name = name;
		this.arrdrent = add;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArrdrent() {
		return arrdrent;
	}

	public void setArrdrent(String arrdrent) {
		this.arrdrent = arrdrent;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
