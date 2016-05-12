package day22.examSystem.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtil {
	private static BufferedReader br;

	public static BufferedReader getBuffered(String path) {
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return br;
	}

	public static void close() throws IOException {
		if (br != null) {
			br.close();
		}
	}
}
