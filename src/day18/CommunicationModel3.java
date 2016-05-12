package day18;

//通信原始模型3 通信交互同类使用
public class CommunicationModel3 {

	public static void main(String[] args) {
		Communication con = new Communication();
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

class Communication {
	String message;
	boolean flag;

	public void sender() {
		for (int i = 0; i < 5; i++) {
			synchronized (this) {
				while (flag) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				message = (int) (Math.random() * 100) + "";
				System.out.println("sender:" + message);
				flag = true;
				this.notify();
			}
		}
	}

	public void recer() {
		while (true) {
			synchronized (this) {
				try {
					while (!flag) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("recer:" + message);
				flag = false;
				this.notify();
			}
		}
	}

}
