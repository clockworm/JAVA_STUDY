package day20.SnakeGame.listener;

import day20.SnakeGame.game.Snake;

/**
 * 时刻监听蛇是否监听 碰到自己 食物 障碍物
 * 
 * @author Administrator
 *
 */
public interface SnakeListener {
	public void snakeMoved(Snake sanke);
}
