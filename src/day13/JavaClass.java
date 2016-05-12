package day13;

public class JavaClass {
	public static void main(String[] args) {
		Class c1 = A.class;
		try {
			A a = (A) c1.newInstance();
			a.print();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 动态加载类
		String a = "day13.A";
		try {
			Class c3 = Class.forName(a);
			System.out.println(c3.getName());  //获取类名
			A a3 = (A) c3.newInstance();
			a3.print();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class A {
	void print() {
		System.out.println("hel");
	}
}
