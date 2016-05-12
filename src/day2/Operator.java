package day2;
//运算符
public class Operator{

	public static void main(String[] args) {
		//计算各个位之和
		int a = 228;
		//取个位
		int a1 = a%10;
		//取十位
		int a2 = a/10%10;
		//取百位
		int a3 = a/100;
		System.out.println(a1+a2+a3);
		System.out.println(3/2.0);

		int a_ = 10;
		int b = a_++;  //a为11 但b为10
		int c = ++a_;
		System.out.println(b); 
		System.out.println(c); // 12
	}
	
}