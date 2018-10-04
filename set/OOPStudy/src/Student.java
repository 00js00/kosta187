/**
 * 제너릭클래스
 * 
 * @author 서지원
 *
 */
public class Student<T> {
	private String name;
	private T ssn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getSsn() { //class이름처럼 되는 것 볼 수 있음
	}

	public void setSsn(T ssn) {
		this.ssn = ssn;
	}

	public Student(String name, T ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}

	public Student() {
		super();
	}

	public static void main(String[] args) {
		Student<Integer> student = new Student<Integer>("김기정",123456);
		student.setSsn(345566);

	}
}
