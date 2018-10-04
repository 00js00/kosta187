import java.util.LinkedList;
import java.util.Stack;

public class QueueExample {
	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<>(); //앞에서만 선언해주면 뒤에는 <> 사용안해도됨
		queue.offer("AAA");
		queue.offer("BBB");
		queue.offer("CCC");
		
		System.out.println(queue.peek()); //제거안하면서 가져오기
		System.out.println(queue.poll()); // 제거하면서 가져오기
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek()); //제거안하면서 가져오기
	}

}
