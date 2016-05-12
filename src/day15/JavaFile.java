package day15;

import java.io.File;
import java.io.IOException;

//目录的操作
public class JavaFile {
	public static void main(String[] args) {
		String path = "E:\\开发工具\\git使用.txt";
		File file1 = new File(path);
		System.out.println(file1.exists());// 是否存在
		// System.out.println(file1.getAbsolutePath()); // 该对象绝对路径
		System.out.println(file1.getPath());// 该对象绝对路径
		System.out.println(file1.getParent()); // 该对象上级路径
		System.out.println(file1.getParentFile().getAbsolutePath()); // 该对象上级对象的绝对路径
		// 文件
		File file2 = new File(file1.getParentFile(), "A.txt");
		System.out.println(file2.isFile()); // 是否是一个文件
		if (!file2.exists()) {
			try {
				file2.createNewFile(); // 创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(file2.getName());
			System.out.println(file2.getPath());
			file2.delete();
		}
		// 目录
		File file3 = new File(file2.getParentFile(), "A目录"); // file2该对象上级路径
		System.out.println(file3.isDirectory()); // 是否是一个目录
		if (!file3.exists()) {
			try {
				// file3.mkdir(); // 创建目录
				file3.mkdirs();// 创建目录 蝴蝶效应，全部创建不存在的目录包括上级目录
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(file3.getName());
			System.out.println(file3.getPath());
			file3.delete();
		}
	}
}
