package day12.Shop.Collection;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 購買行為類
 * 
 * @author Administrator
 *
 */
public class Buy {
	//方便对遍历输出排序 單價排序 單價相同 商品名字排序
	public TreeMap<Commodity, Integer> buybus = new TreeMap<Commodity, Integer>(new Comparator<Commodity>() {
		@Override
		public int compare(Commodity o1, Commodity o2) {
			if((int) (o2.getCommodityPrice() * 100) != (int) (o1.getCommodityPrice() * 100))
				return (int) (o2.getCommodityPrice() * 100) - (int) (o1.getCommodityPrice() * 100);
			return o2.getCommodityName().compareTo(o1.getCommodityName());
		}
	});

	// 购买商品  重复购买累加
	public void shopping(Commodity cdy, int amount) {
		if (cdy == null) {
			System.out.println("商品不存在,购买失败");
			return;
		}
		if (buybus.containsKey(cdy))
			buybus.put(cdy, buybus.get(cdy) + amount);
		else
			buybus.put(cdy, amount);
	}

	// 物品总价格
	public double totalPrice() {
		double eachPrice = 0;
		for (Commodity cdy : this.buybus.keySet()) {
			 eachPrice += (cdy.getCommodityPrice() * buybus.get(cdy));
		}
		return eachPrice;
	}
}
