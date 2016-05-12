package day19.job;
/**
 * 信息讀入流
 * @author Tom
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderMessage implements Runnable {
	private Socket socket;  				//客户管道
	private BufferedReader in;   		//获取管道信息流
	private Bank bank;    				//客户银行

	public ReaderMessage(Socket socket, Bank bank) {
		this.socket = socket;
		this.bank = bank;
	}

	@Override
	public void run() {   																		//不停的索取服务器信息
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String message = in.readLine();
				if (message == null && "".equals(message)) {
					continue;
				}
				int index = message.indexOf("#"); 
				if (index == -1) {                      											//直接获取反馈信息
						System.out.println(message);
						System.out.println("当前余额:" + bank.getMoney());
				} else {   																			//转账失败 服务器返回的金额
					String[] address_money = message.split("#");
					Double money$ = Double.parseDouble(address_money[1]);   
					bank.add(money$);
					System.out.println(message);
					System.out.println("当前余额:" + bank.getMoney());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
