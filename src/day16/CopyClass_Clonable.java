package day16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//克隆类 需要实现声明Clonable接口 重寫clon..方法 访问权限扩大public 
public class CopyClass_Clonable implements Cloneable, Serializable {
	private Apple apple;

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	//深拷贝
	public Object deepClone(){
		// 序列化操作
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(); // 写入一个数组
			ObjectOutputStream out = new ObjectOutputStream(bos);
 			out.writeObject(this);
			out.flush();
			out.close();
			// 反序列化
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bis);
			return in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
