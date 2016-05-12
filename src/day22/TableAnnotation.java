package day22;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Type_Annotation(value = "注解表", countArraylist = { 1, 2, 3, 4 })
public class TableAnnotation {
	public static void main(String[] args) {
		/**
		 * TYPE 获取类注解原数据
		 */
		Class<TableAnnotation> c = TableAnnotation.class;
		if (c.isAnnotationPresent(Type_Annotation.class)) {
			Type_Annotation en = (Type_Annotation) c.getAnnotation(Type_Annotation.class);
			System.out.println(en.value());
			for (int s : en.countArraylist()) {
				System.out.println(s);
			}
		}

		/**
		 * Field 获取属性注解原数据
		 */
		Class<TableAnnotation> c1 = TableAnnotation.class;
		Field[] field = c1.getDeclaredFields();
		for (Field field2 : field) {
			if (field2.isAnnotationPresent(Field_Annotation.class)) {
				String s = field2.getAnnotation(Field_Annotation.class).name();
				System.out.println(s);
			}
		}
		/**
		 * Method 获取方法注解原数据
		 */
		Class<TableAnnotation> c2 = TableAnnotation.class;
		Method[] mtd = c2.getDeclaredMethods();
		for (Method method : mtd) {
			if (method.isAnnotationPresent(Method_Annotation.class)) {
				String methodeffect = method.getAnnotation(Method_Annotation.class).effect();
				System.out.println(methodeffect);
			}
		}
		/**
		 * 一个类是否是注解类类型
		 */
		System.out.println(TableAnnotation.class.isAnnotation());
		System.out.println(Type_Annotation.class.isAnnotation());
		System.out.println(Field_Annotation.class.isAnnotation());
		System.out.println(Method_Annotation.class.isAnnotation());
	}

	@Field_Annotation(name = "名字")
	private String name;
	@Field_Annotation(name = "年龄")
	private int age;

	@Method_Annotation(effect = "获取名字方法")
	public String getName() {
		return name;
	}

	@Method_Annotation(effect = "设置名字方法")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Method_Annotation(effect = "查看SQL语句")
	public void getSql() {
		System.out.println("SQL语句");
	}
}
