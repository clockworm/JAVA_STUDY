package day2;
//控制台输入  导包
import java.util.Scanner;

public class ScannerDemo{
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个数字:");
		int a = s.nextInt();	
		System.out.println("你输入的数字是"+a);
	}
	
}