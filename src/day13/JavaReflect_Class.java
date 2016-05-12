package day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 动态加载类  模拟
public class JavaReflect_Class {

	public static void main(String[] args) {
		Class c = null;
		try {
			// 功能性类都是动态加载 而非new一个对象直接加載
			c = Class.forName(args[0]); // 用父类接收 通过运行前参数配置实现 參數為類類型 包名.类名
			// 变量
			Field[] f = c.getDeclaredFields();// 获取成员自己声明变量
			for (Field field : f) {
				Class s2 = field.getClass();
				System.out.println(s2.getName() + "  " + field.getName()); // 打印声明变量
			}
			// 方法
			Method[] ms = c.getMethods();// 获取 该class对象的所有public的方法
			Method[] ms1 = c.getDeclaredMethods();// 获取 该class对象的自己声明的方法
			for (Method m : ms1) {
				System.out.print(m.getName() + " ,"); // 获取对象方法名
				Class s1 = m.getReturnType(); // 获取返回值类型
				System.out.print("返回值：" + s1.getName());
				Class[] methodParameter = m.getParameterTypes(); // 获取参数列表信息
				for (Class class1 : methodParameter) {
					System.out.print(" 参数:" + class1.getName());// 打印参数类型信息
				}
				System.out.println();
			}
			// 构造函数
			Constructor[] ctos = c.getConstructors();
			for (Constructor constructor : ctos) {
				System.out.print("构造函数名字：" + constructor.getName());
				Class[] para = constructor.getParameterTypes();
				System.out.print("构造函数参数：");
				for (Class class1 : para) {
					System.out.print("," + class1.getName());
				}
				System.out.println();
			}
			// System.out.println(c.getName()); // 获取对象名
			// System.out.println(c.getSimpleName()); // 获取对象名 不包含包名
			// Office of = (Office) c.newInstance();
			// System.out.println(of.toString());
			// of.work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
