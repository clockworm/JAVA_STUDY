package day20.SnakeGame.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import day20.SnakeGame.util.Gobal;
import java.util.LinkedList;
import day20.SnakeGame.listener.SnakeListener;

/**
 * 蛇
 * 
 * @author Administrator
 *
 */
public class Snake {
	private SnakeListener snakeListener;
	public LinkedList<Point> list = new LinkedList<Point>();
	public static final int UP = 1;
	public static final int DOWN = -1;
	public static final int LEFT = 5;
	public static final int RIGHT = -5;
	private int oldcurrdir, newcurrdir; // 存储当前方向
	private Point tail;
	private boolean life = true;

	public Snake() {
		init();
	}

	private void init() {
		int x = Gobal.WIDTH / 2;
		int y = Gobal.HEIGHT / 2;
		for (int i = 0; i < 3; i++) {
			list.add(new Point(x - i, y));
		}
		this.oldcurrdir = this.newcurrdir = RIGHT;
	}

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	public void move() {
		this.tail = list.removeLast();
		int x = list.getFirst().x;
		int y = list.getFirst().y;
		if (oldcurrdir + newcurrdir != 0) {
			oldcurrdir = newcurrdir;
		}
		switch (oldcurrdir) {
		case UP:
			y--;
			if (y < 0) {
				y = Gobal.HEIGHT - 1;
			}
			break;
		case DOWN:
			y++;
			if (y == Gobal.HEIGHT) {
				y = 0;
			}
			break;
		case LEFT:
			x--;
			if (x < 0) {
				x = Gobal.WIDTH - 1;
			}
			break;
		case RIGHT:
			x++;
			if (x > Gobal.WIDTH) {
				x = 0;
			}
			break;
		}
		Point point = new Point(x, y);
		list.addFirst(point);
	}

	// 正在改变方向
	public void changeMove(int dir) {
		System.out.println("正在改变方向");
		newcurrdir = dir;
	}

	public boolean eatFood(Food food) {
		if (food.isEatBySnake(this)) {
			list.add(tail);
			return true;
		}
		return false;
	}

	public boolean isEatSelf() {
		Point p = getHead();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).equals(p)) {
				return true;
			}
		}
		return false;
	}

	public Point getHead() {
		return list.getFirst();
	}

	// 蛇身
	public void drawMe(Graphics g) {
		g.setColor(Color.blue);
		for (Point point : list) {
			g.fill3DRect(point.x * Gobal.CELL_SIZE, point.y * Gobal.CELL_SIZE, Gobal.WIDTH, Gobal.HEIGHT, true);
		}
	}

	public void addSnakeListener(SnakeListener snakeListener) {
		if (snakeListener != null) {
			this.snakeListener = snakeListener;
		}
	}

	public void start() {
		new SnakeDriver().start();
	}

	private class SnakeDriver extends Thread {
		@Override
		public void run() {
			while (life) {
				move();
				snakeListener.snakeMoved(Snake.this);
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
