package day12.Movie.Version2;

import java.util.Arrays;

//对象容器   容器對象 容器有效元素长度
public class MyArrayList {
	private Object[] objects = new Object[10];
	private int index;// 记录有效元素

	public Object[] getObjects() {
		return objects;
	}

	public int getIndex() {
		return index;
	}

	// 数组增加元素 每次都添加到数组的最好一个位置
	public void add(Object object) {
		if (objects.length == index)
			Arrays.copyOf(objects, objects.length * 2);
		objects[index++] = object;
	}
	//遍历迭代器
}
