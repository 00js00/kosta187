import java.util.HashMap;
import java.util.Map;

/**
 * 동적 객체 정의
 * @author 서지원
 *
 */
public class Student {
	Map<String, Object> prop; //key : 인스턴스 변수 이름// Object : 동적으로 데이터타입 변하게 하고 싶어서 
	
	public Student() {
//		super();
		prop = new HashMap<String,Object>()	;
	}
//	public Student(Map<String, Object> prop) {
//		super();
//		this.prop = prop;
//	} 갯수 이런거 상관 없으니까 생략

	public Map<String, Object> getProp() {
		return prop;
	}

	public void setProp(Map<String, Object> prop) {
		this.prop = prop;
	}

	public void setProperty(String key, Object value) {
		prop.put(key, value);
	}

	public Object getProperty(String key, Object value) {
		return prop.get(key);
	}	
	
	public static void main(String[] args) {
		Student student = new Student();
		student.setProperty("ssn","87544");
		student.setProperty("name","김기정");
		
		
	}
}
