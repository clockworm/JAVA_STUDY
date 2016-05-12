package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 网络通讯 底层原理就是IO管道流的操作
 */
public class Client3 {

	public static void main(String[] args) {
		new Client3().startClient();
	}

	public void startClient() {
		try {
			Socket socket = new Socket("127.0.0.1", 9025);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			new AcceptMessage(socket).start();
			while (true) {
				String message = in.readLine();
				if ("exit".equals(message))
					break;
				pw.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class AcceptMessage extends Thread {
	private Socket socket;
	private BufferedReader in;

	public AcceptMessage(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String str = in.readLine();
				if ("".equals(str) || str == null) {
					continue;
				}
				if ("exit".equals(str)) {
					System.out.println("有客户端退出!");
				}
				int index = str.indexOf("/");
				// 群聊
				if (index == -1) {
					System.out.println("群聊的内容是：" + str);
				} else { // 私聊
					if (str.split("/")[0].equals("0")) {
						System.out.println("服务器反馈:" + str.split("/")[1]);
					} else {
						System.out.println("客户端" + str.split("/")[0] + "对我说:" + str.split("/")[1]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
