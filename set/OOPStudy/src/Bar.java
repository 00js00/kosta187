public class Bar {
	
	@Deprecated
	public void some() {
		System.out.println("썸타요.."); // 사람에겐 주석, 컴파일러에겐 제한
	}
	
	@Override
	public String toString() {
		//System.out.println("이노테이션 테스트");
		return "";
	}
	
	public static void main(String[] args) {
		Bar bar = new Bar();
		bar.some();
	}
}
