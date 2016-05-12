package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		InetAddress inet;
		ServerSocket server;
		try {
			/*
			 * 本地IP
			 */
			inet = InetAddress.getByName(null);
			System.out.println(inet.getHostAddress());
			/*
			 * 开启服务器 端口为9000 客户端链接后才会执行下面的代码
			 */
			server = new ServerSocket(9000);
			Socket socket = server.accept();
			System.out.println("客户端连接ing ...");
			/*
			 * 获取客户端的信息 打印客户端的信息
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = in.readLine();
			// in.close();
			System.out.println(message);
			/*
			 * 发送给客户端的信息
			 */
			BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
			String message2 = ins.readLine();
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(message2);
			pw.flush();
			pw.close();
			in.close();
			ins.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
