public class SystemExample {

	public static void main(String[] args) {
		System.out.println("프로그램 start");

		
		//System.exit(0);
		System.gc();
		
		long start = System.currentTimeMillis();
	/*	
		for (int i = 0; i < 1000000000; i++) {			
		}*/
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println(System.getenv("path"));
		System.out.println(System.getenv("java_home"));
		
		System.out.println("프로그램 finish");
	}

}
