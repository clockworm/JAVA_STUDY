package day20;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame {
	public static void main(String[] args) {
		JFrame jf = new JFrame("我的窗口");
		JButton jb1 = new JButton("确定1");
		JButton jb2 = new JButton("确定2");
		JButton jb3 = new JButton("确定3");
		JButton jb4 = new JButton("确定4");
		JButton jb5 = new JButton("确定5");
		JButton jb6 = new JButton("确定6");
		jf.setSize(300, 300); // 设置窗体大小
		jf.setVisible(true); // 是否显示
		jf.setLocationRelativeTo(null); // 显示在中间
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭及退出
		jf.setLayout(new GridLayout(2, 3));   //网格布局
		jf.add(jb1);
		jf.add(jb2);
		jf.add(jb3);
		jf.add(jb4);
		jf.add(jb5);
		jf.add(jb5);
		jf.add(jb6);

	}
}
