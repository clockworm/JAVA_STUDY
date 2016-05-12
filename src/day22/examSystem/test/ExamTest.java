package day22.examSystem.test;

import day22.examSystem.control.ClientContext;
import day22.examSystem.ui.ExamFrame;
import day22.examSystem.ui.LoginFrame;
import day22.examSystem.ui.MenuFrame;
import day23.examsystem.net.ExamServerProxy;

public class ExamTest {
	public static void main(String[] args) {
		ClientContext clientContext = new ClientContext();
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ExamFrame examFrame = new ExamFrame();
		menuFrame.setClientContext(clientContext);
		examFrame.setClientContext(clientContext);
		loginFrame.setClientContext(clientContext);
		ExamServerProxy proxy = new ExamServerProxy();
		// imp.setEntityContext(entity);
		// 设置之间的依赖
		clientContext.setExamFrame(examFrame);
		clientContext.setMenuFrame(menuFrame);
		clientContext.setLoginFrame(loginFrame);
		clientContext.setExamServer(proxy);
		loginFrame.setVisible(true);

	}
}
