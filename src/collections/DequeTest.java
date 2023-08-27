package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {

	public static void main(String[] args) {
		Deque<String> stack = new ArrayDeque<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		do {
			System.out.println(stack.pop());
		} while (stack.size() > 0);
	}

}
