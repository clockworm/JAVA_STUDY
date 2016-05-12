package day22.examSystem.entity;

/**
 * 接收服务器数据
 */
import java.io.Serializable;

public class Response implements Serializable {
	private Exception exception;
	private Object object;
	private boolean isSucces;
	private String session;

	public Response() {
	}

	public Response(Exception exception, Object object, boolean isSucces, String session) {
		this.exception = exception;
		this.object = object;
		this.isSucces = isSucces;
		this.session = session;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public boolean isSucces() {
		return this.isSucces = this.exception == null;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
}
