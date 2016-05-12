package day18;

public class Thread_Method {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("线程ing...");
			}
		});
		System.out.println(t1.getName());
		t1.setName("Thread-线程1"); // 线程名称设置
		System.out.println(t1.getName());
		try {
			t1.interrupt(); //中断该线程 必須線程是在運行狀態
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t1.start();
		System.out.println(t1.getPriority()); // 优先级 1-10之间
		t1.setPriority(10);
		System.out.println(t1.getPriority());
		Thread t2 = Thread.currentThread(); // 得到当前的线程
		System.out.println(t2.getState());// 线程状态
		System.out.println(t2.getName());
	}

}
