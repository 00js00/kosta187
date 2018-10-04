
public class VarargExample {
	public static int sum (int[] arg) { //예전
		int result = 0;
		for (int i : arg) {
			result += i;
		}
		return result;
		
	}
	
	public static int summ(int ...arg ) { //5이상 --> 오버로딩 되는것 아님
		int result = 0;
		for (int i : arg) {
			result += i;
		}
		return result;
		
	}
	public static void main(String[] args) {
//		sum([10,20]);//변수처리없이 바로 인자로 변경 안됨
//		int[] values= {10,20};
//		System.out.println(sum(values));
//		
		System.out.println(summ(10));
		System.out.println(summ(10,20));
		System.out.println(summ(10,30,50));
		System.out.println(summ(10,20,30,40));
		
	}

}
