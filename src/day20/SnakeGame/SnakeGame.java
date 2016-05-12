package day20.SnakeGame;

import day20.SnakeGame.game.*;
import day20.SnakeGame.util.Gobal;
import day20.SnakeGame.view.*;
import javax.swing.JFrame;
import day20.SnakeGame.contorller.*;

public class SnakeGame {
	public static void main(String[] args) {
		Snake snake = new Snake();
		Food food = new Food();
		Barrier barrier = new Barrier();
		GameUI gameUI = new GameUI();
		// 蛇的监听器和键盘的监听器
		Contorller contorller = new Contorller(snake, food, barrier, gameUI);
		// 蛇添加监听器
		snake.addSnakeListener(contorller);
		// 面板添加键盘的监听器
		gameUI.addKeyListener(contorller);

		JFrame jf = new JFrame("贪吃蛇");
		jf.setSize(Gobal.CELL_SIZE * Gobal.WIDTH + 16, Gobal.CELL_SIZE * Gobal.HEIGHT + 36);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		// 面板让键盘生效
		gameUI.setFocusable(true);
		jf.add(gameUI);
		contorller.startGame();
		jf.setVisible(true);
	}
}
