package day22.examSystem.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import day22.examSystem.dao.EntityContext;
import day22.examSystem.entity.ExamInfo;
import day22.examSystem.entity.Question;
import day22.examSystem.entity.QuestionInfo;
import day22.examSystem.entity.User;
import day22.examSystem.exception.IdPassException;
import day22.examSystem.util.ReadUtil;

public class ExamServerImp implements ExamServer {
	private EntityContext entityContext;
	ArrayList<QuestionInfo> examQuestions;

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	@Override
	public User login(String id, String password) throws IdPassException {
		HashMap<String, User> users = entityContext.getUsers();
		User user = users.get(id);
		if (user == null) {
			throw new IdPassException("用户不存在");
		}
		if (!user.getPassword().equals(password)) {
			throw new IdPassException("密码错误");
		}
		return user;
	}

	public ExamInfo start() {
		ExamInfo examInfo = new ExamInfo();
		examInfo.setTitle(ReadUtil.getMessage("examtitle"));
		examInfo.setTimeLimit(Integer.parseInt(ReadUtil.getMessage("timelimit")));
		examInfo.setTotalNumbers(this.getExamQuestions().size());
		return examInfo;
	}

	@Override
	public ArrayList<QuestionInfo> getExamQuestions() {
		int index = 0;
		Random random = new Random();
		examQuestions = new ArrayList<QuestionInfo>();
		HashMap<Integer, ArrayList<Question>> questions = entityContext.getQuestions();
		for (int key = 1; key <= 10; key++) {
			ArrayList<Question> levelQuestions = new ArrayList<Question>(questions.get(key));
			// 随机添加2个等级相同的题目
			Question question1 = levelQuestions.remove(random.nextInt(levelQuestions.size()));
			examQuestions.add(new QuestionInfo(question1, index++));
			Question question2 = levelQuestions.remove(random.nextInt(levelQuestions.size()));
			examQuestions.add(new QuestionInfo(question2, index++));
		}
		return examQuestions;
	}

	@Override
	public QuestionInfo getQuestionInfo(int index) {
		QuestionInfo questioninfo = this.examQuestions.get(index);
		return questioninfo;
	}

	@Override
	public int getTotalScore() {
		int totalScore = 0;
		for (QuestionInfo questionInfo : examQuestions) {
			ArrayList<Integer> Answer = questionInfo.getQuestion().getAnswers();
			ArrayList<Integer> userAnswer = questionInfo.getUserAnswer();
			if (Answer.equals(userAnswer)) {
				totalScore += questionInfo.getQuestion().getScore();
			}
		}
		return totalScore;
	}

	@Override
	public void saveUserAnswers(int page, ArrayList<Integer> userAnswers) {
		QuestionInfo questioninfo = this.examQuestions.get(page);
		questioninfo.getUserAnswer().clear();
		questioninfo.setUserAnswer(userAnswers);
	}
}
