package day22.Dao;

import java.util.ArrayList;

public interface Dao<E> {

	/**
	 * 返回所有元素
	 * 
	 * @return
	 */
	public ArrayList<E> findList();

	/**
	 * 查找某一个元素
	 * 
	 * @return
	 */
	public E find(E e);

	/**
	 * 添加元素到集合
	 * 
	 * @return
	 */
	public boolean add(E e);

	/**
	 * 修改某個元素 并返回修改后的元素
	 * 
	 * @return
	 */
	public E update(E e);
}
