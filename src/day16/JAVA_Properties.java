package day16;

//資源文件使用  设计中可以用来解耦性
import java.io.IOException;
import java.util.Properties;

public class JAVA_Properties {

	public static void main(String[] args) {
		Properties pro = new Properties();
		try {
			/*
			 * pro.load(new FileInputStream("D:\\JAVA_STUDY\\WorkSpace\\JAVA\\src\\day16\\test2.properties"));
			 */
			pro.load(pro.getClass().getResourceAsStream("/day16/test2.properties")); // 加载資源文件
			// for (Object obj : pro.keySet()) {
			// System.out.println(obj + "=" + pro.get(obj));
			// }
			System.out.println(pro.getProperty("a"));
			System.out.println(pro.getProperty("b"));
			System.out.println(pro.getProperty("c"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
