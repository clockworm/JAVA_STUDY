package day18;

//多个线程之间数据共享的问题   方法锁
public class Thread_Money2 {

	public static void main(String[] args) {
		Money2 mo = new Money2();
		Thread t1 = new Thread(mo);
		Thread t2 = new Thread(mo);
		Thread t3 = new Thread(mo);
		t1.start();
		t3.start();
		t2.start();
	}

}

class Money2 implements Runnable {
	private int money = 0;// 初始金额
	private int h = 0;// 初始账单

	@Override
	public synchronized void run() {         				// 方法加锁 锁对象是当前对象
		for (int i = 1; i <= 10; i++) {
			h = money + 1; // 生成账单
			try {
				Thread.sleep(200);                               // 银行处理   加锁之后 银行处理完毕才会继续执行下面代码知道锁退出
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			money = h; // 处理完毕
			System.out.println(money);
		}
	}
}
