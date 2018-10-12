import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 순서를 통해 데이터를 관리하기 위한 규약(인터페이스)이다.
 * Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가진다.
 * ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스이다
 * 
 * @author 서지원
 *
 */
public class ListExample {

	public static void main(String[] args) {
		List list = null;  // Set 을 List로 바꿨는데 밑에 있는것들 자동으로 동기화됨 -- 호환 : 결과는 다르게 나옴
		list = new ArrayList(10); //같은애들이라도 다르게 활동함
		list.add("황의조");
		
		list.add("손흥민");
		list.add("바나나");
		list.add(100); // auto boxing ===== Object obj = 1000;
		list.add(new Integer(100));
		list.add(Calendar.getInstance());
		list.add("황의조");
		
		System.out.println("담겨진 갯수 : " + list.size());
		System.out.println("비어있는지 여부 : " + list.isEmpty());
		
		Set boddari = new HashSet();
		boddari.add("AAAA");
		boddari.add("BBBB");
		boddari.add("CCCC");
		
		list.addAll(boddari);
		System.out.println("담겨진 갯수 : " + list.size());
		
		
		
		boolean result = list.remove(("바나나"));
		System.out.println("삭제결과: "+result);
		
		System.out.println(list.contains("황의조"));
		System.out.println(list.contains(Calendar.getInstance()));
		
		Object[] lists = list.toArray();
		for (Object object : list) {
			if(object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object); // overriding 
		}
		
		Iterator iter = list.iterator()	;
		while(iter.hasNext()) {
			Object object = iter.next();
			System.out.println(object); //iterator 보다 확장for문이 더 심플하고 속도도 빠름
			
//		for (Object object : list) {
//			System.out.println(object);
//		}
		
		//List 에 추가된 규약 메소드들 .. 
		list.add(0, "김기정");
		System.out.println(list.get(0));
		System.out.println(list.remove(0)); // list index로 지우기 : return type : object
		System.out.println(list.set(0, "황희찬")); // 업데이트 하기전 거 리턴
		
		System.out.println(list.size());
		List l = list.subList(0, 3);
		for (Object object2 : l) {
			System.out.println(object2);
		}
		}
		
	}

}
