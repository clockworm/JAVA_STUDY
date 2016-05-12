package day18;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//通信原始模型4 通信交互同类使用  lock机制
public class CommunicationModel4 {

	public static void main(String[] args) {
		Communication4 con = new Communication4();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				con.sender();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				con.recer();
			}
		});

		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}

class Communication4 {
	String message;
	boolean flag;
	private ReentrantLock lock = new ReentrantLock();
	private Condition cdn = lock.newCondition();

	public void sender() {
		for (int i = 0; i < 5; i++) {
			lock.lock();
			while (flag) {
				try {
					cdn.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			message = (int) (Math.random() * 100) + "";
			System.out.println("sender:" + message);
			flag = true;
			cdn.signal();
			lock.unlock();
		}
	}

	public void recer() {
		while (true) {
			lock.lock();
			try {
				while (!flag) {
					cdn.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("recer:" + message);
			flag = false;
			cdn.signal();
			lock.unlock();
		}
	}

}
