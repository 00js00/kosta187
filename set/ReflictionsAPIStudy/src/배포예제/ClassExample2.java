package 배포예제;

import java.util.Vector;

/**
 * Class를 이용하여 동적 객체(인스턴스) 생성
 * 
 * @author 김기정
 *
 */
public class ClassExample2 {

	public static void main(String[] args) {
		String className = "java.util.Vector"; //동적생성의 시발점
		
		Object object = null;		
		try {
			Class cls = Class.forName(className);
			// 디폴트생성자 호출
			object = cls.newInstance(); // return type이 object 로 생김 - vector 로 생성
			System.out.println(object instanceof Vector);
			
			// 필요에 따라 Down Casting
			Vector vector = (Vector)object; // 다운케스팅해서 사용
			vector.addElement("동적 객체 생성");
			System.out.println(vector.elementAt(0));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
