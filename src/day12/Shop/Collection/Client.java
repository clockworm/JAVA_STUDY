package day12.Shop.Collection;

/**
 * 客户类
 * 
 * @author Administrator
 *
 */
public class Client {
	private String clientName; // 名字
	private String phoneNumber; // 电话号码
	private String address;// 地址
	public Buy buy = new Buy(); // 购物行为

	public Client() {
	};

	public Client(String clientName, String phoneNumber, String address) {
		this.clientName = clientName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// 购物信息
	public void getBuyMessage() {
		if (buy.buybus.size() == 0) {
			System.out.println(clientName + "  没有购买任何商品");
			return;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(clientName + "购买的商品:\n");
		getCommodityMessage(sb);
	}
	//购物车信息  和 消费总价
	public void getCommodityMessage(StringBuffer sb) {
		for (Commodity cdys : buy.buybus.keySet()) {
			sb.append("   " + cdys.getCommodityName()).append("数量是:").append(buy.buybus.get(cdys)).append("  单价是:")
					.append(cdys.getCommodityPrice()).append("\n");
		}
		System.out.println(sb.append("-----总价格是：" + this.buy.totalPrice())+"元-----");
	}
	
}
