package day15;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//管道流 字节交流。
public class JavaIO_PipedIn_Out {

	public static void main(String[] args) {
		try {
			// 管道流 一遍写一遍读
			PipedInputStream in = new PipedInputStream();
			PipedOutputStream out = new PipedOutputStream(in);// 管道连接方式1
			// PipedOutputStream out = new PipedOutputStream();
			// PipedInputStream in = new PipedInputStream(out);// 管道连接方式2
			OutputPiped outpip = new OutputPiped(out);
			InputPiped inpip = new InputPiped(in);
			outpip.pipedWrite();
			inpip.pipedRead();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class OutputPiped {
	OutputStream out;

	public OutputPiped(OutputStream out) {
		this.out = out;
	}

	public void pipedWrite() {
		try {
			byte value = (byte) (Math.random() * 100);
			out.write(value);
			System.out.println("pipedWrite 管道: " + value);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class InputPiped {
	InputStream in;

	public InputPiped(InputStream in) {
		this.in = in;
	}

	public void pipedRead() {
		try {
			byte value = (byte) in.read();
			System.out.println("pipedRead 管道: " + value);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
