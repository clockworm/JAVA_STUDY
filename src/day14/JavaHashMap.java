package day14;

//KEY相同会覆盖前一个的值 数组加链表结构
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class JavaHashMap {
	public static void main(String[] args) {
		User3 user1 = new User3("001", "张三", "111");
		User3 user2 = new User3("002", "李四", "222");
		User3 user3 = new User3("003", "王五", "333");
		User3 user4 = new User3("004", "赵六", "444");
		HashMap<String, User3> users3 = new HashMap<String, User3>();
		users3.put(user1.getNo(), user1);
		users3.put(user2.getNo(), user2);
		users3.put(user3.getNo(), user3);
		users3.put(user4.getNo(), user4);
		// users3.remove(user1.getNo()); //删除
		// System.out.println(users3);

		// 遍历方式1
		Set<String> set1 = users3.keySet();
		for (String string : set1) {
			System.out.println(string + "=" + users3.get(string));
		}
		System.out.println("============");
		// 遍历方式2
		Set<Entry<String, User3>> set2 = users3.entrySet();
		for (Entry<String, User3> entry : set2) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("============");
		// 案例1 根据HashMap特性（KEY相同会覆盖前一个的值） 做统计数量比较快捷
		// 统计下面的字符串每个字符出现的次数 并且按出现次数排序，次数相同字母排序
		HashMap<String, Integer> strMap = new HashMap<String, Integer>();
		String st = "abcdcasdsaddaef";
		String s = "";
		for (int i = 0; i < st.length(); i++) {
			s = st.substring(i, i + 1);
			if (strMap.containsKey(s)) {
				strMap.put(s, strMap.get(s) + 1);
			} else {
				strMap.put(s, 1);
			}
		}
		TreeSet<T2> ts = new TreeSet<T2>();
		for (String key : strMap.keySet()) {
			T2 t2 = new T2(key, strMap.get(key));
			ts.add(t2);
		}
		System.out.println(ts);
	}
}

// 思路 把key value 包装成某个对象的属性 这个对象实现Comparator接口 每个对象的实例方式TreeSet集合完成自动排序
class T2 implements Comparable<T2> {
	private String name;
	private int count;

	public T2() {
	}

	public T2(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "name=" + name + ", count=" + count + "";
	}

	@Override
	public int compareTo(T2 o) {
		if (this.count != o.count)
			return o.count - this.count;
		return this.name.compareTo(o.name);
	}

}
