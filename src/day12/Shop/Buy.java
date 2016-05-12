package day12.Shop;

/**
 * 購買行為類
 * 
 * @author Administrator
 *
 */
public class Buy {
	public MyArrayList myLists = new MyArrayList(); // 购物车
	public int count;// 购买商品類型数量统计
	public int[] amount = new int[100];// 购买单个商品類型数量统计

	// 购买商品
	public void shopping(Commodity cdy, int amount) {
		if (cdy.getCommodityName() == null) {
			System.out.println("商品不存在,购买失败");
			return;
		} else {
			if (myLists.add(cdy) == 1) {
				this.amount[count] = amount;
				this.count++;
			} else
				System.out.println("每个商品仅限抢购一次,数量有限");
		}
	}

	// 单个类物品总价格
	public double totalPrice() {
		double eachPrice = 0;
		for (int i = 0; i < count; i++) {
			Commodity cdy = (Commodity) myLists.getObjects()[i];
			eachPrice += cdy.getCommodityPrice() * this.amount[i];
		}
		return eachPrice;
	}
}
