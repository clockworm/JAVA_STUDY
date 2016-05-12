package day15;

import java.io.File;

//遍历某个目录下的全部文件
public class JavaFile_Test {
	public static void main(String[] args) {
		String str = "E:\\JAVA";
		File file = new File(str);
		getAll_Files(file);
	}

	public static void getAll_Files(File file) {
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.isFile()) {
				System.out.println("     " + file2.getName());
			} else {
				getAll_Files(file2);
			}
		}
	}
}
