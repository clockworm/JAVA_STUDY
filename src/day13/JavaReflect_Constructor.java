package day13;

import java.lang.reflect.Constructor;

public class JavaReflect_Constructor {
	public static void main(String[] args) {
		// 无参数
		Student stu = (Student) reflectConstructor(Student.class);
		System.out.println(stu.getName() + "," + stu.getAge() + "," + stu.getArrdrent() + "," + stu.getSex());
		// 有参数
		Student stu2 = (Student) reflectConstructor_Para(Student.class);
		System.out.println(stu2.getName() + "," + stu2.getAge() + "," + stu2.getArrdrent() + "," + stu2.getSex());
	}

	// 无参数构造方法反射
	public static Object reflectConstructor(Class c) {
		try {
			Constructor<Student> con = c.getConstructor(null);
			Student stu1 = con.newInstance(null);
			stu1.setAge(2);
			stu1.setName("zhangsan");
			stu1.setSex(0);
			stu1.setArrdrent("重慶");
			return stu1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 有参数构造方法反射
	public static Object reflectConstructor_Para(Class c) {
		try {
			Constructor<Student> con = c
					.getConstructor(new Class[] { String.class, String.class, int.class, int.class });
			Student stu1 = con.newInstance(new Object[] { "张三", "重庆市", 26, 0 });
			return stu1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
