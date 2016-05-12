package day12.Movie.Version2;

public class Client {
	private String clientName; // 客户名字
	private MyArrayList list = new MyArrayList();// 可能多次租赁
	private Rent rent; // 每个租赁必须都是唯一

	public Client() {
	}

	public Client(String clientName) {
		this.setClientName(clientName);
	}

	public MyArrayList getList() {
		return list;
	}

	public void setList(MyArrayList list) {
		this.list = list;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@SuppressWarnings("static-access")
	public void addRent(Rent re) {
		if (rent.list.add(re) == 0) {
			System.out.println("已经被租赁");
		} else {
			this.getList().add(re);
		}
	}

	// 打印积分和影片信息 和总价格
	public void printMessage() {
		double totalPrice = 0; // 总价格
		double result = 0;// 每个影片价格
		int fre = 0; // 积分
		for (int i = 0; i < getList().getIndex(); i++) {
			Rent r = (Rent) getList().getObjects()[i];
			switch (r.getMovie().getMovieType()) {
			case Movie.NEW_MOVIE:
				result = r.getDay() * 3;
				break;
			case Movie.COMMON_MOVIE:
				if (r.getDay() <= 3)
					result = r.getDay() * 1.5;
				else
					result = (r.getDay() - 3) * 1.5 + 1.5;
				break;
			case Movie.CHILD_MOVIE:
				if (r.getDay() <= 3)
					result = r.getDay() * 1.5;
				else
					result = (r.getDay() - 3) * 1.5 + 1.5;
				break;
			}
			totalPrice += result;
			fre++;
			if (r.getMovie().getMovieType() == Movie.NEW_MOVIE && r.getDay() > 1)
				fre++;
		}
		System.out.println(this.clientName + "消费的金额是：" + totalPrice + ",你所获得的积分是：" + fre);
	}

}
