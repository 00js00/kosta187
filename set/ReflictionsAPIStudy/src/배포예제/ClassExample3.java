package 배포예제;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * Class를 이용하여 동적 객체(인스턴스) 생성
 * 
 * @author 김기정
 *
 */
public class ClassExample3 {

	public static void main(String[] args) {
//		String className = "java.lang.String";
		
		Object object = null;		
		try {
//			Class cls = Class.forName(className);
			Class cls = String.class; // 호출방법 바꿈 - String 객체가 생성된거는 아님
			
			// 매개변수 있는 생성자 호출
			Constructor constructor = cls.getConstructor(String.class); // 여기서 매개변수 타입을 설정하는 것  : 매개 변수 여러개면 "," 로 생성
			object = constructor.newInstance("동적객체생성"); // 동적 객체 생성하나ㅡㄴ 두번째 방법
			System.out.println(object instanceof String);
			System.out.println(((String)object).length()); // 다운캐스팅
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
