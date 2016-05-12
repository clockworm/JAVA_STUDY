package day13;

import java.lang.reflect.Method;

//反射方法案例
public class JavaReflect_Method_Test2 {
	public static void main(String[] args) {
		User2 user2 = new User2("张三", 23);

		// 通过方法反射获得
		System.out.println(getValue_arbitraryObject("age", user2));

		// 通过Field反射获得成员变量信息 對象 字段
		System.out.println(JavaReflect_Field.reflect_getValue(user2, "name"));

		// 修改成员变量值 對象 字段 值
		JavaReflect_Field.reflect_setValue(user2, "name", "李四");

		System.out.println(user2.getName());
	}

	// 反射获取成员变量get方法的反射 变量名 对象
	public static Object getValue_arbitraryObject(String attributeName, Object obj) {
		Class c = obj.getClass();
		String name = "get" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
		try {
			Method me = c.getMethod(name, null);
			return me.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

class User2 {

	private String name;
	private int age;

	public User2() {
	}

	public User2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
}
