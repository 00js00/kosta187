/**
 * 1차원 배열 선언, 생성, 초기화
 * @author 서지원
 *
 */
public class ArrayExample {

	public static void main(String[] args) {
		int[] array ;
		array = new int[10];
		array[0] = 10; 
		array[9]=100;
//		System.out.println(array[0]);
//		System.out.println(array[9]);
		for(int i = 0; i<array.length ; i++) {
			System.out.print(array[i] + "\t");
		}
//		int[] array2 = new int[] {1,2,3,4,5};
		int[] array2 = {1,2,3,4,5};
		
		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		
		for( int value : array2) {
			System.out.println(value);
		} // 버전5부터 생겨난 기능 - 더 빠름
		
		//미션 1 (배열복사)
		int[] array3 = {3,1,9,2,5};
		int[] array4 = new int[7];			//int[array3 + 2]; 	
		for (int i = 0; i < array3.length; i++) {
			array4[i] = array3[i];
		}
		for (int i : array4) {
			System.out.println(i);
		}
	
		//미션 2 (정렬)
		int[] lottos = {34,12,3,9,25,2};
		//정렬 코드 
		for(int j = 1; j <lottos.length ; j++) {
			for(int i=0; i<lottos.length-j; i++ ) {
				if (lottos[i]> lottos[i+1]) {
					int temp = lottos[i+1];
					lottos[i+1] = lottos[i]; 	
					lottos[i] = temp;
				} 
		}
		}
		
		for (int i : lottos) {
			System.out.print(i + "\t");
		}
	}

}
