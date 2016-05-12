package day18;
//并发缓存
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache_Lock {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private HashMap<String, String> map = new HashMap<String, String>();
	private String value;

	public String getValue(String key) {
		lock.readLock();                          //加读锁
		try {
			value = map.get(key); 			  //读数据
			if (value == null) { 				 //需要修改数据 加写锁
				lock.readLock().unlock();   //解读锁
				lock.writeLock(); 				 //有锁就必须有关闭锁 否则可能出现死锁
				try {
					if (value == null) {
						value = "获得值"; 		 // 某个地方去取获得值
						map.put(key, value);  //写数据
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.writeLock().unlock();   //解写锁
					lock.readLock();                 //加读锁
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();           //解读锁
		}
		return value;
	}
}
