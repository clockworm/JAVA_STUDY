package Explain;

public class As {
	   public static void main(String[] args) {
		MyThread mt=new MyThread();
		mt.run();
		while(true){
		   System.out.println("99999999999999999999999999999999");
		}
	   }
	}
	class MyThread{
	    public void run(){
		while(true){
		    System.out.println("MyThread类的run()方法正在运行");
		}
	   }
	}
