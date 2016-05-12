package day10;

public class JavaFinal {
	public static void main(String[] args) {
		final int i = 10; // 只能赋值1次 且必须有初始值
		// i = 12; //错误 不能赋值
		A a = new A(2);
		System.out.println(a.getI());
		A a1 = new A(3);
		System.out.println(a1.getI());
		A a2 = new A(4);
		// a2.i = 3; //报错
		System.out.println(a2.getI());
		final A a4 = new A(5); // 只能赋值一次 固定a4指向的对象地址
		System.out.println(a4.getI());
		// a4 = new A(6); 错误
	}
}

final class A { //修饰的类不能被继承 和abstract 是不能一起使用的
	private final int i; // 每个实例对象只能有一个且只能赋值一次

	A(int i) {
		this.i = i;
	}

	public final int getI() { //修饰的方法不能被重写
		return i;
	}
}