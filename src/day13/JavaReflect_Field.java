package day13;

import java.lang.reflect.Field;

//某个类的属性字符串全部大写 int 类型全部加100
public class JavaReflect_Field {
	public static void main(String[] args) {
		Student stu = new Student("张三", "重庆", 26, 3);
		reflectUpdateValue(stu);
		System.out.println(getSql(stu));
		System.out.println(1);
		System.out.println(stu.getName());
		System.out.println(stu.getArrdrent());
		System.out.println(stu.getAge());
		System.out.println(stu.getSex());
	}

	// 对象 獲取所有的屬性
	public static void reflectUpdateValue(Object obj) {
		Class c = obj.getClass();
		try {
			Field[] flds = c.getDeclaredFields();
			for (Field field : flds) {
				field.setAccessible(true); // 修改访问权限
				if (field.getType() == String.class) {
					field.set(obj, field.get(obj) + "你好");
				}
				if (field.getType() == int.class) {
					field.set(obj, (int) field.get(obj) * 2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 成员变量反射 访问值
	public static Object reflect_getValue(Object obj, String attributeName) {
		Class c = obj.getClass();
		try {
			Field fld = c.getDeclaredField(attributeName);
			fld.setAccessible(true); // 修改访问权限
			return fld.get(obj); // 获得對象字段值
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 设置成员变量（反射）
	public static void reflect_setValue(Object obj, String attribute, String value) {
		Class c = obj.getClass();
		try {
			Field fld = c.getDeclaredField(attribute);
			fld.setAccessible(true); // 设置访问权限
			fld.set(obj, value); // 修改對象字段值
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 得到一个对象的SQL语句 insert into 类名(属性1,属性2) values (?,?,?);
	public static StringBuffer getSql(Object obj) {
		Class c = obj.getClass();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into ").append(c.getSimpleName()).append("(");
		Field[] fld = c.getDeclaredFields();
		for (int i = 0; i < fld.length; i++) {
			sb = i == 0 ? sb.append(fld[i].getName()) : sb.append("," + fld[i].getName());
		}
		sb.append(getSqllength(fld.length));
		return sb;
	}
	//获取问号个数
	public static StringBuffer getSqllength(int length) {
		StringBuffer sb = new StringBuffer();
		sb.append(") values");
		for (int i = 0; i < length; i++) {
			sb = i == 0 ? sb.append("(?") : sb.append(",?");
		}
		sb.append(")");
		return sb;
	}

}
