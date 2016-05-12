package day16;

//浅拷贝测试 拷貝一個對象	
//深拷贝 原型模式  （不知道是JDK版本问题还是怎么 深拷贝的对象的内属性对象拷贝不成功）
public class Clone_Test {

	public static void main(String[] args) {
		CopyClass_Clonable clas = new CopyClass_Clonable();
		clas.getApple();
		try {
			CopyClass_Clonable clas1 = (CopyClass_Clonable) clas.clone();
			System.out.println(clas.equals(clas1));// false
			System.out.println(clas.getApple() == clas1.getApple());// true
			
			CopyClass_Clonable clas2 = (CopyClass_Clonable) clas.deepClone();
			System.out.println(clas2 == clas);
			System.out.println(clas2.getApple() == clas.getApple()); 
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
