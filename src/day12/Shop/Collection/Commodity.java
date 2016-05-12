package day12.Shop.Collection;

import java.util.TreeSet;

/**
 * 商品类
 * 
 * @author Administrator
 *
 */
public class Commodity {
	private int commodityId; // 商品编号
	private String commodityName;// 商品名称
	private double commodityPrice;// 商品价格
	public static TreeSet<Integer> List = new TreeSet<Integer>();// 货架 上架商品唯一性

	public Commodity() {
	}

	public Commodity(int commodityId, String commodityName, double commodityPrice) {
		if (!List.contains(commodityId)) {
			this.commodityId = commodityId;
			this.commodityName = commodityName;
			this.commodityPrice = commodityPrice;
			putaway(commodityId);
		} else {
			System.out.println("商品編號:" + commodityId + "已经上架");
		}

	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	// 上架商品唯一性
	public boolean putaway(int commodityId) {
		return List.add(commodityId);
	}

	@Override
	public String toString() {
		return "Commodity [commodityId=" + commodityId + ", commodityName=" + commodityName + ", commodityPrice="
				+ commodityPrice + "]";
	}

}
