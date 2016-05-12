package day16;

public class Properties_Case {

	public static void main(String[] args) {
		Fruit fruit = FruitFactory.getInitialize();
		fruit.setName("红苹果");
		System.out.println(fruit.getName());
		fruit.grow();
	}

}


