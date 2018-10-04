
public class InheritanceExample {
	public static void main(String[] ergs) {
		Bicycle bicycle;
		bicycle = new Bicycle (10, "삼천리");
		
		System.out.println(bicycle.brand);
		bicycle.running();
		
		
		MountatinBicycle mountatinBicycle = new MountatinBicycle(10,"삼천포","카본",true);
		//부모로부터 재사용
		System.out.println(mountatinBicycle.id);
		System.out.println(mountatinBicycle.brand);
		mountatinBicycle.running(); //재정의
		// 확장
		System.out.println(mountatinBicycle.frame);
		System.out.println(mountatinBicycle.suspension);
		
		
	}
}
