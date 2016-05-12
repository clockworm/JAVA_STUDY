//* 模拟网上购物系统，实现对货物的管理，及用户购买后的价格结算等功能(可模仿淘宝、京东等业务功能)
package day12.Shop;

public class Test {

	public static void main(String[] args) {
		Client clt1 = new Client("张三", "13088888888", "成都北");
		Client clt2 = new Client("李四", "13022222222", "成都西");
		Commodity cdy1 = new Commodity(1, "电风扇", 98.8);
		Commodity cdy2 = new Commodity(2, "吹风机", 126);
		// Commodity cdy3 = new Commodity(1, "电风扇", 98.8);
		clt1.buy.shopping(cdy1, 2);
		clt1.buy.shopping(cdy2, 1);
		clt1.getBuyMessage();
		clt2.buy.shopping(cdy2, 1);
		clt2.getBuyMessage();
	}

}
