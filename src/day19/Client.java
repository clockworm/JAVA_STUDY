package day19;

/**
 * 网络通讯  底层原理就是IO管道流的操作
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket socket;
		try {
			/*
			 * 建立链接
			 */
			socket = new Socket("127.0.0.1", 9000);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String message = in.readLine();
			/*
			 * 发送给服务器端的信息
			 */
			PrintWriter print = new PrintWriter(socket.getOutputStream());
			print.println(message);
			print.flush();
//			print.close();
			/*
			 * 获取服务器的信息 打印服务器的信息
			 */
			BufferedReader in2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message2 = in2.readLine();
			in2.close();
			print.close();
			System.out.println(message2);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
