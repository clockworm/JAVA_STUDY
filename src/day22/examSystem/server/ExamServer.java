package day22.examSystem.server;

import java.util.ArrayList;
import day22.examSystem.entity.ExamInfo;
import day22.examSystem.entity.QuestionInfo;
import day22.examSystem.entity.User;
import day22.examSystem.exception.IdPassException;

public interface ExamServer {
	User login(String id, String password) throws IdPassException;

	ExamInfo start();

	ArrayList<QuestionInfo> getExamQuestions();

	QuestionInfo getQuestionInfo(int index);

	void saveUserAnswers(int page, ArrayList<Integer> userAnswers);

	int getTotalScore();
}
