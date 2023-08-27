package collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(0, 0);
		System.out.println("is 4 existing ? " + list.contains(4));
		System.out.println("index of 2: " + list.indexOf(2));
		System.out.println("last index of 2: " + list.lastIndexOf(2));
		for (Integer n: list) {
			System.out.print(n + " ");
		}
		
		
	}

}
