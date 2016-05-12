package day8;
class JavaExends{
	public static void main(String[] args) {
//		B b = new B();
		//动态绑定  父类指向子类的实例  这个时候父类调用的方法即是子类重写父类的方法
    	// Teacher teacher = new JavaTeacher("李四");
    	Teacher java = new JavaTeacher("李四"); //先执行子类中这个重写的方法。期间并没有初始化子类的数据所以打印是null 
    	java.print();//打印子类初始化后的方法
    	Rectangle r1 = new Rectangle(); 
    	// c1.draw();
    	// r1.draw();
    	// Shape c2 = new Circle();
    	// Shape r2 = new Rectangle();
    	// c2.draw();
    	// r2.draw();
    	Persons p = new Persons();
    	p.drawShape(r1);
    	p.getCircledraw().draw();
    }
}
class A{
	static{
		System.out.println("父类静态初始化块");
	}
	{
		System.out.println("父类初始化");
	}
	A(){
		System.out.println("父类构造函数");
	}
}
class B extends A{
	static{
		System.out.println("子类静态初始化块");
	}
	{
		System.out.println("子类初始化");
	}
	B(){ 
		System.out.println("子类构造函数");
	}
}

//图形
class Shape{
	void draw(){
		System.out.println("画图...");
	}	
}
//圆
class Circle extends Shape{
	void draw(){
		System.out.println("画圆...");
	}	
}
//长方形
class Rectangle extends Shape{
	void draw(){
		System.out.println("画长方形...");
	}
}
class Persons{
	void drawShape(Shape s){
		s.draw();
	}
	Shape getCircledraw(){
		return new Circle();
	}
}
//动态绑定  父类指向子类的实例  这个时候父类调用的方法即是子类重写父类的方法
class Teacher{
	String name;
	{
		print(); 
	}
	Teacher(String name){
		this.name = name;
	}
	void print(){
		System.out.println("teaching....");
	}
}
class JavaTeacher extends Teacher{
	JavaTeacher(String name){
		super(name);  //调用父类的构造函数
	}
	void print(){
		System.out.println("Java..."+name);
	}
}

