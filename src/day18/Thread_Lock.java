package day18;

import java.util.concurrent.locks.ReentrantLock;

//多个线程之间数据共享的问题   Lock锁
public class Thread_Lock {

	public static void main(String[] args) {
		Money3 mo = new Money3();
		Thread t1 = new Thread(mo);
		Thread t2 = new Thread(mo);
		Thread t3 = new Thread(mo);
		t1.start();
		t3.start();
		t2.start();
	}

}

class Money3 implements Runnable {
	private int money = 0;													 // 初始金额
	private int h = 0;													 		 // 初始账单
	private ReentrantLock lock = new ReentrantLock();		 // 锁对象

	@Override
	public void run() { 
		lock.lock(); 														         // 加锁
		try {
			for (int i = 1; i <= 10; i++) {
				h = money + 1; // 生成账单
				try {
					Thread.sleep(200); // 银行处理
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				money = h; // 处理完毕
				System.out.println(money);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();												            //解锁
		}

	}
}
