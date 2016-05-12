package day9;

public class Student {
	private int no;
	private String name;

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + no;
//		return result;
//	}

//	@Override // 重写equals方法 识别id唯一标识 相同即为一个对象
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (no != other.no)
//			return false;
//		return true;
//	}

	public Student() {
	}

	public Student(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}

	@Override // 直接返回一个对象
	public String toString() {
		return "Student [编号=" + no + ", 名字=" + name + ", 年龄=" + age + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;
}
