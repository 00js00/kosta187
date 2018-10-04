class MethodExample {

static void printMessage(String name, String message){
	System.out.println("["+name+"] : " + message);
}

static int sum(int x, int y, int z){
return x + y + z ; 
}
	
	public static void main(String[] args) {
		//여기서 진짜 기능을 하는 애들은 void 랑 sum 임


		String name = "김기정";
		String message = "조금 쉬었다 해요";
		printMessage(name,message);


		int result = sum( 50 , 29 , 19);
		System.out.println(result);
		System.out.println(sum( 50 , 29 , 19));

		//호출하고 결과받고 결과를 print해야함
	}
}
