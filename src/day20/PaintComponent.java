package day20;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintComponent {
	public static void main(String[] args) {
		JFrame jf = new JFrame("我的窗体");
		jf.setSize(600, 600);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Paint panel = new Paint();
		jf.add(panel);
		jf.setVisible(true);
	}
}

class Paint extends JPanel {
	private ArrayList<Rectangle2D> list = new ArrayList<Rectangle2D>();

	public Paint() {

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Rectangle2D rect = new Rectangle2D.Double(e.getX() - 18, e.getY() - 23F, 36, 46);
				Point2D p = e.getPoint();
				Rectangle2D rec = findPoint(p);
				if (rec == null) {
					list.add(rect);
				}
				repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Rectangle2D p2 = findPoint(e.getPoint());
				if (e.getClickCount() >= 2 && p2 != null) {
					list.remove(p2);
					repaint();
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Rectangle2D p2 = findPoint(e.getPoint());
				if (p2 != null) {
					p2.setFrame(e.getX() - 18, e.getY() - 23, 36, 46);
					repaint();
				}
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Rectangle2D rectangle2d : list) {
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(rectangle2d);
		}
	}

	public Rectangle2D findPoint(Point2D p) {
		for (Rectangle2D rectangle2d : list) {
			if (rectangle2d.contains(p)) {
				return rectangle2d;
			}
		}
		return null;
	}
}
