package day18;

public class Userserver_Main {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					Userserver user = Userserver.getInstance();
					System.out.println(Thread.currentThread().getName() + ": " + user);
					A a = new A();
					B b = new B();
					C c = new C();
					a.print();
					b.print();
					c.print();
				}
			}) {
			}.start();
		}
		//同一个线程同一个对象  不同線程不同對象
		Userserver user1 = Userserver.getInstance();
		Userserver user2 = Userserver.getInstance();
		Userserver user3 = Userserver.getInstance();
		Userserver user4 = Userserver.getInstance();
		System.out.println(user1 + ":" + user2 + ":" + user3 + ":" + user4);

	}

	static class A {
		public void print() {
			Userserver user = Userserver.getInstance();
			System.out.println("A..." + Thread.currentThread().getName() + ": " + user);
		}
	}

	static class B {
		public void print() {
			Userserver user = Userserver.getInstance();
			System.out.println("B..." + Thread.currentThread().getName() + ": " + user);
		}
	}

	static class C {
		public void print() {
			Userserver user = Userserver.getInstance();
			System.out.println("C..." + Thread.currentThread().getName() + ": " + user);
		}
	}
}
