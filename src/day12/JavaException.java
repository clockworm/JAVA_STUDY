package day12;

public class JavaException {
	public static void main(String[] args) {
		try {
			System.out.println(10 / 10); // 产生一个除零异常对象
			System.out.println(args[0]); // 产生一个数组下标越界异常对象
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组下标越界");
		} catch (ArithmeticException e) {
			System.out.println("0不能被整除");
		} catch (Exception e) {
			System.out.println("子类异常必须放在父类的前面否则编译不通过");
		} finally {
			System.out.println("最终都会执行");
		}

		try {
			System.out.println("上锁");
			System.out.println("作事1....");
			System.out.println("作事2....");
		} finally {
			System.out.println("解锁");
		}
		// 人为处理捕获异常
		Person ps = new Person();
		try {
			ps.setAge(1001);
			System.out.println(ps.getAge());
		} catch (Exception e) {
			System.out.println("年龄超出范围");
		}
		try {
			ps.setUsername("名字过长导致异常");
		} catch (UsernameException e1) {
//			e1.printStackTrace(); //程序调试
			System.out.println("用户看到的信息："+e1.getMessage());//用户
		}
		try {
			int s = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 用户异常信息
			System.out.println(e.toString());// 调试异常类型信息
			e.printStackTrace();// 调试异常类型信息+具体异常位置
		}
	}
}

class Person {
	private int age;
	private String username;

	// throw 手动捕获异常 throws手动抛出异常给调用者处理
	public void setAge(int age) throws Exception {
		if (age > 120 || age <= 0)
			throw new Exception();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setUsername(String username) throws UsernameException {
		if (username.length() > 5 || username.length() < 0)
			throw new UsernameException("名字长度过长");
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}

// 自定义异常
@SuppressWarnings("serial")
class UsernameException extends Exception {
	public UsernameException(String message) {
		 super(message);
//		System.out.println(message);
	}
}
