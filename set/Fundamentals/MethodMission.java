class MethodMission {


	static void printGugudan(int x){

		for (int i = 1; i <= 9 ; i++ ){
			for (int j =2 ; j<=x ;j++ )	{
				System.out.print(j+"*"+i+ "="+ (j*i) + "    ");
			}
		System.out.println();
		}
	}



	
	
	public static void main(String[] args) {
int x = 7;
printGugudan(x);
	
	
	
	}
}

