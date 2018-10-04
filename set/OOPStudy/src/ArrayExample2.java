/**
 * 다차원배열 테스트
 * @author 서지원
 *
 */
public class ArrayExample2 {

	public static void main(String[] args) {
		char[][] array ;
		array = new char[10][10];
		array[0][0] = 'A';
		array[9][9] = 'Z';
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
//		int[][] array2 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] array2 = {{1,2,3},{4,5,6},{7,8,9}};
		
		//구구단 만들기
		int[][] gugudan = new int[8][9];
		for (int i = 0; i < gugudan.length; i++) {
			for (int j = 0; j < gugudan[i].length; j++) {
				gugudan[i][j] = (i+2) * (j+1);
				System.out.print( (i+2) +"*" + (j+1) +"=" + gugudan[i][j] + "\t");		
							}
			System.out.println();
		}
	}

}

/**
 * 과제
 * 데이터 구조화 = 지역변수 할당영역(stack)을 하나 만드는것 : class로 만들 것
 */

