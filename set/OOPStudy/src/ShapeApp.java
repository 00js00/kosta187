
public class ShapeApp {
	public static void main(String[] args) {
//		 user 관계
//		Shape shape = new Shape(12.5 , 35.7);
		//Shape shape = null;
//		shape.draw();
		
		Circle circle = new Circle(15.0,15.0,30);
		circle.draw();
		System.out.println("원의 둘레 : "+circle.getLength());
		System.out.println("원의 면적 : "+circle.getArea());
		
		Rectangle rectangle = new Rectangle(2,4,5,100);
		rectangle.draw();
		System.out.println("사각형의 둘레 :" + rectangle.getLength());
		System.out.println("사각형의 면적 :" + rectangle.getArea());
		
		////////////////////////////////////////////////////////////////////
		System.out.println(circle);
//		System.out.println(shape.toString()); // 주소가 나옴 //
		
		String str = "Java Programming";
		System.out.println(str/*.toString()*/); //왜 주소 안나옴 ? -> overriding 된 것이라고 생각하면 됨
		////////////////////////////////////////////////////////////////////
	}

}
