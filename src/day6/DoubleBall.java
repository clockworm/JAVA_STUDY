package day6;
import java.util.Arrays;
import java.util.Random;
public class DoubleBall{
	public static void  main(String[] args){
		System.out.println(Arrays.toString(doubleColour_ball()));
	}
	//隨機生成双色球
	public static String[] doubleColour_ball() {
		String[] ball = new  String[33];
		String[] doubleBall = new  String[6];
		boolean[] used = new boolean[ball.length];
		Random r = new Random();
		for (int i=0;i<ball.length;i++ ) {
			if(i<9)
				ball[i] = "0"+(i+1);
			else
				ball[i] = ""+(i+1);
		}
		int i = 0;
		//拿6个红球
		while(true){
			int index = r.nextInt(ball.length);
			if(used[index])
				continue;
			else
				doubleBall[i++]=ball[index];
				used[index] = true;
				if(i==6){
					break;
				}
		}
		Arrays.sort(doubleBall); //红球排序
		//扩容并拿篮球
		doubleBall = Arrays.copyOf(doubleBall,doubleBall.length+1);  //扩容之后返回新的数组 必须接收
		doubleBall[doubleBall.length-1] = ball[r.nextInt(16)];
		return doubleBall;
	}
}