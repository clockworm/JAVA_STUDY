package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
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
			while (true) {
				Socket socket = server.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				ThreadReader reader = new ThreadReader(in);
				ThreadWriter writer = new ThreadWriter(ins, pw);
				reader.start();
				writer.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
