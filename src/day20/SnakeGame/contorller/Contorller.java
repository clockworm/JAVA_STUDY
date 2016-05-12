package day20.SnakeGame.contorller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/**
 * 控制器 控制蛇  食物 障碍物  界面  主要操作來自鍵盤
 */
import day20.SnakeGame.game.Barrier;
import day20.SnakeGame.game.Food;
import day20.SnakeGame.game.Snake;
import day20.SnakeGame.listener.SnakeListener;
import day20.SnakeGame.view.GameUI;

public class Contorller extends KeyAdapter implements SnakeListener {
	private Snake snake;
	private Food food;
	private Barrier barrier;
	private GameUI gameUI;

	/**
	 * @param snake
	 * @param food
	 * @param barrier
	 * @param gameUI
	 */
	public Contorller(Snake snake, Food food, Barrier barrier, GameUI gameUI) {
		this.snake = snake;
		this.food = food;
		this.barrier = barrier;
		this.gameUI = gameUI;
	}

	// 游戏开始入口
	public void startGame() {
		snake.start();
		food.addfood(barrier.getPoint(snake));
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			snake.changeMove(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeMove(Snake.DOWN);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeMove(Snake.RIGHT);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeMove(Snake.LEFT);
			break;
		}
	}

	@Override
	public void snakeMoved(Snake snake) {
		if (snake.eatFood(food)) {
			food.addfood(barrier.getPoint(snake));
		}
		if (barrier.isMeetSnake(snake) || snake.isEatSelf()) {
			snake.setLife(false);
			JOptionPane.showConfirmDialog(null, "GameOver");
			System.exit(0);
		}
		gameUI.dispaly(snake, food, barrier);
	}

}
