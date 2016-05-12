package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator; //比较器
import java.util.List;

//对集合的操作类  排序 倒置  里面的方法是静态方法
public class JavaCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("e");
		list.add("b");
		list.add("d");
		list.add("c");
		Collections.sort(list); // 排序
		System.out.println(list);
		Collections.reverse(list); // 倒置
		System.out.println(list);
		// 比较器 重写
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(list);

		// 找出某个集合最大最小
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(21);
		list2.add(33);
		System.out.println(Collections.max(list2));
		System.out.println(Collections.min(list2));

	}
}
