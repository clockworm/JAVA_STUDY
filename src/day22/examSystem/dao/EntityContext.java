package day22.examSystem.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import day22.examSystem.entity.Question;
import day22.examSystem.entity.User;
import day22.examSystem.util.IOUtil;
import day22.examSystem.util.ReadUtil;

public class EntityContext {
	private HashMap<String, User> users = new HashMap<String, User>();
	private HashMap<Integer, ArrayList<Question>> questions = new HashMap<Integer, ArrayList<Question>>();

	public EntityContext() {
		loadUser();
		loadQuestion();
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public HashMap<Integer, ArrayList<Question>> getQuestions() {
		return questions;
	}

	/**
	 * 加载用户信息
	 */
	private void loadUser() {
		try {
			BufferedReader in = IOUtil.getBuffered(ReadUtil.getMessage("userpath"));
			String str = null;
			while ((str = in.readLine()) != null) {
				if (str.startsWith("#"))
					continue;
				String[] usermessage = str.split(":");
				User user = new User(usermessage[0], usermessage[1], usermessage[2], usermessage[3]);
				users.put(user.getId(), user);
			}
			IOUtil.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载所有题目
	 * 
	 * @return
	 */
	private void loadQuestion() {
		BufferedReader in = IOUtil.getBuffered(ReadUtil.getMessage("questionpath"));
		try {
			String row = null;
			while ((row = in.readLine()) != null) {
				Question questionSingle = parseQuestion(in, row);
				putQuestion(questionSingle);
			}
			IOUtil.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析所有题目
	 * 
	 * @param question
	 */
	private void putQuestion(Question question) {
		int level = question.getLevel();
		if (!questions.containsKey(level)) {
			ArrayList<Question> levelQuestions = new ArrayList<Question>();
			levelQuestions.add(question);
			questions.put(level, levelQuestions);
		} else {
			questions.get(level).add(question);
		}
	}

	/**
	 * 解析一个题目
	 * 
	 * @param in
	 * @param question
	 * @param row
	 * @return
	 * @throws IOException
	 */
	public Question parseQuestion(BufferedReader br, String row) throws IOException {
		Question question = new Question();
		String regex = "[@,][a-z]+=";
		String[] messages = row.split(regex);
		question.setScore(Integer.parseInt(messages[2]));
		question.setLevel(Integer.parseInt(messages[3]));
		question.setAnswers(getAnswer(messages[1]));
		String title = br.readLine();
		question.setTitle(title);
		question.setOptions(getOptions(br));
		return question;
	}

	/**
	 * 解析题目选项
	 * 
	 * @param in
	 * @return
	 * @throws IOException 
	 */
	private ArrayList<String> getOptions(BufferedReader in){
		ArrayList<String> options = new ArrayList<String>();
		try {
			for (int i = 0; i <4; i++) {
				options.add(in.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return options;
	}

	/**
	 * 解析题目答案
	 * 
	 * @param ans
	 * @return
	 */
	private ArrayList<Integer> getAnswer(String ans) {
		String[] as = ans.split("/");
		ArrayList<Integer> answers = new ArrayList<Integer>();
		for (String answer : as) {
			answers.add(Integer.parseInt(answer));
		}
		return answers;
	}
}
