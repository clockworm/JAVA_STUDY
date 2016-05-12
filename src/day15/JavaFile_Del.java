package day15;

import java.io.File;

//java中删除文件目录 必须为空文件夹 所以先刪除文件才能刪除文件夾
public class JavaFile_Del {
	public static void main(String[] args) {
		deleteFile_Dir(new File("D:\\JAVA"));
	}

	private static void deleteFile_Dir(File file) {
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.isFile()) {
				System.out.println(file2.getAbsolutePath());
				file2.delete();
			} else {
				deleteFile_Dir(file2);
			}
		}
		// 最后删除自己
		file.delete();
	}
}
