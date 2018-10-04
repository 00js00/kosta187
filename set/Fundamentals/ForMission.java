class ForMission {
	public static void main(String[] args) {
		
for( int i = 0 ; i < 5 ; i++){
	for( int j = 0  ; j <=i ; j++ ){
	System.out.print("*");
	}
System.out.println();
}
System.out.println("\n");

for ( int q = 5 ; q >= 0  ; q-- ){
	for ( int w = 0; w < q ; w++ ){
					System.out.print("*");
	}
				System.out.println();
}
		System.out.println("\n");

for( int t = 5 ; t >  0 ; t--){
	for( int y = 0  ; y <= 6 ; y++ ){
		if (y <=t){
			System.out.print(" ");
		} else {
			System.out.print("*");
		}
	}
System.out.println();
}
System.out.println("\n");

for( int e = 0 ; e <= 6 ; e++){
	for( int r = 0  ; r <6 ; r++ ){
		if (r <= e){
			System.out.print(" ");
		} else {
			System.out.print("*");
		}
	}
System.out.println();
}
System.out.println("\n");




for(int a = 1; a <= 9 ;a++ ){
	for(int s = 1;s <= 9; s++){
			System.out.print(a + "*" + s + "=" + (a * s) +"\t");
	}
System.out.println("\n");

}




for (int d = 0; d < 5 ; d++){
	for(int f= 0 ;f <= 9; f+=2){
		System.out.print("*");

	}
System.out.println();

}
System.out.println("\n");





	}
}
