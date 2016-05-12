package day22.examSystem.entity;

/**
 * 封装发送请求数据  实现序列化接口  方便網絡傳輸數據
 */
import java.io.Serializable;
import day22.Field_Annotation;

public class Request implements Serializable {

	@Field_Annotation(name = "封装发送数据")
	private Object[] objs;
	@Field_Annotation(name = "封装发送数据类型")
	private Class[] paramTypes;
	@Field_Annotation(name = "请求调用的方法对象")
	private String methodName;
	@Field_Annotation(name = "请求的唯一标识")
	private String session;

	public Request() {
	}

	/**
	 * @param objs
	 * @param paramTypes
	 * @param methodName
	 */
	public Request(Object[] objs, Class[] paramTypes, String methodName) {
		this.objs = objs;
		this.paramTypes = paramTypes;
		this.methodName = methodName;
	}

	public Object[] getObjs() {
		return objs;
	}

	public void setObjs(Object[] objs) {
		this.objs = objs;
	}

	public Class[] getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
}
