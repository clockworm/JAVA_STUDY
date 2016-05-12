package day13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

//反射方法案例
public class JavaReflect_Method_Test {
	public static void main(String[] args) {
		// User user = new User();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("输入操作：");
		// String s = sc.nextLine();
		// if (s.equals("add")) {
		// user.add();
		// } else if (s.equals("delete")) {
		// user.delete();
		// } else if (s.equals("update")) {
		// user.update();
		// }
		// 如果我们拿到的传递的信息就是方法的名字 我们可以直接用反射来做。方便维护和添加功能
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("输入操作：");
		String s = sc.nextLine();
		try {
			Class c = user.getClass();
			Method med = c.getMethod(s, null);
			med.invoke(user, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class User {
	public void add() {
		System.out.println("添加...");
	}

	public void delete() {
		System.out.println("删除...");
	}

	public void update() {
		System.out.println("修改...");
	}
}
