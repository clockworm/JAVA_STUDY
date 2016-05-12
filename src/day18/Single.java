package day18;

//单例模式 只能创建一次
public class Single {
	// 靜態化自己
	private static Single instance = null;

	// 构造函数私有化
	private Single() {
	}

	// 构造一份自己
	public static synchronized Single getInstance() { //防止并发而多次创建 锁对象是当前类类型this.class
		if (instance == null) {
			instance = new Single();
		}
		return instance;
	}
}
