
public class Bicycle /* extends Object*/ {
	int id;
	String brand;
	
	public Bicycle() {
//		super(); //명시적으로 적혀있지 않아도 자동 생성됨 : 부모클래스 default 생성자
		this(0,null);
	}
// 만약 Bicycle에서 디폴트 생성자 없으면 , super();로 불러올 생성자가 없으므로 에러남 .
	public Bicycle(int id, String brand) {
//		super(); // object에는 
		this.id = id;
		this.brand = brand;
	}
	
	public void running() {
		System.out.println("자전거가 달립니다..");
	}
	
	
}
