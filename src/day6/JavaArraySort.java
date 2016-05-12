package day6;
import java.util.Arrays;
import java.util.Random;
public class JavaArraySort{
	public static void  main(String[] args){
		int a[] = {110,21,3,0,40,50,704,83,62,90};
		//selectArraySort(a);
		// bubbleArraySort(a);
		// a = insertArray_Sort_ed(a,45);
		// println(Arrays.toString(a));
		insertArray_Sort(a);
		println(Arrays.toString(a));

		int array_test[] = new int[10000];
		Random r = new Random();//随机数
		for (int i = 0;i<array_test.length ;i++ ) {
			array_test[i] = r.nextInt();
		} 

		//获取到1997年的时间差
		long startTime = System.currentTimeMillis();
		Arrays.sort(array_test);
		long endTime = System.currentTimeMillis();
		println((endTime-startTime)+" ");
		println(Arrays.toString(array_test));

		//多维数组
		int manyArray[][] = {{1,2,3,4},{99,5,6,65,7}};
		//多为数组遍历1
		for (int i =0;i<manyArray.length ;i++ ) {
			System.out.print(Arrays.toString(manyArray[i])+" ");
			println("");
		}
		println("");

		//多为数组遍历2
		for (int i =0;i<manyArray.length ;i++ ) {
			for (int j=0;j<manyArray[i].length;j++ ) {
				System.out.print(manyArray[i][j]+" ");
			}
			println("");
		}
		println("");

	}

	//打印方法
	public static void print(String args) {
		System.out.print(args);
	}
	//打印换行方法
	public static void println(String args) {
		System.out.println(args);
	}

	//选择排序 a[0] 一直比到底  a[0]和a[1] a[0]和a[2] a[0]和a[3] a[0]和a[4]... 
	//最大或最小即为a[0]，第二个，第三个依次排下去
 	public static void selectArraySort(int[] arrayName) {
		for (int i=0;i<arrayName.length-1;i++) {
			for (int j=i+1;j<arrayName.length;j++) {
				if(arrayName[i]<arrayName[j]){
					int t = arrayName[i];
					arrayName[i] = arrayName[j];
					arrayName[j] = t;
				}
			}
		}
	}
	//冒泡  相邻之间一直比到底  a[0]和a[1] a[1]和a[2] a[2]和a[3] a[3]和a[4]... 
	//最大或最小即为a[a.length-1](最后一个)，然后倒数第二个，倒数第三个依次排下去
	public static void bubbleArraySort(int[] arrayName) {
		for (int i = 0;i<arrayName.length-1;i++) {
			for (int j = 0;j<arrayName.length-1-i;j++) {
				if(arrayName[j]>arrayName[j+1]){
					int t = arrayName[j];
					arrayName[j] = arrayName[j+1];
					arrayName[j+1] = t;
				}
			}
		}
	}

	//插入（已经排序数组）排序 先扩容就多一个元素为0在末尾 插入的元素从length-2开始比较
	public static int[] insertArray_Sort_ed(int[] arrayName,int value) {
		arrayName = Arrays.copyOf(arrayName,arrayName.length+1);
		int i = 0;
		for (i=arrayName.length-2;i>=0;i-- ) {
			if(value<arrayName[i]){
				arrayName[i+1] = arrayName[i];
			}else{
				System.out.println(arrayName[i]);
				break;
			}
		}
		arrayName[i+1] = value;
		return arrayName;
	}
	
	//插入排序 (乱序)
	public static void insertArray_Sort(int[] arrayName) {
		int j = 0;
		for (int i=1;i<arrayName.length;i++ ) {
			int value = arrayName[i];
			for (j=i-1;j>=0;j--) {  //当可以摞动的时候 j递减  
				if(value<arrayName[j])
					arrayName[j+1] = arrayName[j];
				else
					break;
			}
			arrayName[j+1] = value; //当摞动完了之后。value放在 无法摞动的数+1的位置
		}
	}

}