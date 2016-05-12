package day13;

import java.lang.reflect.Array;
//数组的反射 數組類型和維數
import java.lang.reflect.Method;

public class JavaReflect_Arrays {
	public static void main(String[] args) {
		try {
			Class c = Test.class;
			// 方法名 参数类型列表
			Method mtd = c.getMethod("print", new Class[] { String[].class, int[].class });
			// 对象实例。 参数实体
			mtd.invoke(c.newInstance(), new Object[] { new String[] { "张三", "李四", "王五" }, new int[] { 1, 2, 3, 4 } });
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[][] st = { { "张三", "168", "男" }, { "张三2", "170", "男2" }, { "张三3", "173", "男3" } };
		Test.getArrayObject_Element(st);
	}
}

class Test {
	public void print(String[] str, int[] i) {
		for (int j : i) {
			System.out.println(j);
		}
		for (String s : str) {
			System.out.println(s);
		}
	}

	// 遍历一个数组对象元素
	public static void getArrayObject_Element(Object object) {
		try {
			if (object.getClass().isArray()) {
				int size = Array.getLength(object);
				for (int i = 0; i < size; i++) {
					// 递归判断直到为对象不是数组为止
					getArrayObject_Element(Array.get(object, i));
				}
			} else {
				System.out.print(object + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
