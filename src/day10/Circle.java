package day10;

public class Circle extends Shape {
	private double r;

	public Circle(Point p, double r) {
		super(p);
		this.r = r;
	}

	public Circle(double x, double y, double r) {
		this(new Point(x, y), r);
	}

	@Override
	public double getArea() {
		return r * r * 3.14;
	}

	@Override
	public double getLength() {
		return 2 * r * 3.14;
	}

	public boolean isContain(Point p) {
		return (this.getLocation().getDistance(p)) <= r;
	}

	public boolean isContain(double x, double y) {
		return (this.getLocation().getDistance(x, y)) <= r;
	}

}
