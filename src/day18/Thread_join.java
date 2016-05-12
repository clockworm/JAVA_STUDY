package day18;

public class Thread_join {
	public static void main(String[] args) {
		A a = new A();
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("我在这里");
				}
			}
		});
		for (int i = 0; i < 10; i++) {
			try {
				while (true) {
					Thread.yield(); // 主动放弃CPU給其他進程 重新爭取執行
					break;
				}
				System.out.println("Helloworld");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		a.start();
		t3.setPriority(10);
		t3.start();
		try {
			t3.join(); // 让其他线程等待
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class A extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}