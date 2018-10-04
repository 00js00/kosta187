public class Calculater {
	
	//메소드 오버로딩(중복정의)
	public static int sum(int x, int y) {
		return x + y ;
	}
	public static double sum(double x, double y) {
		return x + y ;
	}
	public static void main(String[] args) {
	System.out.println((Calculater.sum(10, 20)));  
	System.out.println(sum(30,20));
	System.out.println(sum(1.3,5));
	
		
	
	}
	
}
