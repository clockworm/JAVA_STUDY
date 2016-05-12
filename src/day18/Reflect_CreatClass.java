package day18;

import java.lang.reflect.Constructor;

//反射破解单例模式
public class Reflect_CreatClass {
	public static void main(String[] args) {
		Class<Userserver> c = Userserver.class;
		try {
			Constructor con = c.getDeclaredConstructor(null);  //私有的构造函数 参数为空
			con.setAccessible(true);// 设置访问权限
			Userserver u1 = (Userserver) con.newInstance(null);
			Userserver u2 = (Userserver) con.newInstance(null);
			Userserver u3 = (Userserver) con.newInstance(null);
			Userserver u4 = (Userserver) con.newInstance(null);
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(u3);
			System.out.println(u4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
