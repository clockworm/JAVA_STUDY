package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

public class StudentIO {
	public static void main(String[] args) {
		getStudent();
	}

	public static void getStudent() {
		String path = "D:\\JAVA_STUDY\\WorkSpace\\JAVA\\src\\day17\\student.txt";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		TreeSet<Student> stuset = new TreeSet<Student>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String str = null;
			while ((str = in.readLine()) != null) {
				String[] student = str.split(",");
				Student stu = new Student(Integer.parseInt(student[0]), student[1], Integer.parseInt(student[2]));
				stuset.add(stu);
				if (map.containsKey(student[1])) {
					map.put(student[1], map.get(student[1]) + 1);
				} else {
					map.put(student[1], 1);
				}
			}
			in.close();
			System.out.println(map);
			System.out.println(stuset);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
