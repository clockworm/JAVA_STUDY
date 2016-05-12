package day4;

//for循环
public class JavaFor {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			System.out.println("Helloworld" + i);

		int sum = 0;
		for (int i = 1; i <= 100; i++)
			if (i % 2 == 0) // 偶数
				sum += i;
		System.out.println(sum);

		// 奇数和
		sum = 0;
		for (int i = 1; i <= 100; i += 2)
			sum += i;
		System.out.println(sum);

		// 偶数和
		sum = 0;
		for (int i = 2; i <= 100; i += 2)
			sum += i;
		System.out.println(sum);

		// 既能除以3也能除以5
		int count = 0;
		for (int i = 5; i <= 100; i += 5)
			if (i % 3 == 0) {
				count++;
				System.out.println(i);
			}
		System.out.println("一共有" + count + "个");
		// 1到10的阶乘的和
		long t = 1;
		long sum_ = 0;
		for (int i = 1; i <= 10; i++) {
			t *= i;
			sum_ += t;
		}
		System.out.println(sum_);

		// 输入一个数字，打印所有因子
		// 包含1不包含自己并求和
		t = 253;
		sum = 0;
		for (int i = 1; i <= (t / 2); i++) {
			if (t % i == 0) {
				sum += i;
				System.out.println(t + "的因子：" + i);
			}
		}
		System.out.println(t + "的因子总和:" + sum);

		// 判断100到1000的素数
		count = 0;
		for (t = 101; t < 1000; t += 2) {
			sum = 0;
			for (int i = 2; i <= (t / 2) + 1; i++) {
				if (t % i == 0) {
					sum = 1;
					break;
				}
			}
			if (sum == 0) {
				count++;
				System.out.print(t + "  ");
				if (count % 5 == 0) {
					System.out.println("");
				}
			}
			// else
			// System.out.println(t+"不是素数");
		}

		// 99乘法表
		System.out.println("");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "  ");
			}
			System.out.println("");
		}
		// 打印星花

		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("           ");
		// .1
		for (int i = 8; i > 1; i--) {
			for (int k = 1; k <= 8 - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// L形状
		for (int i = 1; i < 9; i++) {

			if (i > 7) {
				System.out.println("**************");
			} else {
				System.out.println("**");
			}
		}
		// 等边梯形角形
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j <= 7 - i; j++) {
				System.out.print(" ");// 空格在递减，i在递加
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 6; i >= 1; i--) {
			for (int j = 1; j <= 7 - i; j++) {
				System.out.print(" ");// 空格在递加，i在递减
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 百钱买百鸡
		// 公鸡 3块 母鸡 2块 小鸡1块2只
		for (int i = 1; i < 34; i++) {
			for (int j = 1; j < 50; j++) {
				int k = 100 - i - j;
				if (k % 2 == 0 && (3 * i + 2 * j + k / 2) == 100) {
					System.out.println("公鸡：" + i + " 母鸡：" + j + " 小鸡：" + k);
				}
			}
		}

		// 倒立金字塔
		for (int i = 7; i >= 1; i--) {
			for (int j = 1; j <= 7 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// 单跳循环
		// 标识跳出循环
		outer: for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (i == 3) {
					break outer;
				}
				System.out.println(i + "" + j);
			}
		}
	}
}