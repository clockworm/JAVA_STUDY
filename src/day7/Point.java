package day7;
/*
面向对象 类
*/
class Point {
	public static void main(String[] args) {
		Points p1 = new Points(10,10);
		Points p2 = new Points(15,20);
		double d = p1.getDouble_Point(p2);
		System.out.print(d);
		Circle c1 = new Circle(p1,6);
		System.out.println("面积:"+c1.getArea()+"周长："+c1.getLength());
		//判断p2是否在园内
		System.out.println(c1.isContain(p2));
		System.out.println(c1.isContain(6,6));
		Circle c2 = new Circle(25,35,60);
		System.out.println("面积:"+c2.getArea()+"周长："+c2.getLength());
		//判断p2是否在园内
		System.out.println(c1.isContain(p1));
		System.out.println(c1.isContain(16,6));
		// System.out.println("p1: "+p1.i+"  p2: "+p2.i+"  Points: "+Points.i);
		// p1.i = 1;
		// System.out.println("p1: "+p1.i+"  p2: "+p2.i+"  Points: "+Points.i);
		// Points.i = 2;
		// System.out.println("p1: "+p1.i+"  p2: "+p2.i+"  Points: "+Points.i);

		// Points.funCtion(); //静态方法调用  类名.静态方法 不会创建对象更不会初始化
	}
}
class Circle{
	static int i;
	static{
		i=1; 
	} 
	double r;
	Points center;
	//初始化
	Circle(Points center,double r){
		this.center = center;
		this.r = r;
	}
	//初始化
	Circle(double x,double y,double r){
		this(new Points(x,y),r);
	}
	//求原面积
	double getArea(){
		return 3.14*r*r;
	}
	//周长
	double getLength(){
		return 2*3.14*r;
	}
	//判断一个点是否在园内1
	boolean isContain(Points p){
		if(center.getDouble_Point(p)<=r){
			return true;
		}else{
			return false;
		}
	}
	//判断一个点是否在园内2
	boolean isContain(double x,double y){
		return isContain(new Points(x,y));
	}

}

class Points{
	double x,y;
	// {           //初始化函数
	// 	x=1;
	// 	y=1;
	// 	System.out.println("aaaaaaaaaaaaaa");
	// }
	// static int i;
	// static{       //静态初始化最先执行 用到类的时候加载 只加载一次
	// 	i=1; 
	// 	System.out.println("bbbbbbbbbbbbbb");
	// } 
	Points(){}  //空体构造函数
	Points(double x,double y){  //构造函数
		this.x = x;
		this.y = y;
	}
	double getDistance(){
		// System.out.println("bbbbbbbbbbbbbb         "+i);
		return Math.sqrt(x*x+y*y);
	}
	double getDouble_Point(Points p){
		return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
	}
	// static void funCtion(){
	// 	System.out.println("HI");
	// 	// System.out.println(this.x); //静态方法只能访问静态成员变量
	// }
}