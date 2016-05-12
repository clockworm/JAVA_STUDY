package day11;

public class JavaClassLocalInner {
	public static void main(String[] args) {
		Person p = new Person();
		p.getCanfly().fly();// 实现接口
		p.getOneShape().draw(); // 重写
		p.getOneShape().canDo(); // 继承父类的方法

		A a = new A(); // 匿名成员内部类使用
		a.getBs().draw();
		a.getBs().canDo(); // 继承父类的方法
	}
}

class Person {
	public Shape getOneShape() {
		class CircleShape extends Shape { // 继承抽象类 的成员局部类
			@Override
			public void draw() {
				System.out.println("画圆ING。。。");
			}
		}
		return new CircleShape();
	}

	public Canfly getCanfly() { // 返回实现接口类的实例对象
		class Birds implements Canfly { // 这个类声明在方法内部。只在方法内部有效
			@Override
			public void fly() {
				System.out.println("我能飞");
			}
		}
		return new Birds();
	}
}

interface Canfly { // 能飞的接口
	void fly();
}

abstract class Shape { // 抽象类
	public abstract void draw();

	public void canDo() {
		System.out.println("我能绘制图形..");
	}
}

class A {
	public Shape getBs() {
		return new Shape() { // 匿名成员内部类
			public void draw() {
				System.out.println("我也能作。无名内部类");
			}
		}; // return xx; 所以有分号
	}
}
