package day2;
// 变量 
// 二进制
public class Variable{
	public static void  main(String[] args){
		/*1个字节8位  范围-2的7次方到2的7次方-1*/
		byte b = 10;
		/*十进制转二进制*/
		int a = 10;
		System.out.println(Integer.toBinaryString(a));
		long c = 100000000000000L;
		double d  = 10.5;
		/*单精度必须加上f*/
		float f = 10.5f;
		/*浮点数不能做精确计算，会自动四舍五入*/
		double money = 3.0;
		//问题如下
		System.out.println(money-2.9);
		//char 16位无符号整数0到2的15次方-1 表示正数（中文2字节 单引号括起来）
		char a1 = '中';
		char b1 = '\u4e2d';//unicode表示
		System.out.println(a1);
		System.out.println(b1);
		//数字转译字符
		char c1 = 97;
		System.out.println(c1);
		//转义字符
		char e = '\n';//换行
		// A = 65  B = 66
		char f1 = 'A'+1;
		System.out.println(f1);
		//数字： '0' 48; '1' 49 ...
		//大写 ：'A' 65 ;'B' 66 ...
		//小写  'a' 97 ; 'b' 98 ...
		boolean bo = false;
		System.out.println(bo);
		//类型转化
		// 大范围转小范围 强制转化
		// 小范围转大范围  默认转化
		//小到大 byte short int long float double
		int a3 = 10;
		//默认转化
		double d3 = a3;
		float f3 = a3;
		//强制转化
		int a4 = (int)f3;
		char a5 = 98;
		char b5 = '国';
		System.out.println(a5);
		System.out.println(b5);
	}
}