package day18;

//通信原始模型
public class CommunicationModel {

	public static void main(String[] args) {
		Sender sender = new Sender();
		Recer recer = new Recer(sender);
		Thread t1 = new Thread(sender);
		Thread t2 = new Thread(recer);
		t1.start();
		t2.start();

	}

}

class Sender implements Runnable {
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
			while (flag) {
				Thread.yield();
			}
			message = (int) (Math.random() * 100) + "";
			System.out.println("send :" + message);
			flag = true;
		}
	}
}

class Recer implements Runnable {
	private Sender sender;

	/**
	 * @param sender
	 */
	public Recer(Sender sender) {
		this.sender = sender;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			while (!sender.isFlag()) {
				Thread.yield();
			}
			System.out.println("rece:" + sender.getMessage());
			sender.setFlag(false);
		}
	}

}
