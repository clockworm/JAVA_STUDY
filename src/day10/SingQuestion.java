package day10;

public class SingQuestion extends Question {
	private String answer;

	public SingQuestion(String title, String[] options, String answer) {
		super(title, options);
		this.answer = answer;
	}
	@Override
	public boolean check(String[] answer) {
		if (answer.length != 1)
			return false;
		return answer[0].equals(this.answer);
	}
}
