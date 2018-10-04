
public class MountatinBicycle extends Bicycle {
	//추가 속성
	String frame;
	boolean suspension;
	
	public MountatinBicycle() {
		this(null,false);
	}
	public MountatinBicycle(String frame, boolean suspension) {
		this.frame = frame;
		this.suspension = suspension;
	}

	public MountatinBicycle(int id, String brand,String frame, boolean suspension) {
//중복코드this.id = id;
//		this.brand = brand;
		super(id,brand);
		this.frame = frame;
		this.suspension = suspension;
	}
//	물려받은 것을 재정의하고싶을 때 : overriding
	public void running() {
		System.out.println("산도 달립니다..");
	}
	
}
