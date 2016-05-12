package day3;
//if else if判断
public class OperatorElseif{

	public static void main(String[] args) {
		int score = 95;
		if (score>100 || score<0) 
			System.out.println("成绩错误");
		else
			if (score>=90) 
				System.out.println("优秀");
			else if (score>=80) 
				System.out.println("良好");
			else if (score>=70) 
				System.out.println("一般");
			else if (score>=60) 
				System.out.println("及格");
			else
				System.out.println("不及格");
	}
}
