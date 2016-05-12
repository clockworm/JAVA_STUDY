package day22.examSystem.control;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import day22.examSystem.entity.ExamInfo;
import day22.examSystem.entity.QuestionInfo;
import day22.examSystem.entity.User;
import day22.examSystem.exception.IdPassException;
import day22.examSystem.server.ExamServer;
import day22.examSystem.ui.ExamFrame;
import day22.examSystem.ui.LoginFrame;
import day22.examSystem.ui.MenuFrame;

public class ClientContext {
	private LoginFrame loginFrame;
	private MenuFrame menuFrame;
	private ExamFrame examFrame;
	private ExamServer examServer;
	private User user;
	private int currPage;
	private ExamInfo examInfo;
	private boolean isOver;
	private Timer timer;

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}

	public void setExamServer(ExamServer examServer) {
		this.examServer = examServer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void login() throws IdPassException {
		String id = loginFrame.getIdtext();
		if (id == null || "".equals(id))
			throw new IdPassException("请输入编号");
		String password = loginFrame.getPassword();
		if (password == null || "".equals(password))
			throw new IdPassException("请输入密码");
		user = examServer.login(id, password);
		loginFrame.setVisible(false);
		menuFrame.updateLabel(user);
		menuFrame.setVisible(true);
	}

	public void start() {
		if (!isOver) {
			examInfo = examServer.start();
			examInfo.setUser(user);
			QuestionInfo questionInfo = new QuestionInfo();
			questionInfo = examServer.getQuestionInfo(0);
			currPage = questionInfo.getPageIndex();
			examFrame.updateView(examInfo, questionInfo);
			menuFrame.setVisible(false);
			examFrame.setVisible(true);
			startTime();
		} else {
			JOptionPane.showMessageDialog(examFrame, "你已经参加过考試,请查看分数");
		}
	}

	public void startTime() {
		/**
		 * 考试结束时间
		 */
		final long end = System.currentTimeMillis() + examInfo.getTimeLimit() * 60 * 1000;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				long sub = end - System.currentTimeMillis();
				if (sub <= 0) {
					over();
					return;
				}
				examFrame.updateTime(sub);
			}
		}, 0, 1000);
	}

	public void nextQuestion() {
		examServer.saveUserAnswers(currPage, examFrame.getUseredAnswer());
		currPage = currPage + 1;
		QuestionInfo questionInfo = examServer.getQuestionInfo(currPage);
		examFrame.updateView(examInfo, questionInfo);
	}

	public void previousQuestion() {
		examServer.saveUserAnswers(currPage, examFrame.getUseredAnswer());
		currPage = currPage - 1;
		QuestionInfo questionInfo = examServer.getQuestionInfo(currPage);
		examFrame.updateView(examInfo, questionInfo);
	}

	public void send() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(examFrame, "确定要交卷吗?")) {
			over();
		}
	}

	public void over() {
		timer.cancel();
		examServer.saveUserAnswers(currPage, examFrame.getUseredAnswer());
		int totalScore = this.examServer.getTotalScore();
		JOptionPane.showMessageDialog(examFrame, "你的成绩是:" + totalScore);
		examFrame.setVisible(false);
		menuFrame.setVisible(true);
		isOver = true;
	}

	public void getResult() {
		if (isOver) {
			JOptionPane.showMessageDialog(examFrame,
					this.getUser().getName() + "的成绩是" + this.examServer.getTotalScore());
		} else {
			JOptionPane.showMessageDialog(examFrame, "你还没有開始考試");
		}
	}
}
