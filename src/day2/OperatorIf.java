package day2;
//if判断
import java.util.Scanner;

public class OperatorIf{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入老年人的年龄：");
		int a = s.nextInt();
		String str = a>=70 ? "是老年人" : "不是老年人";
		System.out.println(str);
		// if (a>=70) 
		// 	System.out.println("是一个老年人");
		// else
		// 	System.out.println("不是一个老年人");

		/*
		找出最大值
		*/
		int a1,a2,a3;
		System.out.println("请输入第一个数:");
		a1 = s.nextInt();
		System.out.println("请输入第二个数:");
		a2 = s.nextInt();
		a1 = a1>a2 ? a1 : a2;
		// if(a1<a2){
		// 	a1 = a2;
		// }
		System.out.println("请输入第三个数:");		
		a3 = s.nextInt();
		a1 = a3>a1 ? a3 : a1;
		// if(a1<a3){
		// 	a1 = a3;
		// }
		System.out.println("最大值是"+a1);
		//闰年判断
		int year = 2017;
		if (year%4==0&&year%100!=0||year%400==0) 
			System.out.println(year+"年是闰年");
		else
			System.out.println(year+"年不是闰年");	
	}
}