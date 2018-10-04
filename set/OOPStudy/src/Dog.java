
public class Dog extends Animal {

	private boolean loyalty;
	
	public Dog() {
		this(null,0,false);
	}
	
	public Dog(String name, int age, boolean loyalty) {
		this.name = name;
		this.age = age;
		this.loyalty = loyalty;
	}
	
	@Override
	public void sleep() {
		System.out.println("강아지가 주무십니다..");
	}

	@Override
	public void eat() {
		System.out.println("강아지가 먹습니다..");

	}
	public static void main(String[] args) {
		Animal animal = null; //type선언 가능
		animal = new Dog("루니",2, false);
		animal.println();
		animal.eat(); // 추상클래스 안의 메소드 불러올 수 있음
		animal.sleep();
	}
}
