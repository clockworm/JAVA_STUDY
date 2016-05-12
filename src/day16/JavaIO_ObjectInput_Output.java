package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//序列化某个类必须该类实现Serializable接口 这个接口没有任何方法 只是一种声明
public class JavaIO_ObjectInput_Output {

	public static void main(String[] args) {
		SerializableStudent stu = new SerializableStudent("0001", "张三", 18);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\stu")); // 写
																								// 格式可以是任意或者不写
			out.writeObject(stu);
			out.flush();
			out.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\stu"));// 读
			SerializableStudent stu1 = (SerializableStudent) in.readObject();
			System.out.println(stu1);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 测试 序列化 小问题
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\a"));
			C c = new C();
			out.writeObject(c);
			out.flush();
			out.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\a"));
			//问题在这里 因为C继承了B和A 而B和A没有被序列化 所以反序列化后对象只有C而没有A和B  这时候会关联A和B(因为继承关系) 即需要加载A和B 即調用A和B构造方法。
			C c1 = (C) in.readObject();
			System.out.println(c1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class A {
	A() {
		System.out.println("a......");
	}
}

class B extends A {
	B() {
		System.out.println("b......");
	}
}

class C extends B implements Serializable {
	C() {
		System.out.println("c......");
	}
}
