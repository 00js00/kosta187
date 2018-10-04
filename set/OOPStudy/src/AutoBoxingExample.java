
public class AutoBoxingExample {

	public static void main(String[] args) {
		Double obj = 78.56;
		System.out.println(obj); // overriding 
		
//		double value = new Double(169.45); 언박싱
		double value = new Double(169.45).doubleValue(); 

		
	}

}
