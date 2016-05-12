package day23.examsystem.net;

/**
 * 客户端  代理模式   发送请求和接收响应     請求和響應都要包裝廠對象
 */
import java.util.ArrayList;
import day22.examSystem.entity.ExamInfo;
import day22.examSystem.entity.QuestionInfo;
import day22.examSystem.entity.Request;
import day22.examSystem.entity.Response;
import day22.examSystem.entity.User;
import day22.examSystem.exception.IdPassException;
import day22.examSystem.server.ExamServer;

public class ExamServerProxy implements ExamServer {
	private Request request;
	private Response response;
	private String session;

	@Override
	public User login(String id, String password) throws IdPassException {
		request = new Request(new Object[] { id, password }, new Class[] { String.class, String.class }, "login");
		response = SocketUtil.remoteAll(request);
		if (!response.isSucces())
			throw new IdPassException(response.getException().getMessage());
		Object obj = response.getObject();
		this.session = response.getSession();
		return (User) obj;
	}

	@Override
	public ExamInfo start() {
		request = new Request(new Object[] {}, new Class[] {}, "start");
		request.setSession(session);
		response = SocketUtil.remoteAll(request);
		if (!response.isSucces()) {
			throw new RuntimeException(response.getException().getMessage());
		}
		ExamInfo examInfo = (ExamInfo) response.getObject();
		return examInfo;
	}

	@Override
	public ArrayList<QuestionInfo> getExamQuestions() {
		request = new Request(null, null, "getExamQuestions");
		request.setSession(session);
		response = SocketUtil.remoteAll(request);
		if (!response.isSucces()) {
			throw new RuntimeException(response.getException().getMessage());
		}
		ArrayList<QuestionInfo> questionInfos = (ArrayList<QuestionInfo>) response.getObject();
		return questionInfos;
	}

	@Override
	public QuestionInfo getQuestionInfo(int index) {
		request = new Request(new Object[] { index }, new Class[] { int.class }, "getQuestionInfo");
		request.setSession(session);
		response = SocketUtil.remoteAll(request);
		if (!response.isSucces()) {
			throw new RuntimeException(response.getException().getMessage());
		}
		QuestionInfo questionInfo = (QuestionInfo) response.getObject();
		return questionInfo;
	}

	@Override
	public int getTotalScore() {
		request = new Request(null, null, "getTotalScore");
		request.setSession(session);
		response = SocketUtil.remoteAll(request);
		if (!response.isSucces()) {
			throw new RuntimeException(response.getException().getMessage());
		}
		Integer totalScore = (Integer) response.getObject();
		return totalScore.intValue();
	}

	@Override
	public void saveUserAnswers(int page, ArrayList<Integer> userAnswers) {
		request = new Request(new Object[] { page, userAnswers }, new Class[] { int.class, userAnswers.getClass() },
				"saveUserAnswers");
		request.setSession(session);
		response = SocketUtil.remoteAll(request);
		if (!response.isSucces()) {
			throw new RuntimeException(response.getException().getMessage());
		}
	}

}
