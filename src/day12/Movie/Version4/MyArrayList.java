package day12.Movie.Version4;

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
	public int add(Object object) {
		if (isContain(object) || object == null) {
			// System.out.println("该影片已经被租赁");
			return 0;
		}
		if (objects.length == index)
			objects = Arrays.copyOf(objects, objects.length * 2);
		objects[index++] = object;
		return 1;
	}

	// 遍历迭代器
	/**
	 * 得到一个元素对象
	 * 
	 * @param i
	 * @return
	 */
	public Object getOject(int i) {
		if (i < 0 || i > this.index)
			throw new ArrayIndexOutOfBoundsException();
		return objects[i];
	}

	/**
	 * 找到一个元素对象的下标
	 */
	public int getOjectIndex(Object obj) {
		Iterator it = getIterator();
		int i = 0;
		while (!it.isDone()) {
			if (it.getCurrent().equals(obj))
				return i;
			it.next();
			i++;
		}
		return -1;
		// for (int i = 0; i < this.index; i++) {
		// if (this.objects[i].equals(obj))
		// return i;
		// }
		// return -1;
	}

	/**
	 * 是否包含这个元素
	 */
	public boolean isContain(Object obj) {
		for (int i = 0; i < this.index; i++) {
			if (this.objects[i].equals(obj))
				return true;
		}
		return false;
	}

	// 迭代器
	public Iterator getIterator() {
		class IteratorObject implements Iterator {
			int i;

			@Override
			public Object getCurrent() {
				return objects[i];
			}

			@Override
			public boolean isDone() {
				return index == i;
			}

			@Override
			public void next() {
				i++;
			}

		}
		return new IteratorObject();
	}
}
