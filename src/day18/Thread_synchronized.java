package day18;

public class Thread_synchronized {
	public static void main(String[] args) {
		A2 a1 = new A2();
		A2 a2 = new A2();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					a1.print3("Hello");
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					a2.print4("World");
				}
			}
		});

		t1.start();
		t2.start();
	}

}

class A2 {
	public void print(String name) { // 锁---->当前对象
		synchronized (this) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}

	public synchronized void print2(String name) { // 锁---->当前对象
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}

	public static synchronized void print3(String name) { // 锁---->当前类类型
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}

	public void print4(String name) {
		synchronized (A2.class) { // 锁---->当前类类型
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}

}
