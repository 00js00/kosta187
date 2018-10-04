import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionQuiz {
	public static void main(String[] args) {
		Set<Account> set = new HashSet<>()	;
		set.add(new Account("1111","김기정",1111,1000));
		set.add(new Account("2222","박기정",1111,1000));
		set.add(new Account("1111","김기정",1111,1000));
		System.out.println(set.size());
		
		Student student = new Student();
		System.out.println(student.toString());
		System.out.println(student.hashCode());
		
		Map<String, String> map = System.getenv()	;
		Set<String> keySet = map.keySet();
		for (String name : keySet) {
			String value = System.getenv(name);
			System.out.println(name + "=" + value);
		}
	}
}
