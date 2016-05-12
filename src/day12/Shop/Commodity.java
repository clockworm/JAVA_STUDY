package day12.Shop;

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
	public static MyArrayList myList = new MyArrayList();//货架

	public Commodity() {
	}

	public Commodity(int commodityId, String commodityName, double commodityPrice) {
		if (!isExist(commodityId))
			return;
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		if (!isExist(commodityId))
			return;
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

	// 这个商品是否存在
	public boolean isExist(int commodityId) {
		if (myList.isContain(commodityId)) {
			System.out.println("该商品已经上架");
			return false;
		}
		myList.add(commodityId);
		return true;
	}
}
