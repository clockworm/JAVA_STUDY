package day20;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TurnColour {
	public static void main(String[] args) {
		JFrame jf = new JFrame("我的窗体");
		jf.setSize(300, 300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel1 panel = new MyPanel1();
		jf.add(panel);
		jf.setVisible(true);
	}
}

class MyPanel1 extends JPanel {
	private JTextField jt1 = new JTextField("hello", 10);
	private JTextField jt2 = new JTextField("world", 10);

	public MyPanel1() {
		this.add(jt1);
		this.add(jt2);
		this.setFocusable(true);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("面板");
			}
		});
		jt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("hello");
			}
		});
		jt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("world");
			}
		});
		addButton("蓝色", Color.blue);
		addButton("红色", Color.red);
		addButton("黄色", Color.yellow);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("點擊");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("按下");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("釋放");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("按下");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("点击");

			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println(e.getX() + ":" + e.getY());
			}
		});
	}

	public void addButton(String name, Color colour) {
		JButton jb = new JButton(name);
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPanel1.this.setBackground(colour);
			}
		});
		this.add(jb);
	}
}
