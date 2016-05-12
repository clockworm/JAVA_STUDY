package day5;
/**
作业1. 验证哥德巴赫猜想：任何一个大于6 的偶数， 都能分解成两个质数的和。
要求输入一 个整数，输出这个数能被分解成哪两个质数的和。
eg : 14 14=3+11 14=7+7 

作业2. 如果整数A 的全部因子（包括1，不包括A 本身） 之和等于B，
且整数B 的全部因子（包括1，不包括B 本身）之和等于A，
则称整数A\B 是一对亲密数。 求3000 以内的全部亲密数
**/
class Job {
	public static void main(String[] args) {

		//作业1：
		getGoldbach(20);

		//作业2：
		for (int i =1;i<3000;i++) {
			int b = printSons(i);
			int a = printSons(b);
			if (a==i)
				System.out.println(i+"和"+b+"是亲密数");
		}
	}

	
	//是否质数
	public static boolean isPrimeNumber(int a) {
		for (int i=2;i<(a/2+1);i++) {
			if(a%i==0)
				return false;
		}
		return true;
	}
	//哥德巴赫猜想
	public static void  getGoldbach(int a) {
		for (int i=1;i<(a/2+1);i++) {
			if(isPrimeNumber(i)){
				if(isPrimeNumber(a-i)){
					System.out.println(a+"="+i+"+"+(a-i));
				}
			}
		}
	}
	//求因子和方法
	public static int printSons(int a) {
		int sum = 0;
		for (int i=1;i<=(a/2+1);i++) {
			if(a%i==0){
				sum+=i;
			}
		}
		return sum;
	}

}