package day9;

import java.util.Arrays;

public class JavaObject {

	public static void main(String[] args) {
//		A a1 = new A();
//		a1.i = 10;
//		A a2 = new A();
//		a2.i = 10;
//		System.out.println(a1.equals(a2));
//		int[] a3 = { 1, 2, 3, 4 };
//		System.out.println(Arrays.toString(a3));
//		System.out.println(a2);
//		a1.print();
		B b = new B();
		b.p();
	}

}

class A {
	public String str = "A的变量";

	// int ;
	// public boolean equals(Object obj) {
	// if (obj instanceof A) { // 是否属于这个类的子类
	// A a = (A) obj;
	// return this.i == a.i;
	// }
	// return false;
	// }
	public void p(){
		print();
	}
	private void print() {
		System.out.println(str);
	}
	
}

class B extends A {
	public String str = "B的变量";
	
	public void print() {
		System.out.println(str);
	}
}
