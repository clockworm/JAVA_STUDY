package day2;
//表达式
//&&和|| 短路判断  &&先写False表达式  ||先写True表达式
public class OperatorBoolean{

	public static void main(String[] args) {
		int a = 10,b = 20;
		// a++;
		// System.out.println(a);
		boolean f = (a==10 && b > 20);
		System.out.println(f);

		boolean f1 = a++ == 10 || b-- <= 20;
		System.out.println(f1);
		System.out.println(a);
		System.out.println(b);

		//三目运算  表达式1 ? 结果1 : 结果2
		int a1 = 10;
		int b1 = a1 > 10 ? a1+10 : a1-3;
		System.out.println(b1);

		int a2 = 20;
		a2 += 5.5;// b = int(b+5.5) 不等价b = b+ 5.5
		System.out.println(a2);
		//强制转化面试题
		short a3 = 2;
		a3 = (short)(a3 + 1);
		// a3 += 1;
		System.out.println(1+2+3+"hello");
		System.out.println("hello"+1+2+3);
		



	}
	
}