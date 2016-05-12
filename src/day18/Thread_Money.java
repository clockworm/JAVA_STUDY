package day18;

//多个线程之间数据共享的问题  代码块锁
public class Thread_Money {

	public static void main(String[] args) {
		Money mo = new Money();
		Thread t1 = new Thread(mo);
		Thread t2 = new Thread(mo);
		Thread t3 = new Thread(mo);
		t1.start();
		t3.start();
		t2.start();
	}

}

class Money implements Runnable {
	private int money = 0;// 初始金额
	private int h = 0;// 初始账单

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized (this) { // 加锁 一次访问只能一个线程 直到锁释放
				h = money + 1; // 生成账单
				try {
					Thread.sleep(100); // 银行处理
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				money = h; // 处理完毕
			} // 锁释放
			System.out.println(money);
		}
	}

}
