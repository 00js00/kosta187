import java.util.Set;
import java.util.TreeSet;

public class TresSetExample {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("김기정");
		set.add("김기정1");
		set.add("김기정2");
		set.add("김기정3");
		set.add("김기정4");
		set.add("김기정5");
		set.add("김기정9");
		
		for (String string : set) {
			System.out.println(string);
		}

		
		
	}
}
