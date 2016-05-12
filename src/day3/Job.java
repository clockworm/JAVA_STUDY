package day3;
/**
作业1: 托运计费问题： 当货物重量小于20 公斤的时候，收费5 元，
 大于20 公斤小于100 公斤的时候超出20 公斤 的部分按每0.2 元每公斤计费， 
 如果超出100 公斤的时候，超出的部分按照 每公斤0.15 元计算。读入货物的重量， 
输出计算之后货物的运费。 
作业2: 读入一个三位数，计算其各位数字之和。 例如：123各位数字之和为6 
作业3: 输入一个年月日，求这一年还剩下多少天 (提示:总天数-已经过的) 
作业4: 输入三个数字从大到小排序输出
**/

public class Job{

	public static void main(String[] args) {
		//作业1：
		int weight = 105;
		if (weight<=20) {
			System.out.println("货物运输费5元");
		}else if (weight>20&&weight<100) {
			System.out.println("货物运输费"+weight*0.2+"元");
		}else if (weight>=100) {
			System.out.println("货物运输费"+weight*0.15+"元");
		}
		//作业2：
		int i = 987;
		int a = i%100%10;
		int b = i/10%10;
		int c = i/100;
		System.out.println(a+b+c);
		//作业3:
		int year = 2000; //年
		int m = 2; //月
		int day = 20; //天
		int count = 0; 
		switch (m-1) {
			case 11:
				count+=30;
			case 10:
				count+=31;
			case 9:
				count+=30;
			case 8:
				count+=31;
			case 7:
				count+=31;
			case 6:
				count+=30;
			case 5:
				count+=31;
			case 4:
				count+=30;
			case 3:
				count+=31;
			case 2:
				if (year%4==0&&year%100!=0||year%400==0)
					count+=29;
				else
					count+=28;
			case 1:
				count+=31;
		}
		count = count + day;
		System.out.println(year+"年已经过去了"+count+"天");	

		//作业4：
		int a1 = 13; 
		int a2 = 4; 
		int a3 = 9; 
		if (a1<a2) {
			a1 = a1^a2;
			a2 = a1^a2;
			a1 = a1^a2;
		}
		if (a1<a3) {
			a1 = a1^a3;
			a3 = a1^a3;
			a1 = a1^a3;
		}
		if (a2<a3) {
			a2 = a2^a3;
			a3 = a2^a3;
			a2 = a2^a3;
		}
		System.out.println(a1+" > "+a2+" > "+a3);
	}
}
