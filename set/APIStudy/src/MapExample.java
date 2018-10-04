import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("680313", "김기정");
		map.put("690313", "이기정");
		map.put("700313", "박기정");
		map.put("710314", "최기정");
		map.put("720314", "정기정");
		
		if(map.containsKey("710313")) {
			System.out.println("존재하는 키입니다..");
		}else {
			map.put("720313", "김기정");
			System.out.println(map.get("720313"));
		};
		
		Set<String> keylist = map.keySet(); 
		for (String key : keylist) {
			System.out.println(key);
		}
		
		Collection<String> values = map.values()	;
		for (String name : values) {
			System.out.println(name);
		}
		

	}

}
