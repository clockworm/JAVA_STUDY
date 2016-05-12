package day18;

/*
 * 写两个线程，一个线程打印1~52，另一个线程打印字母A-Z。打印顺序为12A34B56C……5152Z。要求用线程间的通信。
 */
public class JobThread {
	public static void main(String[] args) {
		A30 a = new A30();
		B30 b = new B30(a);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();

	}
}

class A30 implements Runnable {
	private boolean flag = false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		for (int i = 1; i < 53; i++) {
			synchronized (this) {
				while (flag) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(i);
				if (i % 2 == 0) {
					flag = true;
					this.notify();
				}
			}
		}
	}
}

class B30 implements Runnable {
	private A30 a30;

	/**
	 * @param a30
	 */
	public B30(A30 a30) {
		this.a30 = a30;
	}

	@Override
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			synchronized (a30) {
				while (!a30.isFlag()) {
					try {
						a30.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(c);
				a30.setFlag(false);
				a30.notify();
			}
		}
	}
}