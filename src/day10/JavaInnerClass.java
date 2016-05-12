package day10;

public class JavaInnerClass {
	public static void main(String[] args) {
		OutClass out = new OutClass();
		out.print();
		OutClass.InnerClass inner = out.new InnerClass(); // 内部类创建方式1
		inner.printInner();
		OutClass.InnerClass in = new OutClass().new InnerClass();// 内部类直接创建 非静态需要new一个新的对象
		in.printInner();
		in.println();
		OutClass.StaticInner staticinner = new OutClass.StaticInner(); // 静态内部类直接创建 因为是静态类直接外部类（点）.出来
		staticinner.printlnTest();

	}

}

class OutClass {
	public void print() {
		InnerClass in = new InnerClass();
		System.out.println("我是外部类");
		in.setName("tangbiao");
		System.out.println(in.getName());

		// StaticInner.staticin.printlnTest(); 错误不能直接访问都要实例化静态内部类
		StaticInner staticinner = new StaticInner();
		staticinner.printlnTest();

	}

	public void getTest() {
		System.out.println("我是外部类成员方法");
	}

	class InnerClass { // 成员内部类
		private String name;
		private String age;

		public InnerClass() {

		}

		public InnerClass(String name, String age) {
			this.name = name;
			this.age = age;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void printInner() {
			System.out.println("我是内部类");
		}

		public void println() {
			System.out.println("调用外部类成员方法");
			getTest();
			// OutClass.this.getTest();//也可以这样调用外部类方法 OutClass.this
			// 即为外部类的当前对象目前可以省略 可能在将来实际开发中不能省略
		}
	}

	static class StaticInner {
		public void printlnTest() {
			System.out.println("内部静态类");
		}
	}
}
