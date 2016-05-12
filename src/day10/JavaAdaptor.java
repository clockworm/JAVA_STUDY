/*
 * 适配器设计思想
 * **/
package day10;

public class JavaAdaptor {

}

interface Cards {
	void a();

	void b();

	void c();

	void d();

	void e();

	void f();
}

abstract class soundCardAdaptor implements Cards {

	@Override
	public void a() {
		// TODO Auto-generated method stub
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
	}

	@Override
	public void c() {
		// TODO Auto-generated method stub
	}

	@Override
	public void d() {
		// TODO Auto-generated method stub
	}

	@Override
	public void e() {
		// TODO Auto-generated method stub
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
	}

}

class soundCards extends soundCardAdaptor {
	public void e() {
		System.out.println("我就只用这个，其他的不要到我这里来");
	}
}
