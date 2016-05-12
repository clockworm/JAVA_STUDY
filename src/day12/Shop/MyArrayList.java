package day12.Shop;

import java.util.Arrays;

//对象容器   容器對象 容器有效元素长度
public class MyArrayList {
	private Object[] objects = new Object[10];
	private int index;// 记录有效元素

	public Object[] getObjects() {
		return objects;
	}
	
	// 数组增加元素 每次都添加到数组的最好一个位置
	public int add(Object object) {
		if (isContain(object) || object == null) {
			return 0;
		}
		if (objects.length == index)
			objects = Arrays.copyOf(objects, objects.length * 2);
		objects[index++] = object;
		return 1;
	}

	//通过下标得到一个对象
	public Object getOject(int i) {
		if (i < 0 || i > this.index)
			throw new ArrayIndexOutOfBoundsException();
		return objects[i];
	}
	//得到一个对象的下标
	public int getOjectIndex(Object obj) {
		for (int i = 0; i < this.index; i++) {
			if (this.objects[i].equals(obj))
				return i;
		}
		return -1;
	}

	//是否包含这个元素
	public boolean isContain(Object obj) {
		for (int i = 0; i < this.index; i++) {
			if (this.objects[i].equals(obj))
				return true;
		}
		return false;
	}

}
