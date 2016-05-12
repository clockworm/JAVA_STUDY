package day3;
//Switch判断
public class OperatorSwitch{

	public static void main(String[] args) {
			int i = 6;
		switch(i){
			case 0:
				System.out.println("星期日");
			break;
			case 1:
				System.out.println("星期一");
			break;
			case 2:
				System.out.println("星期二");
			break;
			case 3:
				System.out.println("星期三");
			break;
			case 4:
				System.out.println("星期四");
			break;
			case 5:
				System.out.println("星期五");
			break;
			case 6:
				System.out.println("星期六");
			break;
			default:
				System.out.println("输入错误");
			break;
		}
	//案例 输入年月日 判断这个日期在这一年段过了多少天
	int year = 2000;
	int m = 4;
	int day = 20;
	int count = 0;
	switch(m-1){
			case 11:
				count += 30;
			case 10:
				count += 31;
			case 9:
				count += 30;
			case 8:
				count += 31;
			case 7:
				count += 31;
			case 6:
				count += 30;
			case 5:
				count += 31;
			case 4:
				count += 30;
			case 3:
				count += 31;
			case 2:
				if (year%4==0&&year%100!=0||year%400==0) 
					count += 29;
		        else
					count += 28;
			case 1:
				count += 31;	
		}
		count += day;
		System.out.println("在"+year+"年已经过去了"+count+"天");
	}
}
