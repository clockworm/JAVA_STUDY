package day16;

import java.io.Serializable;

class Apple extends Fruit implements  Serializable {
	@Override
	public void grow() {
		System.out.println("苹果在成长");
	}
}