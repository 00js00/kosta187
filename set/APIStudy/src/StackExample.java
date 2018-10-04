import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class StackExample {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>(); //앞에서만 선언해주면 뒤에는 <> 사용안해도됨
	 	stack.push("AAA");
	 	stack.push("CCC");
	 	stack.push("BBB");
	 	System.out.println(stack.size());
	 	System.out.println(stack.pop())	; //맨 위에꺼 제거 : 뭐 제거하는지 프린트됨
	 	System.out.println(stack.size());
		System.out.println(stack.peek()); //맨위에꺼 read됨
	}

}
