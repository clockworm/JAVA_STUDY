package day10;

import java.util.Arrays;

public abstract class Question {

	private String title;
	private String[] options;

	public Question(String title, String[] options) {
		this.title = title;
		this.options = options;
	}

	public abstract boolean check(String[] answer);

	public void printQuestionContent() {
		System.out.println("标题:" + title + "内容" + Arrays.toString(options));
	}
}
