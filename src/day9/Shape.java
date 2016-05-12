package day9;

public class Shape {
	private Point location;

	public Shape(Point location) {
		this.location = location;
	}

	public Shape(double x, double y) {
		this(new Point(x, y));
	}

	public double getArea() {
		return 0;
	}

	public double getLength() {
		return 0;
	}

	public void printLocation() {
		System.out.println("x的坐标：" + getLocation().getX() + "，y的坐标" + getLocation().getY());
	}

	public Point getLocation() {
		return location;
	}
}
