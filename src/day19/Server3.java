package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

public class Server3 {
	private static HashMap<String, Socket> sockets = new HashMap<String, Socket>();

	public static void main(String[] args) {
		new Server3().startServer();
	}

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

	public void startServer() {
		Socket socket;
		ServerSocket server;
		try {
			server = new ServerSocket(9025);
			while (true) {
				socket = server.accept();
				String ip = socket.getLocalAddress().getHostName() + UUID.randomUUID().toString();
				new InputMessage(socket, ip).start();
				addClient(ip, socket);
				System.out.println(ip + "服务器连接...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class InputMessage extends Thread {
	private Socket socket;
	private PrintStream ps; // 当前客户端写
	private PrintWriter pw; // 群聊
	private BufferedReader bin;
	private String addr;

	public InputMessage(Socket socket, String addr) {
		this.socket = socket;
		this.addr = addr;
	}

	// 读数据
	public void run() {
		try {
			ps = new PrintStream(socket.getOutputStream(), true);
			bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				// 接收数据
				String message = bin.readLine();
				System.out.println("接收的信息：" + message);
				if ("".equals(message) || message == null)
					continue;
				if ("exit".equals(message))
					System.out.println("有客户端退出!");
				int index = message.indexOf("/");
				if (index == -1) {
					for (String ip : Server3.getSockets().keySet()) {
						Socket clientsock = Server3.findClietn(ip);
						PrintStream clientToClient = new PrintStream(clientsock.getOutputStream(), true);
						clientToClient.println(message);
					}
				} else {
					System.out.println("消息来自是：" + socket);
					String[] addrs = message.split("/");
					String addrSender = this.addr;
					System.out.println("等待转发的信息是：" + addrs[0] + "" + addrs[1]);
					Socket clientsock = Server3.findClietn(addrs[0]);
					System.out.println("是否找到了：" + clientsock);
					if (clientsock == null) {
						ps.println("0/接受者不存在发送失败");
					} else {
						System.out.println("准备转发给:" + clientsock);
						pw = new PrintWriter(clientsock.getOutputStream(), true);
						pw.println(addrSender + "/" + addrs[1]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.start();
	}

}