package day14;

//地图
public class Map {
	public static Snake sk = new Snake();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			print();
			if (sk.step(Snake.DOWN) == 1) { //设置蛇的图形
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//打印地图和蛇形
	public static void print() {
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				if (i == 0 || i == 20) {
					System.out.print("—");
				} else if (j == 0 || j == 20) {
					System.out.print("丨");
				} else if (sk.print(i, j)) {
					System.out.print("#");
				}
				System.out.print("\t");
			}
			System.out.println("");
		}
	}
}
