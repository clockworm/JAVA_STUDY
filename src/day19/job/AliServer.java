package day19.job;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

//淘宝服务器
public class AliServer {
	//缓存客户唯一表识IP 和 客户管道
	private static HashMap<String, Socket> sockets = new HashMap<String, Socket>();   

	// 添加客户端列表
	public static void addClient(String ip, Socket socket) {
		sockets.put(ip, socket);
	}

	// 查找客户端
	public static Socket findClietn(String ip) {
		return sockets.get(ip);
	}

	// 返回这个集合
	public static HashMap<String, Socket> getSockets() {
		return sockets;
	}

	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(9000);
			System.out.println("服务器开启");
			//建立阿里银行
			Bank bank = Bank.getInstance();  
			while (true) {
				Socket socket = server.accept();
				//每个客户的唯一识别 IP+ 唯一序列表识
				String ip = socket.getLocalAddress().getHostAddress() + UUID.randomUUID().toString();
				//缓存客户IP和管道
				addClient(ip, socket);
				System.out.println(ip + "客户端连接Ing...");
				//随时读取客户发来的信息
				ClientMessage client = new ClientMessage(socket, ip, bank);
				Thread t2 = new Thread(client);
				t2.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * 不停的读取客户发来的信息 并作出相應反饋
 */
class ClientMessage implements Runnable {
	private Socket socket;   //客户管道
	private BufferedReader in;  //读取客户信息流
	private PrintWriter pwAddress; //反馈客户信息流
	private String address;  //客户唯一标识
	private Bank bank;  //阿里银行

	public ClientMessage(Socket socket, String address, Bank bank) {
		this.socket = socket;
		this.address = address;
		this.bank = bank;
	}

	@Override
	public void run() {  //不停的读取客户信息并反馈相应的信息
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pwAddress = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String message = in.readLine();
				int i = message.indexOf("#");
				String tellRegex = "[1-9][0-9]{0,3}[.]{0,1}[0-9]{0,2}"; 										// 金钱匹配格式
				if (i == -1) { 																									// 未能匹配  通过客户信息流反馈给客户
					pwAddress.println("转款格式错误");
				} else {
					/*
					 * 开始转款
					 */
					String[] address_money = message.split("#");
					String ip = address_money[0];
					String money = address_money[1];
					if (ip.equals("")) { 																						// 如果没有客户地址直接默认为给阿里转账
						if (money.matches(tellRegex)) {
							pwAddress.println("成功支付到阿里金额:"+money);
							bank.add(Double.parseDouble(money));
							System.out.println("阿里收到的钱:" + Double.parseDouble(money));
						} else {
							pwAddress.println("支付给阿里失败,金额过大");
						}
					} else { 																										// 有客户地址转给其他客户
						if (money.matches(tellRegex)) {
							Double money$ = Double.parseDouble(address_money[1]);
							Socket socketOhter = AliServer.findClietn(ip);
							if (socketOhter != null) {  
								PrintWriter pw = new PrintWriter(socketOhter.getOutputStream(), true);
								pwAddress.println("成功支付给" + ip + "金额:" + money$);
								pw.println("来自" + address + "转款#" + money$);
							} else {																								//如果有客户地址但是没有被真实找到
								pwAddress.println("收款人不存在,支付失败" + "#" + money$);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
