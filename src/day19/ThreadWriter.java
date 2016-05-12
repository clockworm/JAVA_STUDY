package day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//发送信息
public class ThreadWriter extends Thread {
	private BufferedReader in;
	private PrintWriter pw;

	/**
	 * @param in
	 * @param pw
	 */
	public ThreadWriter(BufferedReader in, PrintWriter pw) {
		this.in = in;
		this.pw = pw;
	}

	@Override
	public void run() {
		try {
			while (true) {
				pw.println(in.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
