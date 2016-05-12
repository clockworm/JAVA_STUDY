package day22.examSystem.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import day22.examSystem.control.ClientContext;
import day22.examSystem.entity.User;

public class MenuFrame extends JFrame {

	private JLabel Userlabel = new JLabel("asdsadsa,", JLabel.CENTER);
	private ClientContext clientContext;

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
		this.clientContext.setMenuFrame(this);
	}

	public MenuFrame() {
		this.setTitle("在线评测系统");
		this.setSize(600, 400);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new LoginFrame().exit();
			}
		});
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		// 设置内容窗格
		this.setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		// 获取当类所在的路径
		URL url = this.getClass().getResource("title.png");
		ImageIcon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		panel.add(BorderLayout.NORTH, label);
		panel.add(CreateCenterPanel());
		panel.add(BorderLayout.SOUTH, new JLabel("版权隶属于Tom      ", JLabel.RIGHT));
		return panel;
	}

	private JPanel CreateCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		Userlabel = new JLabel("欢迎XXX来到考试系统", JLabel.CENTER);
		panel.add(BorderLayout.NORTH, Userlabel);
		panel.add(BorderLayout.CENTER, createButtonPanel());
		return panel;
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		JButton startButton = createButton("开始", "exam.png");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.start();
			}
		});
		JButton resultButton = createButton("分数", "result.png");
		resultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.getResult();
			}
		});
		panel.add(startButton);
		panel.add(resultButton);
		panel.add(createButton("規則", "message.png"));
		JButton exitButton = createButton("离开", "exit.png");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "是否退出");
				if (i == 0) {
					System.exit(0);
				}
			}
		});
		panel.add(exitButton);
		return panel;
	}

	private JButton createButton(String name, String Iconname) {
		URL url = this.getClass().getResource(Iconname);
		ImageIcon icon = new ImageIcon(url);
		JButton button = new JButton(name, icon);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		return button;
	}

	public void updateLabel(User user) {
		Userlabel.setText("欢迎" + user.getName() + "来到考试系统,");
		Userlabel.setForeground(Color.red);
	}
}
