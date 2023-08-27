package collections;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> partList = new TreeMap<>();
		partList.put("S001", "Blue Polo Shirt");
		partList.put("S002", "Black Polo Shirt");
		partList.put("H001", "Duke Hat");
		partList.put("S002", "Black T-Shirt"); // Overwrite value
		Set<Entry<String, String>> entrySet = partList.entrySet();
		for (Entry<String, String> entry: entrySet) {
			System.out.println("[" + entry.getKey() + "]: " + entry.getValue());
		}
	}

}
