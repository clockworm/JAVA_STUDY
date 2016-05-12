package day10;

import java.util.Arrays;

public class MultipleQuestion extends Question {
	private String[] answer;

	public MultipleQuestion(String title, String[] options, String[] answer) {
		super(title, options);
		this.answer = answer;
	}

	@Override
	public boolean check(String[] answer) {
		Arrays.sort(answer);
		return Arrays.equals(this.answer, answer);
	}

}
