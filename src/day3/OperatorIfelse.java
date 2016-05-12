package day3;
//if else判断
//import java.util.Scanner;

public class OperatorIfelse{

	public static void main(String[] args) {
		/*
		排序输出 从小到大
		*/
//		Scanner s = new Scanner(System.in);
		int a1=101,a2=23,a3=53,tep;
		// System.out.println("请输入第一个数:");
		// a1 = s.nextInt();
		// System.out.println("请输入第二个数:");
		// a2 = s.nextInt();
		// System.out.println("请输入第三个数:");		
		// a3 = s.nextInt();
		if (a1>a2) {
			tep = a1;
			a1 = a2;
			a2 = tep;
		}
		if (a1>a3) {
			tep = a1;
			a1 = a3;
			a3 = tep;
		}
		//a1最小  a2 a3 大小不确定
		if(a2>a3){
			tep = a2;
			a2 = a3;
			a3 = tep;
		}
		System.out.println(a1+","+a2+","+a3);
		//闰年判断
		int year = 2400;
		if (year%4==0&&year%100!=0||year%400==0) 
			System.out.println(year+"年是闰年");
		else
			System.out.println(year+"年不是闰年");
	}
}
