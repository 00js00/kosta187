/**
 * LIFO 구조의 스택 구현
 * 
 * @author 서지원
 *
 */
public class Stack {
	private int[] array;
	private int count = 0;
	
	// 기본 생성자 : default : 10
	public Stack() {
		this(10);
	}
	
	/**
	 * 생성자 : Stack size를 받는 생성자 
	 * @param Stack의 크기
	 */
	public Stack(int value) {
		array = new int[value];
	}

	//Setter, Getter 생성
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	

	/**
	 * Stack에 값을 넣는 것
	 * @param 들어가는 값
	 */
	public void push(int value) {
		array[count] = value;
		count++;
	}

	/**
	 * Stack안에 있는 값을 뺌
	 * @return
	 */
	public int pop() {
		int temp = array[count - 1];
		array[count - 1] = 0;
		count--;
		return temp;
	}

	/**
	 * 처리 후 Stack안의 값의 갯수
	 * @return
	 */
	public int length() {
		return count;

	}

//실험
	public static void main(String[] args) {
		//Stack 생성
		Stack stack = new Stack();
		// 값 넣기
		stack.push(5);
		stack.push(1);
		stack.push(9);
		// 값 빼기
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		// Stack안의 값의 갯수 확인
		System.out.println(stack.length());
	}
}
