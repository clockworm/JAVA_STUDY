package day16;

import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializableStudent implements Serializable {
	private transient String no; // transient使用关键字声明的属性不会被序列化所传输 但是可以反序列化自己來做 一樣可以拿到數值
	private String name;
	private int age;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
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

	public SerializableStudent(String no, String name, int age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "SerializableStudent [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	//反序列化 自己來做
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		// JVM默认序列化的工作
		out.defaultWriteObject();
		// no自己序列化
		out.writeUTF(no);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		// JVM默认反序列化的工作
		in.defaultReadObject();
		// no自己反序列化操作
		this.no = in.readUTF();
	}

}
