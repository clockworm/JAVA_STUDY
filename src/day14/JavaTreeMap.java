package day14;

import java.util.Comparator;
import java.util.TreeMap;

//跟TreeSet相识 如果key是一个对象 需要放入的对象实现2中比较器  
public class JavaTreeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User2 user1 = new User2("001", "张三", "111");
		User2 user2 = new User2("002", "李四", "222");
		User2 user3 = new User2("003", "王五", "333");
		User2 user4 = new User2("004", "赵六", "444");
		TreeMap<User2, String> users = new TreeMap<User2, String>();
		users.put(user1, user1.getNo());
		users.put(user2, user2.getNo());
		users.put(user3, user3.getNo());
		users.put(user4, user4.getNo());
		System.out.println(users);
		//匿名操作
		TreeMap<User2, String> users2 = new TreeMap<User2, String>(new Comparator<User2>() {
			@Override
			public int compare(User2 o1, User2 o2) {
				return o2.getNo().compareTo(o1.getNo());
			}
		});
		users2.put(user1, user1.getNo());
		users2.put(user2, user2.getNo());
		users2.put(user3, user3.getNo());
		users2.put(user4, user4.getNo());
		System.out.println(users2);

	}

}
