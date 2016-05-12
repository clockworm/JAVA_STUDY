package day21;

import static java.lang.Math.PI;
import static java.util.Calendar.getInstance;

import java.util.Calendar;

public class staticImport {
	public static void main(String[] args) {
		System.out.println(PI);
		Calendar c = getInstance();
		System.out.println(c.get(Calendar.YEAR));
	}
}
