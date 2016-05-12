package day18;

//通信原始模型2 使用wait释放CPU资源  使用wait 必须结合synchronized关键字
public class CommunicationModel2 {

	public static void main(String[] args) {
		Sender2 sender = new Sender2();
		Recer2 recer = new Recer2(sender);
		Thread t1 = new Thread(sender);
		Thread t2 = new Thread(recer);
		t2.setDaemon(true);  //守护线程 当只剩下它的时候 结束该线程
		t1.start();
		t2.start();
	}
}

class Sender2 implements Runnable {
	private boolean flag = false;
	private String message;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void run() {
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
				System.out.println("send :" + message);
				flag = true;
				this.notify();//唤醒
			}
		}
	}
}

class Recer2 implements Runnable {
	private Sender2 sender;

	public Recer2(Sender2 sender) {
		this.sender = sender;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (sender) {
				while (!sender.isFlag()) {
					try {
						sender.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rece:" + sender.getMessage());
				sender.setFlag(false);
				sender.notify();
			}
		}
	}

}
