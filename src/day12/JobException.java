//模拟用户在操作软件时可能出现的不同错误，并对这些错误进行统一的友好提示
package day12;

public class JobException {
	public static void main(String[] args) throws Exception {
		JobException jb = new JobException();
		jb.add("3", "2");
		try {
			jb.setName("张三王22");
			System.out.println(jb.getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private String name;

	public void setName(String name) throws NameLengthException {
		if (name.length() >= 4 || name.length() <= 0)
			throw new NameLengthException("名字长度错误");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void add(String a, String b) throws Exception {
		try {
			int i = Integer.parseInt(a) + Integer.parseInt(b);
			System.out.println(i);
		} catch (Exception e) {
			System.out.println("输入数字错误");
		}
	}
}

@SuppressWarnings("serial")
class NameLengthException extends Exception {
	public NameLengthException(String message) {
		super(message);
		// System.out.println(message);
	}
}
