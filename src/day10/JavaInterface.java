/** 
 * 接口跟继承差不多。
*只是声明方式不一样，接口声明方式是interface+类名 内部只有方法声明没有具体实现
*接口内的属性变量都是默认为public static final 声明的变量
*實現接口的類  必須implements关键字+接口类
*引用方式：接口类  指向  实现接口的类做实例化(实例化的就是实现接口的类)
**/
package day10;

public class JavaInterface {
	public static void main(String[] args) {
		Bird b = new Bird();
		b.fly();
		System.out.println(b.i);
		Canfly crow = new Crow();
		crow.fly();
		Person p1 = new Person();
		p1.isFly(crow);
		p1.getFly().fly();

		// 多个接口实现
		SoundCard s = new SoundCard();
		s.work();
		s.playSound();
		Card c = new SoundCard();
		c.work();
		// c..playSound(); //错误的 只能使用该接口的功能
		PlayMp3 p = new SoundCard();
		// p.work(); ////错误的 只能使用该接口的功能
		p.playSound();
	}
}

interface Canfly {
	// public abstract void fly();
	// int i = 1; //默认为public static final
	public static final int i = 1;
	void fly();
}

class Bird implements Canfly {

	@Override
	public void fly() {
		System.out.println("我是一只小小小小鸟，翱翔");
	}
}

class Crow implements Canfly {

	@Override
	public void fly() {
		System.out.println("乌鸦，夜飞行");
	}
}

class Person {

	void isFly(Canfly c) {
		c.fly();
	}

	Canfly getFly() {
		return new Bird();
	}
}

interface Card {
	void work();
}

interface PlayMp3 {
	void playSound();
}

interface Mp4 extends Card, PlayMp3 { // 接口可以多个继承
	void display();
}

// 实现多个接口的功能
class Mp5 extends SoundCard implements Mp4 {

	@Override
	public void work() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playSound() {
		// TODO Auto-generated method stub

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}

class SoundCard implements Card, PlayMp3 {

	@Override
	public void work() {
		System.out.println("发出声音");
	}

	@Override
	public void playSound() {
		System.out.println("播放音乐");
	}
}