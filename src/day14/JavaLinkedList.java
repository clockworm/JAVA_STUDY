package day14;

import java.util.LinkedList;

//链表集合。内部插入元素操作频繁建议使用
public class JavaLinkedList {
	public static void main(String[] args) {
		User user1 = new User(1, "张三", "111");
		User user2 = new User(2, "李四", "222");
		User user3 = new User(3, "王五", "333");
		User user4 = new User(4, "赵六", "444");
		LinkedList<User> link = new LinkedList<User>();
		link.add(user1);
		link.add(user2);
		link.add(user3);
		link.add(user4);
		// link.removeFirst(); //删除头
		// link.remove(); //删除头
		// System.out.println();
		// link.push(user4); //添加到头位子
		 for (User user : link) {
			System.out.println(user);
		}

	}
}
