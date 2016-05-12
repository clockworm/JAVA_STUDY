package day19.job;
/**
 * 客户端
 * @author Tom
 *
 */
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 9000);
			Bank bank = Bank.getInstance();
			/*
			 * 反馈信息
			 */
			ReaderMessage reader = new ReaderMessage(socket, bank);
			/*
			 *  转款  
			 */
			WrinteMessage wrinter = new WrinteMessage(socket, bank);
			Thread t1 = new Thread(reader);
			Thread t2 = new Thread(wrinter);
			/*
			 *开始处理 
			 */
			t1.start();
			t2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
