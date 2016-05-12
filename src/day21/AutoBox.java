package day21;

public class AutoBox {
	public static void main(String[] args) {
		Integer num = 1;// 自动装箱
		Integer num0 = new Integer(1);
		int a = num0;// 自动拆箱
		/**
		 * 自动装箱对于byte int long short -128到127之间 对于char 0到 127之间 存在享元模式
		 */

		Integer num1 = 10;
		Integer num2 = 10;
		System.out.println(num1 == num2);  //享元模式                  true
		
		Integer num5 = Integer.parseInt("11");
		Integer num6 = Integer.parseInt("11");
		System.out.println(num5 == num6);  //享元模式                  true
		
		Integer num3 = 128;
		Integer num4 = 128;
		System.out.println(num3 == num4);//開了新空間					false
	}
}
