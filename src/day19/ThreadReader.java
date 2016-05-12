package day19;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadReader extends Thread {
	private BufferedReader in;

	/**
	 * @param in
	 */
	public ThreadReader(BufferedReader in) {
		this.in = in;
	}

	@Override
	public void run() {
		String message;
		try {
			while (true) {
				message = in.readLine();
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
