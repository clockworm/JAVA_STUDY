package day23.examsystem.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import day22.examSystem.entity.Request;
import day22.examSystem.entity.Response;
import day22.examSystem.util.ReadUtil;

public class SocketUtil {
	private static Socket socket;

	public static Response remoteAll(Request request) {
		try {
			int port = Integer.parseInt(ReadUtil.getMessage("port"));
			socket = new Socket(ReadUtil.getMessage("ip"), port);
			// 发送请求
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(request);
			out.flush();
			// 接收响应
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			Object obj = in.readObject();
			return (Response) obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
