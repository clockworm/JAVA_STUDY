package day6;
/*
数组是引用类型 使用内存中的 堆内存（有垃圾机制自动回收需要JVM回收）  变量使用的是栈内存。
*/
import java.util.Arrays;

public class JavaArray{
	public static void  main(String[] args){
		// int[] scores;//声明
		// scores = new int[]{2,3,4,5,6}; //初始化

		// int[] scores = new int[6];//固定长度并初始化 默认为0
		// int[] scores = {1,2,3,4,5,6,7}; //声明且初始化
		int scores[] = {1,8,84,84,312,231,123};

		System.out.println(scores[0]);
		System.out.println(scores[3]);
		System.out.println(scores.length);
		for (int i=0;i<scores.length ;i++ ) {
			System.out.print(scores[i]+" ");
		}
		System.out.println();
		//数组是引用类型  a,b是指向同一个数组 只是变换了地址
		int a[] = {1,2,3,4};
		int b[] = a;
		for (int i =0;i<b.length ;i++ ) {
			System.out.print(b[i]+"  ");
			b[i]++;
		}
		System.out.println();
		for (int i=0;i<a.length ;i++ ) {
			System.out.print(a[i]+"  ");
		}
		System.out.println();

		b[3] = 100;
		System.out.println(a[3]);

		//最大值 最小值 和 平均值
		int array_a[] = {1,3,4,6,6,5,56,8};
		int sum = 0,max = array_a[0],min = array_a[0];
		float avg = 0;
		for (int i=0;i<array_a.length ;i++ ) {
			sum += array_a[i];
			if(max<array_a[i])
				max = array_a[i];
			if(min>array_a[i])
				min = array_a[i];
		}
		avg = (float)sum/array_a.length;
		System.out.println("最大值:"+max+",最小值:"+min+",平均值："+avg+"，和"+sum); 
		System.out.println();

		//数组倒置
		int array_b[] = {1,2,3,4,5,6,7,8,9};
		for (int i=0;i<array_b.length/2;i++ ) {
			int t = array_b[i];
			array_b[i] = array_b[array_b.length-1-i];
			array_b[array_b.length-1-i] = t; 	
		} 
		for (int i=0;i<array_b.length;i++ ) {
			System.out.print(array_b[i]+" ");
		}
		System.out.println();

		//调用倒置方法
		int array_c[] = {1,2,3,4,5,6,7,8,9};
		reverseArray(array_c);
		for (int i=0;i<array_c.length;i++ ) {
			System.out.print(array_c[i]+" ");
		}
		System.out.println();
		//求一个数的因子并且放入数组
		int sonsArray[] = gettSonsArray(10);
		printArray(sonsArray);
		println("");

		int array_a1[] = {13,2,3,45,5656,54,31278,77,7,76,554,34};
		int array_a2[] = {13,1,34,54,456,78,89,12,312789,45};
		println(getSameArray_MAX_VALUE(array_a1,array_a2)+"");

		gettwoNumber_MAX_commonMeasure_MIN_commonMultiple(72,60);
		println("");

		//数组插入 第2个位置插入99
		int array_a_2[] = {1,2,3,3,4,5};
		int array_b_2[] = insertArray_VALUE(5,909,array_a_2);
		printArray(array_b_2);
		printArray(array_a_2);

		//数组拷贝  源数组 源数组开始位置  指定数组 开始位置  数组长度
		a = new int[array_b.length];
		//System.arraycopy(array_b,0,a,0,a.length);
		System.arraycopy(array_b,0,a,0,a.length);
		printArray(a);
		//数组拷贝 扩容
		a = Arrays.copyOf(a,2*a.length);
		printArray(a);
		println(Arrays.toString(a));
		println(Arrays.toString(insertArray_VALUE(1,98,array_b)));

		yanghuiTriangle(8);

		//比较两个数组是否相同
		String[] str_a = {"1","2","4","你"};
		String[] str_b =  {"1","2","4","你"};
		for(String str_b1:str_b){
			print(str_b1);
		}
		println(Arrays.equals(str_a,str_b)+"");
 	}


	//遍历数组
	public static void printArray(int[] a) {
		// for (int i=0;i<a.length;i++ ) {
		// 	System.out.print(a[i]+" ");
		// }
		// System.out.println();
		for (int i:a) {
			print(i+"");
		}
		println("");
	}

	//数组倒置方法 没有返回值 因为引用数据类型
	public static void reverseArray(int[] a) {
		for (int i=0;i<a.length/2;i++ ) {
			int t = a[i];
			a[i] = a[a.length-i-1];
			a[a.length-i-1] = t;
		}
	}

	//一个数的因子个数(包括自身)，并返回
	public static int getSonsCount(int a) {
		int count = 0;
		for (int i=1;i<=(a/2+1);i++ ) {
			if(a%i==0)
				count+=1;
		}
		return count + 1;
	}

	//求一个数的因子(包含自身) 并放入数组
	public static int[] gettSonsArray(int a) {
		int array_a[] = new int[getSonsCount(a)];
		int j = 0;
		for (int i=1;i<=(a/2+1);i++ ) {
			if(a%i==0){
				array_a[j] = i;
				j++;
			}
		}
		array_a[j] = a;
		return array_a;
	}

	//打印方法
	public static void print(String args) {
		System.out.print(args);
	}
	//打印换行方法
	public static void println(String args) {
		System.out.println(args);
	}

	//两个数组相同且最大的数
	public static int getSameArray_MAX_VALUE(int[] a,int[] b) {
		int max = 0;
		for (int i=0;i<a.length;i++ ) {
			for (int j=0;j<b.length;j++) {
				if(a[i]==b[j]&&max<b[j]){
					max = b[j];
					break;
				}
			}
		}
		return max;
	}
	//两个数的最大公约数 最小公倍数
	public static void gettwoNumber_MAX_commonMeasure_MIN_commonMultiple(int a,int b) {
		int array_a[] = gettSonsArray(a);
		printArray(array_a);
		int array_b[] = gettSonsArray(b);
		printArray(array_b);
		int max = getSameArray_MAX_VALUE(array_a,array_b);
		int min = a*b/max;
		println(a+","+b+"最大公约数："+max+"最小公倍数："+min);
	}

	//数组插入方法 只能插入一个 参数     位置 值 数组名
	public static int[] insertArray_VALUE(int a,int b,int[] arrayName) {
		if(a<1||a>arrayName.length) return arrayName;
		arrayName = Arrays.copyOf(arrayName,arrayName.length+1);
		
		for (int i=arrayName.length-1;i>a-1;i--) {
			arrayName[i] = arrayName[i-1];
		}
		arrayName[a-1] = b;
		return arrayName;
	}
	// public static int[] insertArray_VALUE(int a,int b,int[] arrayName) {
	// 	int array_b_2[] = new int[arrayName.length+1];

	// 	for (int i=0;i<arrayName.length;i++ ) {
	// 		array_b_2[i] = arrayName[i];
	// 	}
	// 	for (int i=array_b_2.length-1;i>a-1;i--) {
	// 		array_b_2[i] = array_b_2[i-1];
	// 	}
	// 	array_b_2[a-1] = b;
	// 	return array_b_2;
	// }

	//杨辉三角
	public static void yanghuiTriangle(int n) {
		int[][] arrayName = new int[n][n];
		for (int i =0 ;i<arrayName.length ;i++ ) {
			for (int j = 0;j<arrayName[i].length;j++ ) {
				arrayName[i][j] = 1;
			}
		}
		
		for (int i=2;i<arrayName.length;i++ ) { 
			for (int j = 1;j<i;j++) {   
				arrayName[i][j] = arrayName[i-1][j]+arrayName[i-1][j-1];
			}
		}
		for (int i = 0;i<arrayName.length;i++ ) {
			for (int j = 0;j<=i;j++ ) {
				System.out.print(arrayName[i][j]+" ");
			}
			println("");
		}
	}

}