package day6;
/**
假设有一个int类型的数组，数组包含10000个可重复的元素
现不使用排序的方式,用最快的速度找到第1000个大的数字
**/
import java.util.Arrays;
import java.util.Random;
public class JobArray{
	public static void  main(String[] args){
		//创建一个随机万级数据数组
		int[] num = new int[10000];
		Random r = new Random();
		for (int i = 0;i<10000;i++ ) {
			num[i] = (r.nextInt(10000));
		}
		int[][] num_count = theSame_count(num);//统计相同数 数组的第一个位置放数第二个位置放数量{{数，数量},{数，数量},{}....}
		int min = findArray_Min(num_count); //找到多维数组中最小的值
		min = decreasingMin(num_count,min,decreasingMin_count(num_count,min)); //递归实现多维数组找到第二小的值，第三小的值....直到总数量1000的时候返回数据
		System.out.println(min);
	}	

	//统计相同数
	public static int[][] theSame_count(int[] arrysName) {
		int[][] max_array = new int[10000][2];
		boolean[] finded = new boolean[arrysName.length];
		int sum = 0;
		int t = 0;
		for (int i = 0;i<arrysName.length;i++ ) {
			if (finded[i]) {//被找过了
				continue;
			}
			max_array[t][0] = arrysName[i];
			sum = 1;
			for (int j = i+1;j<arrysName.length;j++) {
				if (arrysName[i] == arrysName[j]) {	
					if(finded[j]==false){
						finded[j]=true;
						sum+=1;
					}
				}
			}
			max_array[t][1] = sum;
			t++;
		}
		max_array = Arrays.copyOf(max_array,t);
		return max_array;
	}

	//找出最小
	public static int findArray_Min(int[][] arrysName) {
		int min = arrysName[0][0];
		for (int i=1;i<arrysName.length;i++ ) {
			// System.out.println(arrysName[i][0]);
			if(arrysName[i][0]<min)
				min = arrysName[i][0];
		}
		return min;
	}

	//找出第二小 依次类推
	public static int decreasingMin(int[][] arrysName,int min,int t) {
		int count = t;
		int min_x = 10000;
		for (int i=1;i<arrysName.length;i++ ) {
			if(arrysName[i][0] > min){
				if(arrysName[i][0]<min_x)
					min_x = arrysName[i][0];
			}
		}
		count += decreasingMin_count(arrysName,min_x);
		if(count<=1000)
			return decreasingMin(arrysName,min_x,count); //返回自己
		return min_x; //递归先进后出。我不知道怎么返回min_x最后的值
	}

	//找出第二小的数量个数
	public static int decreasingMin_count(int[][] arrysName,int min) {
		int count = 0;
		for (int i=0;i<arrysName.length;i++ ) {
			if(arrysName[i][0] == min){
				count = arrysName[i][1];
			}
		}
		return count;
	}
}