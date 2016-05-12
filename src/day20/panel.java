package day20;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class panel {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}
}

class MyFrame extends JFrame {
	private JLabel name = new JLabel("姓名");
	private JTextField namePanelText = new JTextField(10);
	private JCheckBox box = new JCheckBox("xx");
	private JTextArea jta = new JTextArea(10, 20);
	private JButton jb = new JButton("确定");
	private JButton jb2 = new JButton("取消");
	private JButton jb3 = new JButton("关闭");
	private JPanel sjp = new JPanel();
	private JPanel njp = new JPanel();
	private JPanel cjp = new JPanel();

	/*
	 * 窗体默认布局是整个布局 面板默认是FlowLayout
	 */

	public MyFrame() {
		setSize(300, 300);
		setTitle("我的窗体");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("wo ri ");
			}
		});
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("点我吧");
			}
		});
		this.setLayout(new BorderLayout());
		this.add(njp, BorderLayout.NORTH);
		njp.add(name);
		njp.add(namePanelText);
		this.add(cjp, BorderLayout.CENTER);
		cjp.add(jta);
		this.add(sjp, BorderLayout.SOUTH);
		sjp.add(jb);
		sjp.add(jb2);
		sjp.add(jb3);
		sjp.add(box);
	}

}