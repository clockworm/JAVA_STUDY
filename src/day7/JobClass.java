package day7;
/*
使用面向对象的编程思想将我赢职场阶段性项目案例(一)的我赢酒店管理系统进行项目重构，并将项目进行适当扩展
*/
import java.util.Scanner;

class JobClass{
	public static void main(String[] args) {
		//访问酒店
		Person p1 = new Person();
		p1.name = "lisi";
		Person p2 = new Person("zhaoliu");
		Person[] persons = new Person[]{p1,p2};
		//访问酒店
		Hotel zhaoliu = new Hotel(persons[1]); 
		Hotel lisi = new Hotel(persons[0]);
		Hotel wang = new Hotel("wangwu");
	}
}
//酒店
class Hotel{
	static String[][] hotelcount;
	static String[][] state;
	Person person;
	//初始化
	static{
		hotelcount = new String[12][10];
		state = new String[12][10];
		for (int i=0;i<12;i++) {
			for (int j=0;j<10;j++ ) {
				if (i<9) {
					hotelcount[i][j] = "0"+((i+1)*100+j+1);
				}else{
					hotelcount[i][j] = ((i+1)*100+j+1)+"";
				}
				state[i][j] = "EMPTY";
			}
		}
	}
	//访问酒店
	Hotel(Person person){
		this.person = person;
		println("欢迎"+this.person.name+"光临希尔顿大酒店");
		println("查询请按search,入住请按in,退房请按out!");
		String str = "";
		Scanner s = new Scanner(System.in);
		while(true){
			str = s.next();
			if("search".equals(str))
				search(hotelcount,state);
			else if("in".equals(str)){
				println("请输入入住房间号:");
				checkIn(hotelcount,state,s.nextInt());
			}else if("out".equals(str)){
				println("请输入退房房间号:");
				checkOut(hotelcount,state,s.nextInt());
			}else if("quit".equals(str)){
				println("欢迎下次光临！");
				break;
			}
		}
	}
	Hotel(String name){
		this(new Person(name));
	}
	//查看房间
	private void search(String[][] hotelCount,String[][] state) {
		for (int i=0;i<hotelCount.length;i++) {
			for (int j=0;j<hotelCount[i].length;j++ ) {
				print("\t"+hotelCount[i][j]);
			}
			println("");
			for (int k=0;k<hotelCount[i].length;k++) {
				print("\t"+state[i][k]);
			}
			println("");
		}
	}
	
	//入住房间
	private void checkIn(String[][] hotelCount,String[][] state,int number) {
		int floor = number/100;
		int no = number%100;
		if (floor>12||floor<1||no>10||no<1) {
			println(person.name+"先生/女士输入的房间号码有误");
			return;
		}
		if(state[floor-1][no-1].equals("EMPTY")){
			// print("请输入你的名字:");
			// Scanner s = new Scanner(System.in);
			// String name = s.next();
			state[floor-1][no-1]=person.name;
			print("订房成功,欢迎入住！");
		}else{
			print("该房间已入住！");
		}
		println("");
	}
	//退房间
	private void checkOut(String[][] hotelCount,String[][] state,int number) {
		int floor = number/100;
		int no = number%100;
		if (floor>12||floor<1||no>10||no<1) {
			println("输入的房间号码有误");
		}else{
			if(!hotelCount[floor-1][no-1].equals("EMPTY")){
				if(state[floor-1][no-1]!="EMPTY"){
					if(state[floor-1][no-1]==person.name){
						print("退房成功,欢迎下次光临！");
						state[floor-1][no-1]="EMPTY";
					}else{
						println("你不是该房间主人,退房失败！");
					}
				}else{
					print("该房间还未入住！");
				}
			}
			println("");
		}
	}
	public static void print(String args) {
		System.out.print(args);
	}
	public static void println(String args) {
		System.out.println(args);
	}
}
//访客
class Person{
	String name;
	Person(String name){
		this.name = name;
	}
	Person(){
	}
}




















