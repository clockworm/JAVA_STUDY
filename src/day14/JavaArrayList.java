package day14;
//线程不安全
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class JavaArrayList {
	public static void main(String[] args) {
		User user1 = new User(1, "张三", "111");
		User user2 = new User(2, "李四", "222");
		User user3 = new User(3, "王五", "333");
		User user4 = new User(4, "赵六", "444");
		// 创建一个集合 底层操作的是一个Object对象的数组
		ArrayList<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user2);
		list.add(2, user4); // 插入操作，后面的元素后移一个位子
		System.out.println(list.remove(0)); // 移除第1个元素 返回是被移除的对象
		list.remove(user2); // 移除对象元素 是移除最开始找到的元素
		System.out.println(list.size()); // 长度

		// 遍历方式1
		System.out.println("遍历方式1:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 遍历方式2
		System.out.println("遍历方式2:");
		for (User user : list) {
			System.out.println(user);
		}
		// 遍历方式3
		System.out.println("遍历方式3:");
		Iterator<User> itor = list.iterator();
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}

		// list集合只能放入User对象的实例,现在通过反射绕过泛型限制 结果会导致foreach遍历失效
		try {
			Method mtd = list.getClass().getMethod("add", new Class[] { Object.class });
			mtd.invoke(list, "强制进入");
		} catch (Exception e) {
			e.printStackTrace();
		}
		println();
		// 遍历方式1
		System.out.println("遍历方式1:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// // 遍历方式2 反射后list 元素不一樣 遍歷失效
		// System.out.println("遍历方式2:");
		// for (User user : list) {
		// System.out.println(user);
		// }
		// 遍历方式3
		System.out.println("遍历方式3:");
		Iterator<User> itor1 = list.iterator();
		while (itor1.hasNext()) {
			System.out.println(itor1.next());
		}

	}

	public static void println() {
		System.out.println("======================华丽分割线=======================");
	}
}
