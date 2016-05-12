package day14;

import java.util.Enumeration;
//老版本集合  線程安全
import java.util.Vector;

public class JavaVector {

	public static void main(String[] args) {
		User user1 = new User(1, "张三", "111");
		User user2 = new User(2, "李四", "222");
		User user3 = new User(3, "王五", "333");
		User user4 = new User(4, "赵六", "444");
		Vector<User> vec = new Vector<User>();
		vec.add(user1);
		vec.addElement(user2);
		vec.add(user3);
		vec.addElement(user4);
		//移除元素
		// vec.removeElementAt(0);
		// vec.remove(0);
		// vec.remove(user1);
		// 多了一种遍历方式  这个方式 线程不安全
		Enumeration<User> enu = vec.elements();
		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}

}
