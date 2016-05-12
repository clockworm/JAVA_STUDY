package day13;

import java.lang.reflect.Method;

public class JavaReflect_Method {
	public static void main(String[] args) {
		MethodReflect1();
		MethodReflect2();
	}

	// 通过传递的对象获取该对象的某个方法
	public static void MethodReflect1() {
		Operator opr = new Operator();
		Class c = opr.getClass();
		try {
			// 方法名參數--->new Class[]{参数.class}
			Method md = c.getMethod("add", new Class[] { int.class, int.class, int.class }); // 获取一个方法
			int s = (int) md.invoke(opr, new Object[] { 10, 20, 25 });
			System.out.println(s);
			// 获取无参数方法
			Method mds = c.getMethod("add", null); // 获取一个方法
			int s2 = (int) mds.invoke(opr, null);
			System.out.println(s2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 反射方法調用
	public static void MethodReflect2() {
		String s1 = "hello";
		String s2 = "world";
		// System.out.println(s1.concat(s2));
		Class c1 = s1.getClass();
		try {
			Method md = c1.getMethod("concat", new Class[] { String.class });
			String s = (String) md.invoke(s1, s2);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Operator {
	public int add(int a, int b) {
		return a + b;
	}

	public int add() {
		return 1 + 1;
	}

	public int add(int a, int b, int c) {
		return a + b + c;
	}

	public double add(double a, double b) {
		return a + b;
	}
}
