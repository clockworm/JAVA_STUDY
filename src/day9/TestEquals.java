package day9;

public class TestEquals {
	public static void main(String[] args) {
		Circle c1 = new Circle(10, 11, 12);
		c1.printLocation();
		System.out.println(c1.getArea());
		System.out.println(c1.getLength());
		System.out.println(c1.isContain(10, 13));
		System.out.println(c1.getLocation().getDistance());
		Student stu = new Student();
		stu.setNo(1);
		stu.setName("张三");
		stu.setAge(12);
		System.out.println(stu);
		Student stu1 = new Student(1, "李四", 16);
		System.out.println(stu1);
		System.out.println(stu.equals(stu1));
		System.out.println(stu == stu1);

		String a = "123";
		String b = "123";
		System.out.println(a == b);
		System.out.println(a.equals(b));
		StringBuilder abc = new StringBuilder("abc");
		StringBuilder abc1 = new StringBuilder("abc");
		System.out.println(abc==abc1);
		System.out.println(abc.equals(abc1));
	}
}
