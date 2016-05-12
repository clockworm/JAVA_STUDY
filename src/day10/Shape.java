package day10;
//不能和private组合使用   不能和final组合使用
public abstract class Shape { 
	private Point location;

	public abstract double getArea();

	public abstract double getLength();

	public Shape(Point location) {
		this.location = location;
	}

	public Shape(double x, double y) {
		this(new Point(x, y));
	}

	public void printLocation() {
		System.out.println("x的坐标：" + getLocation().getX() + "，y的坐标" + getLocation().getY());
	}

	public Point getLocation() {
		return location;
	}
}
