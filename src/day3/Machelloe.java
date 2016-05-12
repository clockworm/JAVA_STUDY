package day3;
//if else if判断
public class Machelloe{

	public static void main(String[] args) {
		int a1 = 6; //商品
		int b = 51; //投币金额
		int c = b-a1;
		if(b==100)
			System.out.println("投入为"+b+"找你零钱"+c);
		else if (b==50) 
			System.out.println("投入为"+b+"找你零钱"+c);
		else if (b==20) 
			System.out.println("投入为"+b+"找你零钱"+c);
		else if (b==10) 
			System.out.println("投入为"+b+"找你零钱"+c);
		else if (b==1) 
			System.out.println("余额不足，请继续投币");
		else
			System.out.println("不能识别，请重新投入人民币");
		long tel = 18523916072l;
		if (tel>9999999999l&&tel<20000000000l) 
			System.out.println("是手机号码");
		else
			System.out.println("不是手机号码");
		
		int a = 18;
		if(a<18)
			System.out.println("此角色还未开放，无法选择！");
		else if(a>22)
			System.out.println("大师兄");
		else if(a>20)
			System.out.println("小师弟");
		else
			System.out.println("小师妹");
	}
}
