/**
 * 배열 관련한 공통 기능 정의
 * 
 * @author 서지원
 *
 */
public class ArrayUtil {

	/**
	 * alt + shift + j 배열 복사
	 * 
	 * @param src        복사하고자 하는 원본배열
	 * @param increament 증가치
	 * @return 복사된 배열
	 */
	public static int[] copy(int[] src, int increament) {
		int[] array = new int[src.length + increament]; // int[array3 + 2];
		for (int i = 0; i < src.length; i++) {
			array[i] = src[i];
		}
		return array;
	}

	/**
	 * 배열 오름차순정렬 alt shift r : 이름 전체 바꾸기
	 * ctrl shift f : 들여쓰기 
	 * @param src 원본배열 
	 *
	 */
	public static void sort(int[] src) {
		for (int j = 1; j < src.length; j++) {
			for (int i = 0; i < src.length - j; i++) {
				if (src[i] > src[i + 1]) {
					int temp = src[i + 1];
					src[i + 1] = src[i];
					src[i] = temp;
				}
			}
		}

	}

//	해보기
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 9, 7 };
		int[] copy = ArrayUtil.copy(array, 4);
		for (int i : copy) {
			System.out.print(i + "\t");
		}
		System.out.println();
		ArrayUtil.sort(array);
		for (int i : array) {
			System.out.print(i + "\t");
		}
	}


}
//call by value 기본데이터 타입에서 불러옴
//call by reference  객체에서 가져옴 