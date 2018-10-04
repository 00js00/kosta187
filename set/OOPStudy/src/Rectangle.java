
public class Rectangle extends Shape {
	private double width, height;

	public Rectangle() {
//	super();
		this(0, 0, 0, 0);
	}

	public Rectangle(double x, double y, double width, double height) {
//		super(x, y);
		this.x =x;
		this.y=y;
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println(x+","+y+","+width+","+height +"의 사각형 입니다.."); //x못가져오는거 주의
	}
	@Override
	public double getArea() {
		return width*height;
	}
	@Override
	public double getLength() {
		return 2*(width + height);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", x=" + x + ", y=" + y
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
