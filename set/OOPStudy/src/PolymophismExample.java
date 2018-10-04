
public class PolymophismExample {

	public static void main(String[] args) {
		// 클래스 형변환( Up Casting)
		Shape shape = null;
//		shape = new Shape();
		

		shape = new Circle(10, 10, 10);
		System.out.println(shape);

		shape = new Rectangle(10, 10, 50, 20);
		System.out.println(shape);

		System.out.println(shape.x);
//		System.out.println(shape.getWeigh()); // 못찾음(hidden)
		System.out.println(shape.getArea()); // overriding은 할 수 있음

		// 추가된 속성이나 메소드를 접근하기 위해 down casting 필요
		// 하위부분을 나타내는 변수 선언 하면 됨
		
		Rectangle rectangle = (Rectangle)shape;
		System.out.println(rectangle.getWidth());

		System.out.println(shape instanceof Object);
		System.out.println(shape instanceof Shape);
		System.out.println(shape instanceof Rectangle);
		System.out.println(shape instanceof Circle);
	}

}
