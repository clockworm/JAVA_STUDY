package day21;

public class VariableParameter {
	public static void main(String[] args) {
		add("相加");
		add("相加", 90, 100);
		add(new int[] { 1, 8, 10 });
	}
	//可以重载
	public static void add(int... a) { // 可变参数只能有一个 且只能放在最后的位置
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		System.out.println(sum);
	}

	public static void add(String s, int... a) { // 可变参数只能有一个 且只能放在最后的位置
		int sum = 0;
		System.out.print(s);
		for (int i : a) {
			sum += i;
		}
		System.out.println(sum);
	}
}
