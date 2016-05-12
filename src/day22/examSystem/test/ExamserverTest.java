package day22.examSystem.test;

import java.util.ArrayList;
import day22.examSystem.dao.EntityContext;
import day22.examSystem.entity.QuestionInfo;
import day22.examSystem.entity.User;
import day22.examSystem.exception.IdPassException;
import day22.examSystem.server.ExamServerImp;

public class ExamserverTest {

	public static void main(String[] args) {
		ExamServerImp login = new ExamServerImp();
		EntityContext enContext = new EntityContext();
		login.setEntityContext(enContext);
		try {
			User user = login.login("10001", "123456");
			System.out.println(user.getName() + ":" + user.getE_mail());
		} catch (IdPassException e) {
			e.printStackTrace();
		}

		ArrayList<QuestionInfo> questions = login.getExamQuestions();
		for (QuestionInfo question : questions) {
			System.out.print(question.getQuestion().getScore());
			System.out.println(question.getPageIndex() + ":" + question);
			System.out.print("答案");
			for (Integer integer : question.getQuestion().getAnswers()) {
				System.out.print(integer + "---- ");
			}
			System.out.println();
		}
	}

}
