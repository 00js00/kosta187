import java.util.Calendar;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 순서를 통해 데이터를 관리하기 위한 규약(인터페이스)이다. Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가진다.
 * ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스이다
 * 
 * @author 서지원
 *
 */
public class ListExample2 {

	public static void main(String[] args) { 
		Vector list = null; // 같은 List아니고 Vector 는 addElement 로 받으니까 형태를 Vector로 해야함
//		list = new Vector(); // 같은애들이라도 다르게 활동함
		list = new Vector(10,5); //용량을 담을 때 배로 늘어남 10 20 40 80 ... --> 5 : 늘어나는 증가치
		
		list.addElement("황의조");

		list.addElement("손흥민");
		list.addElement("바나나");
		list.addElement(100); // auto boxing ===== Object obj = 1000;
		list.addElement(new Integer(100));
		list.addElement(Calendar.getInstance());
		list.addElement("황의조");

		System.out.println("담겨진 갯수 : " + list.size());
		System.out.println("비어있는지 여부 : " + list.isEmpty());
		
		System.out.println(list.elementAt(0));
		System.out.println(list.removeElement("바나나"));
		
		//주의 : foreach 쓰면 안됨 --- 동기처리가 안되어있어서! 
		Enumeration e =list.elements();
		while (e.hasMoreElements()) {
			Object object = e.nextElement();
			System.out.println(object);
			
		}
		
	}

}
