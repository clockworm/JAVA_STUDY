package day4;
/**
作业1:输入一个数，因式分解 如输入90 得到90=2*3*3*5 80 得到80=2*2*2*2*5

作业2:求水仙花数。所谓水仙花数， 是指一个三位数abc，如果满足a3+b3+c3=abc， (a的3次方)则abc 是水仙花数,打印所有水仙花数

作业3: 如果一个数等于其所有因子之和, 我们就称这个数为"完数",
例如 6 的因子为 1,2,3 6=1+2+3 6 就是一个完数. 请编程打印出1000 以内所有的完数 
作业4: 打渔还是晒网 中国有句老话叫“三天打渔，两天晒网”。 
假设有一个人从2000 年1 月1 日开始“三天 打渔两天晒网”，读入三个整数，分别表示年份、 月份、日期，问这三个整数所表示的那天
这个人在打渔还是在晒网？ 求一个日期和2000年1月1日相差多少天 

作业5: 已知：faibonacci（费波那契）数列的前几个数分别为0，1，1，2，3，5，……。 从第3 项开始，每一项都等于前两项的和。
读入一个整数n，编程求出此数列的前n 项的和。 注意：这里的数列是从0 开始的。 0 1 1 2 3 5 8 13 .... 

作业6.搬砖问题：36 块砖，36 人搬，男搬4，女搬3， 两个小孩抬1 砖，要求一次 全搬完，问男、女和小孩各若干(要求三种都要有)
**/
public class Job{
	public static void  main(String[] args){
		//作业1:
		System.out.println("-------- 作业1：--------");
		int a = 35; //可以修改
		System.out.print(a+"=");
		for (int i=2;i<=a/2;i++ ) { 
			if(a%i==0){   
				a = a/i;     
				System.out.print(i+"*"); 
				i--;
			}
		}
		System.out.println(a);

		// 作业2：
		System.out.println("-------- 作业2：--------");
		for (int i=140;i<999;i++) {
			int sum = 0;
			int t = i;
			while(t!=0){
				sum += (t%10)*(t%10)*(t%10);
				t = t/10;
			}
			if(sum==i)
				System.out.println(i);
		}

		System.out.println("-------- 作业3：--------");
		//作业3：
		for (int j=1;j<=1000;j++) {
			int sum = 0;
			for (int i=1;i<=j/2;i++) {
				if(j%i==0)
					sum+=i;
			}
			if(sum==j)
				System.out.println(sum);
		}

		//作业4：
		System.out.println("-------- 作业4：--------");
		int year = 2002; //可以修改
		int m = 1;		//可以修改
		int day = 20;	//可以修改
		int sum = 0;
		switch (m-1) {
			case 11:
				sum+=30;
			case 10:
				sum+=31;
			case 9:
				sum+=30;
			case 8:
				sum+=31;
			case 7:
				sum+=31;
			case 6:
				sum+=30;
			case 5:
				sum+=31;
			case 4:
				sum+=30;
			case 3:
				sum+=31;
			case 2:
			if (year%4==0&&year%100!=0||year%400==0) 
				sum+=29;
			else
				sum+=28;
			case 1:
				sum+=31;
		}
		if (year<2000)
			System.out.println("年份输入错误!");
		else{
			if (year==2000)
				sum += day-1;
			else if(year>2000){
				/*到2001年之间天数*/
				for(int i=2001;i<year;i++){
					if (i%4==0&&i%100!=0||i%400==0)
						sum+=366;
					else
						sum+=365;
				}
			}
			sum = sum+day+365;//加上2000年的天数和本年过去的天数
			System.out.println("从2000年1月1日开始已经过去:"+sum);
			switch(sum%5){
				case 0:
				case 1:
				case 2:
					System.out.println(year+"年"+m+"月"+day+"日"+"这个渔夫在打渔");
					break;
				case 3:
				case 4:
					System.out.println(year+"年"+m+"月"+day+"日"+"这个渔夫在晒网");
			}
		}

		//作业5:  百度模仿改
		System.out.println("-------- 作业5：--------");
		int n = 6;	//n为第n项  //可以修改
		int fn;	//fn为第n项的值
		sum = 0;
		for (int i=1;i<n;i++) {
        	fn=function(i);
        	sum+=fn;
        	// System.out.print(fn+" ,");
		}
		System.out.println("此数列的前"+n+"项的和："+sum);

		//作业6:
		//搬砖 男 4 女 3 2个小孩1砖  总36砖
		System.out.println("-------- 作业6：--------");
		for (int i=1;i<9;i++) {
			for (int j=1;j<12;j++ ) {
				int k = 36 - i - j;
				if (k%2==0&&4*i+3*j+k/2==36)
					System.out.println("男"+i+"个 "+"女"+j+"个 "+"小孩"+k+"个 ");	
			}
		}
	}
	public static int function(int n){
        if(n==1 || n==2) return 1;
        return function(n-1)+function(n-2);
	}
}
