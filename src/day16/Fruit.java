package day16;

abstract class Fruit {
	private String name;

	public abstract void grow();

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "name=" + name;
	}

}
