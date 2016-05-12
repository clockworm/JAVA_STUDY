package day12.Shop;

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
	public Buy buy = new Buy(); //购物行为

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
		if (buy.amount[0] == 0) {
			System.out.println(clientName + "  没有购买任何商品");
			return;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(clientName + "购买的商品:");
		for (int i = 0; i < buy.count; i++) {
			Commodity co = (Commodity) buy.myLists.getObjects()[i];
			sb.append(buy.amount[i] + "个" + co.getCommodityName() + " ,");
		}
		System.out.println(sb.append("总价格是：" + buy.totalPrice()).toString());
	}
}
