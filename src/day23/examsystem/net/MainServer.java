package day23.examsystem.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.UUID;

import day22.examSystem.control.ClientContext;
import day22.examSystem.dao.EntityContext;
import day22.examSystem.entity.Request;
import day22.examSystem.entity.Response;
import day22.examSystem.server.ExamServerImp;
import day22.examSystem.util.ReadUtil;

public class MainServer {
	private HashMap<String, ExamServerImp> services = new HashMap<String, ExamServerImp>();
	private EntityContext entityContext;
	private ExamServerImp service;

	public static void main(String[] args) {
		MainServer mainServer = new MainServer();
		EntityContext entityContext = new EntityContext();
		mainServer.setEntityContext(entityContext);
		mainServer.startServer();
	}

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	public void startServer() {
		try {
			ServerSocket server = new ServerSocket(Integer.parseInt(ReadUtil.getMessage("port")));
			System.out.println("服务器开启...");
			while (true) {
				Socket socket = server.accept();
				new ExamThread(socket).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class ExamThread extends Thread {
		private Socket socket;
		private Request request;
		private Response response;

		public ExamThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			setRequest(socket); // 调用这个方法 request属性已经有值了
			service = getService(request);
			response = new Response();
			response.setSession(request.getSession());
			try {
				Object obj = invokeMethod(service, request);
				response.setObject(obj);
			} catch (Exception e) {
				response.setException(new RuntimeException(e.getMessage()));
			} finally {
				try {
					response.isSucces();
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					// 写回响应
					out.writeObject(response);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		/*
		 * 获取請求数据
		 */
		private Request setRequest(Socket socket) {
			try {
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				request = (Request) in.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return request;
		}

		/*
		 * 服务器端响应给客户端的唯一標識 钥匙
		 */
		private ExamServerImp getService(Request request) {
			String session = request.getSession();
			if (session == null) {
				session = UUID.randomUUID().toString();
				request.setSession(session);
				ExamServerImp service = new ExamServerImp();
				service.setEntityContext(entityContext);
				services.put(session, service);
			}
			return services.get(session);
		}

		/**
		 * 获取业务方法
		 */
		private Object invokeMethod(ExamServerImp service, Request request) throws Exception {
			Class c = service.getClass();
			Object obj = null;
			try {
				Method m = c.getMethod(request.getMethodName(), request.getParamTypes());
				obj = m.invoke(service, request.getObjs());
				return obj;
			} catch (InvocationTargetException e) {
				throw new Exception(e.getTargetException().getMessage());
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
