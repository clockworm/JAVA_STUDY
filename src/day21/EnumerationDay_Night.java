package day21;

/**
 * 枚举 知道这个类创建的个数。 每个对象有自己的方法 模例 switch 可以放枚舉類型
 * 
 * @author Administrator
 *
 */
public abstract class EnumerationDay_Night {

	public static void main(String[] args) {
		Day_Night night2 = Day_Night.NIGHT;
		Day_Night whiteday = Day_Night.WHITEDAY;
		night2.print();
		whiteday.print();
		Day_Night[] enums = Day_Night.values();
		for (Day_Night en : enums) {
			System.out.println(en);
		}
		
		// Day_Night night3 = Day_Night.valueOf("NIGHT");
		// Day_Night whiteday3 = Day_Night.valueOf("WHITEDAY");
		
		switch (night2) {
		case WHITEDAY:
			System.out.println("白天----");
			break;
		case NIGHT:
			System.out.println("黑夜----");
			break;
		}

		System.out.println(night2);
		System.out.println(whiteday);
		EnumerationDay_Night day = EnumerationDay_Night.WHITE_DAY;
		System.out.println(day);
		EnumerationDay_Night night = EnumerationDay_Night.NIGHT;
		System.out.println(night);
		
	}

	public static final EnumerationDay_Night WHITE_DAY = new EnumerationDay_Night() {
		public String toString() {
			return "白天";
		}
	};
	public static final EnumerationDay_Night NIGHT = new EnumerationDay_Night() {
		public String toString() {
			return "夜晚";
		}
	};

	private EnumerationDay_Night() {
	}

}
