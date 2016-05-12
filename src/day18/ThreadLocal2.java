package day18;

//数据共享 经过多个模块数据相同
import java.util.HashMap;

public class ThreadLocal2 {
	private static HashMap<Thread, Integer> map = new HashMap<Thread, Integer>();
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();  //线程数据共享集合
	static int value = 0;

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					a.getData();
					b.getData();
					c.getData();
				}
			}) {
			}.start();
		}
	}

	static class A {
		public synchronized void getData() {
			Thread t = Thread.currentThread();
			value = (int) (Math.random() * 1000);
			System.out.println(t.getName() + "Value的值：" + value);
			map.put(t, value);
			tl.set(value);
			System.out.println("A.." + t.getName() + ":" + map.get(t)+":"+tl.get());
		}
	}

	static class B {
		public void getData() {
			Thread t = Thread.currentThread();
			System.out.println("B.." + t.getName() + ":" + map.get(t)+":"+tl.get());
		}

	}

	static class C {
		public void getData() {
			Thread t = Thread.currentThread();
			System.out.println("C.." + t.getName() + ":" + map.get(t)+":"+tl.get());
		}
	}
}
