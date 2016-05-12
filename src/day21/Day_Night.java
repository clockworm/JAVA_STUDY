package day21;

/**
 * 枚举对象必须罗列在最前面 构造函数默认私有 如果写成public 编写不通过 每個對象元素都是public static final
 * 
 * @author Administrator
 *
 */
public enum Day_Night {
	WHITEDAY() {
		@Override
		public void print() {
			System.out.println("白天");
			
		}
	},
	NIGHT("茉莉") {
		@Override
		public void print() {
			System.out.println("黑夜");
		}
	};
	
	
	private Day_Night() {

	}

	private Day_Night(String string) {

	}

	public abstract void print();
}
