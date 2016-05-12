package day4;
//While循环
public class JavaWhlie{
	public static void  main(String[] args){

		//1到100的和
		int i = 0;
		int sum = 0;
		while (i<101) {
			sum+=i;
			i++;
		}
		System.out.println(sum);

		//整数各个位求和  123----1+2+3
		int a = 153;
		sum = 0;
		while(a!=0){
			sum += (a%10)*(a%10)*(a%10);
			a = a/10;
		}
		System.out.println(sum);

		//数字倒置
		a = 1957300;
		sum = 0;
		while(a!=0){
			sum = sum*10+a%10; 
			a = a/10; 
		}
		System.out.println(sum);

		i = 3;
        while(i<101){
            if(i%10==3)
                System.out.println(i);
            i = i + 1;
        }
        sum = 0;i = 1;

    	do{
    		sum+=i;
    		i++;
    	}while(i<=100);
    	System.out.println(sum);



    	int t = 0;
    	
    	for (i=10;i<1000;i++) {
    		t = i;
    		while(t!=0){
    			sum += t%10;
    			t = t/10;
    		}
    		if (sum==5) {
    				System.out.println(i+"  ");
    			}
    		sum = 0;
    	}
	}
}