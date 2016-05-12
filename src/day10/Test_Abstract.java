package day10;

public class Test_Abstract { 
	public static void main(String[] args) {

		Shape c = new Circle(10, 10, 10);
		Circle c1 = new Circle(10, 10, 10);

		System.out.println(c.getLength());
		System.out.println(c1.getArea());
		System.out.println(c.getLocation().getDistance());
		
		SingQuestion s = new SingQuestion("选择爱情电影", new String[] { "A.我爱你", "B.战争年代" }, "A");
		System.out.println(s.check(new String[] { "B" }));
		// Shape s = new Shape(); //抽象类不能被实例化
		Question[] qs = new Question[3]; //抽象类不能被实例化 可以创建对象数组引用
		qs[0] = new SingQuestion("选择爱情电影", new String[] { "A.我爱你", "B.战争年代" }, "A");
		qs[1] = new MultipleQuestion("选择动作电影", new String[] { "A.我爱你", "B.功夫", "C.拳王" }, new String[] { "B", "C" });
		qs[2] = new MultipleQuestion("选择国产电影", new String[] { "A.i love you", "B.小年代", "i believe" },
				new String[] { "A", "C" });
		for (Question q : qs) {
			q.printQuestionContent();
		}
		System.out.println(qs[0].check(new String[] { "C" }));
		System.out.println(qs[1].check(new String[] { "A", "B" }));
		System.out.println(qs[2].check(new String[] { "A", "C" }));
	}
}
