//* 模拟网上购物系统，实现对货物的管理，及用户购买后的价格结算等功能(可模仿淘宝、京东等业务功能)
//实现集合的操作
package day12.Shop.Collection;

public class Test {

	public static void main(String[] args) {
		Client clt1 = new Client("张三", "13088888888", "成都北");
		Client clt2 = new Client("李四", "13022222222", "成都西");
		Client clt3 = new Client("赵六", "13011111111", "成都南");
		Commodity cdy1 = new Commodity(198001, "电风扇", 1.5);
		Commodity cdy2 = new Commodity(198002, "吹风机", 2);
		Commodity cdy3 = new Commodity(198003, "路由器", 2);
		Commodity cdy4 = new Commodity(298004, "空调", 1.5);
		Commodity cdy5 = new Commodity(298005, "冰箱", 1.5);
		clt1.buy.shopping(cdy1, 3);
		clt1.buy.shopping(cdy2, 2);
		clt1.buy.shopping(cdy3, 3);
		clt1.buy.shopping(cdy4, 2);
		clt1.buy.shopping(cdy5, 1);
		clt1.buy.shopping(cdy5, 1);
		clt1.getBuyMessage();

		clt2.buy.shopping(cdy1, 1);
		clt2.buy.shopping(cdy3, 1);
		clt2.buy.shopping(cdy5, 1);
		clt2.getBuyMessage();

		clt3.getBuyMessage();
	}

}
