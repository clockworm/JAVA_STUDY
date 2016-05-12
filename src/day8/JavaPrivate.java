package day8;
public class JavaPrivate{
	public static void  main(String[] args){
		// Person p = new Person();
		// p.setName("张三");
		// System.out.println(p.getName());
		Person p = Person.getPerson();
		p.print();
	}
}
class Person{
	private String name; //name只能在内的类的内部访问 
	private Person(){
		// print();
	}
	public static Person getPerson(){
		return new Person();
	}
	void setName(String name){
		this.name = name;
	}
	String getName(){
		return this.name;
	}
	public void print(){
		System.out.println("可以访问我");
	}
}
