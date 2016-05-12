package day5;
/*
Method方法
*/
class JavaFunction {
	public static void main(String[] args) {
		printSons(971);
		printSons(13);
		System.out.println(add(25,3));

		for (int i=100;i<1000;i++ ) {
			if (isPrimeNumber(i))
				System.out.print(i+" ");
		}
		System.out.println();

		for (int i=10;i<1001;i++) {
			if(getSum(i)%5==0)
				System.out.print(i+"  ");
		}
		System.out.println();

		//素数倒过来也是素数
		for (int i=10;i<1000;i++ ) {
			if (isPrimeNumber(i)&&isPrimeNumber(reversNumber(i))) 
				System.out.print(i+"   ");
		}
		System.out.println();
		
		System.out.println("相差一共："+subDays(1999,1,5,2001,3,10)+"天");

		System.out.println(getFactorielle(6));

		System.out.println(getNFibonacci(4));
	}

	//因子方法
	public static void printSons(int a) {
		for (int i=1;i<=(a/2+1);i++ ) {
			if(a%i==0)
				System.out.print(i+"  ");
		}
		System.out.println();
	}

	//2个数求和
	public static int add(int a,int b) {
		return a + b;
	}

	//是否为素数
	public static boolean isPrimeNumber(int a) {
		for (int i=2;i<=(a/2+1);i++ ) {
			if (a%i==0)
				return false;
		}
		return true;
	}

	//返回各个位数之和
	public static int getSum(int a) {
		int sum = 0;
		while(a!=0){
			sum+=a%10;
			a = a/10;
		}
		return sum;
	}

	//数字倒置
	public static int reversNumber(int a) {
		int sum = 0;
		while(a!=0){
			sum=sum*10+a%10;
			a = a/10;
		}
		return sum;
	}

	//这一年过去了多少天
	public static int getDays(int y,int m,int d) {
		int sum=0;
		switch(m-1){
			case 11:sum+=30;
			case 10:sum+=31;
			case 9:sum+=30;
			case 8:sum+=31;
			case 7:sum+=31;
			case 6:sum+=30;
			case 5:sum+=31;
			case 4:sum+=30;
			case 3:sum+=31;
			case 2:
				if(isLeapyear(y))
					sum+=29;
				else
					sum+=28;
			case 1:sum+=31;
		}
		sum = sum + d;
		return sum;
	}

	//判断是否闰年
	public static boolean isLeapyear(int y) {
		if(y%4==0&&y%100!=0||y%400==0)
			return true;
		return false;
	}

	//一年还剩下多少天
	public static int remainDays(int y,int m,int d) {
		if(isLeapyear(y))
			return 366 - getDays(y,m,d);
		return 365 - getDays(y,m,d);
	}

	//相差的两个日期的天数
	public static int subDays(int y1,int m1,int d1,int y2,int m2,int d2) {
		if (y1 == y2) {
			return getDays(y2,m2,d2)-getDays(y1,m1,d1);
		}else{
			int sum = 0;
			sum = getDays(y2,m2,d2)+remainDays(y1,m1,d1);
			for (int i=(y1+1);i<y2;i++) {
				if(isLeapyear(i))
					sum+=366;
				else
					sum+=365;
			}
			return sum;
		}
	}
	//递归阶乘
	public static long getFactorielle(int n) {
		if(n==1) return 1;
		return getFactorielle(n-1)*n;
	}

	//斐波那契
	public static int getNFibonacci(int n) {
		if(n==1||n==2) return 1;
		return getNFibonacci(n-1)+getNFibonacci(n-2);		
	}
}
