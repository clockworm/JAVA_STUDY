package day20.SnakeGame.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import day20.SnakeGame.util.Gobal;

/**
 * 障碍物
 * 
 * @author Administrator
 *
 */
public class Barrier {
	private int[][] rocks = new int[Gobal.WIDTH][Gobal.HEIGHT];

	/**
	 * @param rocks
	 */
	public Barrier() {
		for (int y = 0; y < Gobal.WIDTH; y++) {
			for (int x = 0; x < Gobal.HEIGHT; x++) {
				if (y == 0 || y == Gobal.WIDTH - 1) {
					rocks[y][x] = 1;
				}
				if (x == 0 || x == Gobal.HEIGHT - 1) {
					rocks[x][y] = 1;
				}
			}
		}
	}

	public boolean isMeetSnake(Snake snake) {
		Point head = snake.getHead();
		for (int x = 0; x < Gobal.WIDTH; x++) {
			for (int y = 0; y < Gobal.HEIGHT; y++) {
				if (rocks[x][y] == 1 && head.x == x && head.y == y) {
					return true;
				}
				if (rocks[y][x] == 1 && head.x == x && head.y == y) {
					return true;
				}
			}
		}
		return false;
		// 是否碰到障碍物
	}

	public void drawMe(Graphics g) {
		g.setColor(Color.yellow);
		System.out.println("画出障碍物");
		for (int y = 0; y < Gobal.WIDTH; y++) {
			for (int x = 0; x < Gobal.HEIGHT; x++) {
				if (rocks[y][x] == 1) {
					g.fill3DRect(x * Gobal.CELL_SIZE, y * Gobal.CELL_SIZE, Gobal.WIDTH, Gobal.HEIGHT, true);
				}
				if (rocks[x][y] == 1) {
					g.fill3DRect(x * Gobal.CELL_SIZE, y * Gobal.CELL_SIZE, Gobal.WIDTH, Gobal.HEIGHT, true);
				}
			}
		}
	}

	public Point getPoint(Snake snake) {
		int x, y;
		boolean flag = false;
		while (true) {
			x = new Random().nextInt(Gobal.WIDTH);
			y = new Random().nextInt(Gobal.HEIGHT);
			for (int i = 0; i < snake.list.size(); i++) {
				if ((snake.list.get(i).x != x && snake.list.get(i).y != y) && rocks[x][y] != 1 && rocks[y][x] != 1) {
					flag = true;
				}
			}
			if (flag) {
				return new Point(x, y);
			}
		}
	}
}
