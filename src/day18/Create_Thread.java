package day18;

public class Create_Thread {
	public static void main(String[] args) {
		/*
		 * 创建方式1 运行方式1
		 */
		Run1 run1 = new Run1();
		Thread t1 = new Thread(run1);
		t1.start();
		/*
		 * 主函数本身也是一个线程
		 */
		for (int i = 0; i < 100; i++) {
			System.out.println("World");
		}

		/*
		 * 创建方式2 运行方式2
		 */
		Thread run2 = new Run2();
		run2.start();

		/*
		 * 创建方式3 运行方式3
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("你好");
				}
			}
		}).start();

		/*
		 * 创建方式4 运行方式4
		 */
		new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("你好世界");
				}
			};
		}.start();
	}
}

/*
 * 创建方式1 类实现runable接口
 */
class Run1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Hello");
		}
	}
}

/*
 * 创建方式2 类继承Thread类(本身已经实现了Runable接口)
 */
class Run2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("世界");
		}
	}
}
