package day16;

//主要用于文件更新升级 解耦  每次版本都不需要重新发布 只需要动态加载即可
import java.io.IOException;
import java.util.Properties;

public class FruitFactory {
	private static Properties pro = new Properties();
	static {
		try {
			pro.load(pro.getClass().getResourceAsStream("/day16/test2.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//创建和使用者分离
	public static Fruit getInitialize() {
		try {
			Class fruit = Class.forName(pro.getProperty("fruit"));
			return (Fruit) fruit.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
