package day22.examSystem.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day22.examSystem.control.ClientContext;
import day22.examSystem.exception.IdPassException;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	private ClientContext clientContext;
	private JTextField idtext;
	private JPasswordField password;

	// 获取ID
	public String getIdtext() {
		return idtext.getText().trim();
	}

	// 获取密码
	public String getPassword() {
		return new String(password.getPassword());
	}

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
		this.clientContext.setLoginFrame(this);
	}

	public LoginFrame() {
		this.setTitle("考试系统");
		this.setSize(250, 200);
		// this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		// 设置内容窗格
		this.setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(BorderLayout.NORTH, createPanel_NORTH());
		panel.add(BorderLayout.CENTER, createPanel_CENTER());
		panel.add(BorderLayout.SOUTH, createPanel_SOUTH());
		return panel;
	}

	private JPanel createPanel_NORTH() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("登录系统"), JLabel.CENTER);
		return panel;
	}

	private JPanel createPanel_CENTER() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(BorderLayout.NORTH, createUserPanel());
		return panel;
	}

	private JPanel createUserPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(createUserNamePanel());
		panel.add(createUserPasswordPanel());
		return panel;
	}

	private JPanel createUserNamePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("编号:");
		idtext = new JTextField();
		panel.add(BorderLayout.WEST, label);
		panel.add(BorderLayout.CENTER, idtext);
		return panel;
	}

	private JPanel createUserPasswordPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("密码:");
		password = new JPasswordField();
		panel.add(BorderLayout.WEST, label);
		panel.add(BorderLayout.CENTER, password);
		return panel;
	}

	private JPanel createPanel_SOUTH() {
		JPanel panel = new JPanel();
		JButton loginbutton = new JButton("登录");
		loginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clientContext.login();
				} catch (IdPassException e1) {
					JOptionPane.showMessageDialog(LoginFrame.this, e1.getMessage());
				}
			}
		});
		JButton cancelbutton = new JButton("取消");
		cancelbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		panel.add(loginbutton);
		panel.add(cancelbutton);
		return panel;
	}

	public void exit() {
		int i = JOptionPane.showConfirmDialog(null, "是否退出");
		if (i == 0) {
			System.exit(0);
		}
	}

}
