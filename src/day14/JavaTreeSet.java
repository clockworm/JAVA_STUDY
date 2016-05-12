package day14;

//不能放置重复  它的唯一标识根据排序的属性作为唯一标识 相同为重复不能添加
import java.util.Comparator;
//底层操作的是TreeMap对象  只能放入可以排序的对象，所以要添加对象 该对象必须实现Comparable接口
import java.util.TreeSet;

public class JavaTreeSet {
	public static void main(String[] args) {
		User2 user1 = new User2("001", "张三", "111");
		User2 user2 = new User2("002", "张三", "222");
		User2 user3 = new User2("003", "王五", "333");
		User2 user4 = new User2("004", "赵六", "444");
		// User2 实现了Comparable接口
		TreeSet<User2> users = new TreeSet<User2>();
		users.add(user1);
		users.add(user2);
		/*
		 * User2张三没被添加进来 //不能放置重复 它的唯一标识根据排序的属性作为唯一标识 相同为重复不能添加
		 */
		users.add(user4);
		users.add(user3);
		System.out.println(users);

		// 匿名类的使用 實現Comparator接口
		User3 user11 = new User3("001", "张三", "111");
		User3 user22 = new User3("002", "张三", "222");
		User3 user33 = new User3("003", "王五", "333");
		User3 user44 = new User3("004", "赵六", "444");
		TreeSet<User3> users3 = new TreeSet<User3>(new Comparator<User3>() {
			@Override
			public int compare(User3 o1, User3 o2) {
				return o1.getNo().compareTo(o2.getNo());
			}
		});
		users3.add(user11);
		users3.add(user22);
		users3.add(user44);
		users3.add(user33);
		System.out.println(users3);

		// 字符串比较
		TreeSet<String> strs = new TreeSet<String>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		String s1 = "hello";
		String s2 = "world";
		strs.add(s1);
		strs.add(s2);
		System.out.println(strs);
	}
}
