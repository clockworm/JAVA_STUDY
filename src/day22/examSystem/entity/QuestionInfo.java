package day22.examSystem.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionInfo  implements Serializable{
	private Question question;
	private int pageIndex;
	private ArrayList<Integer> userAnswer = new ArrayList<Integer>();

	public QuestionInfo() {

	}

	/**
	 * @param question
	 * @param pageIndex
	 */
	public QuestionInfo(Question question, int pageIndex) {
		this.question = question;
		this.pageIndex = pageIndex;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public ArrayList<Integer> getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(ArrayList<Integer> userAnswer) {
		this.userAnswer = userAnswer;
	}

	@Override
	public String toString() {
		return question.toString();
	}
}
