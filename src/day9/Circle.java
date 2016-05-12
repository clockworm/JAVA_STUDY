package day9;

public class Circle extends Shape {
	private double r;

	public Circle(Point location, double r) {
		super(location);
		this.r = r;
	}

	public Circle(double x, double y, double r) {
		this(new Point(x, y), r);
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getArea() {
		return 3.14 * r * r;
	}

	public double getLength() {
		return 3.14 * 2 * r;
	}

	public boolean isContain(Point p) {
		return (this.getLocation().getDistance(p)) <= r;
	}

	public boolean isContain(double x, double y) {
		return (this.getLocation().getDistance(x, y)) <= r;
	}
}
