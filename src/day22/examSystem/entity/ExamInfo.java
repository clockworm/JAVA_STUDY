package day22.examSystem.entity;

import java.io.Serializable;

public class ExamInfo implements Serializable{
	private User user;
	private int timeLimit;
	private String title;
	private int totalNumbers;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalNumbers() {
		return totalNumbers;
	}

	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("姓名:").append(user.getName()).append(" ");
		sb.append("编号:").append(user.getId()).append(" ");
		sb.append("科目:").append(title).append(" ");
		sb.append("考试时间:").append(timeLimit).append("分钟 ");
		sb.append("题量:").append(totalNumbers);
		return sb.toString();
	}
}
