
public class OuterClass {
	
	enum Direction {
		A,B,C
	}
	
	class InnerClass {
		public void foo() {
			System.out.println("foo 호출함..");
		}
	}
// foo 는 호출할 때 outerclass부르고 호출할 수 잇음
	static class SInnerClass {
		public void bar() {
			System.out.println("bar 호출함..");
		}
//	bar는 static이기 때문에 바로 호출할 수 잇음

	}
}
