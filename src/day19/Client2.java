package day19;

/**
 * 网络通讯  底层原理就是IO管道流的操作
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {

	public static void main(String[] args) {
		Socket socket;
		try {
			/*
			 * 建立链接
			 */
			socket = new Socket("127.0.0.1", 9000);
			BufferedReader in2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter print = new PrintWriter(socket.getOutputStream(), true);
			ThreadReader reader = new ThreadReader(in2);
			ThreadWriter writer = new ThreadWriter(in, print);
			reader.start();
			writer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
