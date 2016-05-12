package day20.SnakeGame.view;

import java.awt.Graphics;
import javax.swing.JPanel;
import day20.SnakeGame.game.*;

/**
 * 显示面板
 * 
 * @author Administrator
 *
 */
public class GameUI extends JPanel {
	private Snake snake;
	private Food food;
	private Barrier barrier;

	public void dispaly(Snake snake, Food food, Barrier barrier) {
		this.snake = snake;
		this.food = food;
		this.barrier = barrier;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		snake.drawMe(g);
		food.drawMe(g);
		barrier.drawMe(g);
	}

}
