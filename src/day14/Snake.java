package day14;

import java.util.LinkedList;

//贪吃蛇
public class Snake {
	private LinkedList<Node> list = new LinkedList<Node>();
	public static final int UP = -10;
	public static final int DOWN = 10;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	public int dir;

	// 创建蛇身
	public Snake() {
		list.add(new Node(5, 5));
		list.add(new Node(5, 4));
		list.add(new Node(5, 3));
		list.add(new Node(5, 2));
		list.add(new Node(5, 1));
		// list.add(new Node(6, 3));
		// list.add(new Node(7, 3));
		this.dir = RIGHT;
	}

	// 是否存在 打印捨身
	public boolean print(int x, int y) {
		return list.contains(new Node(x, y));
	}

	// 移动 默认向右走 //改变蛇的图形
	public int step() {
		// 去尾
		list.removeLast();
		// 加头
		Node head = list.getFirst();
		int x = head.getX() + dir / 10;
		int y = head.getY() + dir % 10;
		list.addFirst(new Node(x, y));
		return 0;
	}

	// 方向 //改变蛇的图形
	public int step(int dir) {
		if (this.dir + dir != 0) {
			this.dir = dir;
			// 去尾
			list.removeLast();
			// 加头
			Node head = list.getFirst();
			int x = head.getX() + dir / 10;
			int y = head.getY() + dir % 10;
			if (x == 0 || y == 0 || y == 20 || x == 20) {
				System.out.println("前面墙不能走了");
				return 1;
			}
			list.addFirst(new Node(x, y));
		}
		return 0;
	}
}
