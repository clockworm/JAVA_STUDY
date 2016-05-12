package day19.job;
/**
 * 信息讀入写出流
 * @author Tom
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WrinteMessage implements Runnable {
	private Socket socket;         //客户管道
	private BufferedReader in;  //键盘输入流
	private PrintWriter pw;		  //通知服务器信息流
	private Bank bank;			  //客户银行		

	public WrinteMessage(Socket socket, Bank bank) {
		this.socket = socket;
		this.bank = bank;
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String message = in.readLine();
				int i = message.indexOf("#");
				String tellRegex = "[1-9][0-9]{0,3}[.]{0,1}[0-9]{0,2}";									// 金錢匹配格式
				if (i == -1) { 																							    // 金錢不合法
					System.out.println("转账格式： 客户#金额 或者直接给阿里   #金额");
				} else { 																										// 合法就转给相应客户
					String[] address_money = message.split("#");
					String money = address_money[1];
					if (money.matches(tellRegex)) {															//判断金额是否合法
						if(bank.getMoney()<Double.parseDouble(money)){                           //判断转账金额是否大余本身存款
							System.out.println("余额不足");
						}else{
							if (Double.parseDouble(money) > 5000) {                                     //判断每次转账金额是否5000
								System.out.println("转账金额过大，每次最多轉5000");
							} else {																							//合法并开始转款 作相应处理
								Double money$ = Double.parseDouble(address_money[1]);	
								bank.sub(money$);																	//扣除客户银行转账的金额
								pw.println(message);																//通知服务器
							}
						}
					} else {
						System.out.println("金额不合法");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
