package day15;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

//遍历某个目录下的全部文件
public class JavaFile_Filter {
	public static void main(String[] args) {
		String str = "E:\\JAVA";
		File file = new File(str);
		getAll_Files(file);
		// 过滤
		getFlie_Filter(file);
		print();
		getFlie_Filter2(file);
	}

	// 指定遍历某种对象格式 会过滤掉目录 所以不会递归调用了 处理方式详见getFlie_Filter方法
	public static void getAll_Files(File file) {
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".class"); // 只显示除了.class的文件遍历会失效只會在當機目錄遍歷
			}
		});
		for (File file2 : files) {
			if (file2.isFile()) {
				// System.out.println(" " + file2.getName());
			} else {
				getAll_Files(file2);
			}
		}
	}

	// 过滤某种格式的文件 过滤方式1
	public static void getFlie_Filter(File file) {
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory()) {
					getFlie_Filter(pathname);
				} else if (pathname.getName().endsWith(".java")) {
					return true;
				}
				return false;
			}
		});
		for (File file2 : files) {
			System.out.println(file2.getAbsolutePath());
		}
	}

	// 过滤某种格式的文件 过滤方式2 //需要重新构造File
	public static void getFlie_Filter2(File file) {
		File[] files = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				File file = new File(dir, name);
				if (file.isDirectory()) {
					getFlie_Filter2(file);
				} else if (file.isFile() && file.getName().endsWith(".java")) {
					return true;
				}
				return false;
			}
		});
		for (File file2 : files) {
			System.out.println(file2.getAbsolutePath());
		}
	}

	public static void print() {
		System.out.println();
		System.out.println("====================华丽分割线====================");
	}

}
