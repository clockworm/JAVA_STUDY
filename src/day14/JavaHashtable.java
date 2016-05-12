package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.TreeMap;

//线程安全不能放入null
public class JavaHashtable {

	public static void main(String[] args) {
		Hashtable<String, Integer> tb = new Hashtable<String, Integer>();
		tb.put("a", 1);
		tb.put("b", 2);
		tb.put("c", 3);
		tb.put("d", 4);

		// 遍历方式与hashMap类似
		for (String string : tb.keySet()) {
			System.out.println(string + "=" + tb.get(string));
		}

		// 对key进行排序方式1 偽排序 Hashtable集合內部沒有排序遍歷時候輸出排序
		ArrayList<String> list = new ArrayList<String>();
		for (String string : tb.keySet()) {
			list.add(string);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "=" + tb.get(list.get(i)));
		}

		// 对key进行排序方式2   直接把数据封装进TreeMap 对象 内部进行了排序工作
		TreeMap<String, Integer> trs = new TreeMap<String, Integer>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		trs.put("a", 1);
		trs.put("b", 2);
		trs.put("c", 3);
		trs.put("d", 4);
		System.out.println(trs);
	}

}
