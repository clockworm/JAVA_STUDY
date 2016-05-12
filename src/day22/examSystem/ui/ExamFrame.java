package day22.examSystem.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import day22.examSystem.control.ClientContext;
import day22.examSystem.entity.ExamInfo;
import day22.examSystem.entity.QuestionInfo;
import day22.examSystem.util.IOUtil;
import day22.examSystem.util.ReadUtil;

public class ExamFrame extends JFrame {
	private ClientContext clientContext;
	private JLabel infoJLable;
	private JTextArea textContent;
	private JLabel countJlabel;
	private JLabel timeJLabel;
	private JButton button1;
	private JButton button2;
	private ArrayList<Option> options = new ArrayList<Option>();

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
		this.clientContext.setExamFrame(this);
	}

	public ExamFrame() {
		this.setTitle("开始评测...");
		this.setSize(600, 400);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new LoginFrame().exit();
			}
		});
		this.setLocationRelativeTo(this);
		// this.setResizable(false);s
		// 设置内容窗格
		this.setContentPane(createContentPane());
	}

	private JPanel createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		URL url = this.getClass().getResource("exam_title.png");
		ImageIcon icon = new ImageIcon(url);
		panel.add(BorderLayout.NORTH, new JLabel(icon, JLabel.CENTER));
		panel.add(BorderLayout.CENTER, createCentPanel());
		panel.add(BorderLayout.SOUTH, createSouthPanel());
		return panel;
	}

	private JPanel createCentPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		infoJLable = new JLabel("姓名:xxxx 编号:xxxxx 开始时间:1分钟 题量: 20", JLabel.CENTER);
		panel.add(BorderLayout.NORTH, infoJLable);
		panel.add(BorderLayout.CENTER, createQuestionPanel());
		panel.add(BorderLayout.SOUTH, createOptionsPanel());
		return panel;
	}

	private JScrollPane createQuestionPanel() {
		JScrollPane panel = new JScrollPane();
		textContent = new JTextArea();
		textContent.setLineWrap(true);
		textContent.setFocusable(false);
		panel.getViewport().add(textContent);
		return panel;
	}

	private JPanel createOptionsPanel() {
		JPanel panel = new JPanel();
		Option box1 = new Option("A", 1);
		Option box2 = new Option("B", 2);
		Option box3 = new Option("C", 3);
		Option box4 = new Option("D", 4);
		options.add(box1);
		options.add(box2);
		options.add(box3);
		options.add(box4);
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		panel.add(box4);
		return panel;
	}

	private class Option extends JCheckBox {
		private int value;

		public Option(String name, int value) {
			super(name);
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	private JPanel createSouthPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		countJlabel = new JLabel("共20个当前第一个", JLabel.LEFT);
		panel.add(BorderLayout.WEST, countJlabel);
		panel.add(BorderLayout.CENTER, createButtonPanel());
		timeJLabel = new JLabel("00:00:60", JLabel.RIGHT);
		panel.add(BorderLayout.EAST, timeJLabel);
		return panel;
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		button1 = new JButton("上一题");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.previousQuestion();
			}
		});
		button2 = new JButton("下一题");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.nextQuestion();
			}
		});
		JButton button3 = new JButton("交卷");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.send();
			}
		});
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		return panel;
	}

	public void updateView(ExamInfo examInfo, QuestionInfo questionInfo) {
		infoJLable.setText(examInfo.toString());
		textContent.setText(questionInfo.getQuestion().toString());
		countJlabel.setText("共" + 20 + "个当前第" + (questionInfo.getPageIndex() + 1) + "个");
		updateButton(questionInfo);
		updateOptions(questionInfo);
	}

	public void updateButton(QuestionInfo questionInfo) {
		if (questionInfo.getPageIndex() == 0) {
			button1.setEnabled(false);
		} else {
			button1.setEnabled(true);
		}
		if (questionInfo.getPageIndex() == 19) {
			button2.setEnabled(false);
		} else {
			button2.setEnabled(true);
		}
	}

	private void updateOptions(QuestionInfo questionInfo) {
		ArrayList<Integer> userAnswers = questionInfo.getUserAnswer();
		for (Option option : options) {
			option.setSelected(userAnswers.contains(option.getValue()));
		}
	}

	public void updateTime(long sub) {
		int h = (int) (sub / 1000 / 60 / 60);
		int m = (int) (sub / 1000 / 60 % 60);
		int s = (int) (sub / 1000 % 60);
		timeJLabel.setText(h + ":" + m + ":" + s);
	}

	/**
	 * 获取保存用户的答案
	 * 
	 * @return
	 */
	public ArrayList<Integer> getUseredAnswer() {
		ArrayList<Integer> userAnswers = new ArrayList<Integer>();
		for (Option option : options) {
			if (option.isSelected()) {
				userAnswers.add(option.value);
			}
		}
		return userAnswers;
	}
}
