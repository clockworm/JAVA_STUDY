package day20.SnakeGame.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import day20.SnakeGame.util.Gobal;

/**
 * 食物
 * 
 * @author Administrator
 *
 */
public class Food extends Point {
	private int x;
	private int y;

	public boolean isEatBySnake(Snake snake) {
		if (snake.getHead().x == this.x && this.y == snake.getHead().y) {
			return true;
		}
		return false;
	}

	public void addfood(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public void drawMe(Graphics g) {
		g.setColor(Color.red);
		System.out.println("画出食物");
		g.fill3DRect(x * Gobal.CELL_SIZE, y * Gobal.CELL_SIZE, Gobal.WIDTH, Gobal.HEIGHT, true);
	}
}
