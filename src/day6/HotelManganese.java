package day6;
import java.util.Arrays;
import java.util.Scanner;
public class HotelManganese{
	public static void  main(String[] args){
		//创建房间数
		String[][] hotelCount = new String[12][10];
		for (int i=0;i<12;i++) {
			for (int j=0;j<10;j++ ) {
				if (i<9) {
					hotelCount[i][j] = "0"+((i+1)*100+j+1);
				}else{
					hotelCount[i][j] = ((i+1)*100+j+1)+"";
				}
			}
		}
		//房间状态
		String[][] state = new String[12][10];
		initRoom(state);
		println("欢迎光临希尔顿大酒店");
		println("查询请按search,入住请按in,退房请按out!");
		String str = "";
		Scanner s = new Scanner(System.in);
		while(true){
			str = s.next();
			if("search".equals(str))
				search(hotelCount,state);
			else if("in".equals(str)){
				println("请输入入住房间号:");
				checkIn(hotelCount,state,s.nextInt());
			}else if("out".equals(str)){
				println("请输入退房房间号:");
				checkOut(hotelCount,state,s.nextInt());
			}else if("quit".equals(str)){
				println("欢迎下次光临！");
				// break;
				return;
			}
		}
	}
	//查看房间
	public static void search(String[][] hotelCount,String[][] state) {
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

	//初始化房间
	public static void initRoom(String[][] homes) {
		for (int i=0;i<12;i++) {
			for (int j=0;j<10;j++ ) {
				homes[i][j] = "Emtpy";
			}
		}
	}

	//入住房间
	public static void checkIn(String[][] hotelCount,String[][] state,int number) {
		int floor = number/100;
		int no = number%100;
		if (floor>12||floor<1||no>10||no<1) {
			println("输入的房间号码有误");
			return;
		}
		if(state[floor-1][no-1].equals("Emtpy")){
			print("请输入你的名字:");
			Scanner s = new Scanner(System.in);
			String name = s.next();
			state[floor-1][no-1]=name;
			print("订房成功,欢迎入住！");
		}else{
			print("该房间已入住！");
		}
		
		println("");
	}

	//退房间
	public static void checkOut(String[][] hotelCount,String[][] state,int number) {
		int floor = number/100;
		int no = number%100;
		if (floor>12||floor<1||no>10||no<1) {
			println("输入的房间号码有误");
		}else{
			if(!hotelCount[floor-1][no-1].equals("Emtpy")){
				if(state[floor-1][no-1]!="Emtpy"){
					print("退房成功,欢迎下次光临！");
					state[floor-1][no-1]="Emtpy";
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