package day20;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLine {
	public static void main(String[] args) {
		JFrame jf = new JFrame("我的窗体");
		jf.setSize(600, 600);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myDraw panel = new myDraw();
		jf.add(panel);
		jf.setVisible(true);
	}
}

class myDraw extends JPanel {
	private ArrayList<Line2D> list = new ArrayList<Line2D>();
	private Point2D last = new Point2D.Double(10, 10);
	private Point2D end;

	public myDraw() {
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					end = new Point2D.Double(last.getX(), last.getY() + 5);
					break;
				case KeyEvent.VK_UP:
					end = new Point2D.Double(last.getX(), last.getY() - 5);
					break;
				case KeyEvent.VK_LEFT:
					end = new Point2D.Double(last.getX() - 5, last.getY());
					break;
				case KeyEvent.VK_RIGHT:
					end = new Point2D.Double(last.getX() + 5, last.getY());
					break;
				}
				Line2D li = new Line2D.Double(last, end);
				list.add(li);
				repaint();
				last = end;
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Line2D line : list) {
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(line);
		}
	}

}
