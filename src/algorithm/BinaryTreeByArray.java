package algorithm;

/** 陣列實作二元樹 */
public class BinaryTreeByArray {
	
	
	public static void main(String[] args) {
		/** 層序遍歷的樹節點 */
		final String[] nodes = new String[]{"1", "2", "3", "4", "5", null, "6", "7", "8", null, null, null, null, "9", "10"};
		printByPreOrder(nodes, 0);
		System.out.println();
		printByInOrder(nodes, 0);
		System.out.println();
		printByPostOrder(nodes, 0);
		System.out.println();
	}
	
	static void printByPreOrder(String[] nodes, int index) {
		if (index >= nodes.length) { return; }
		if (nodes[index] == null) { return; }
		
		System.out.print(nodes[index]);		
		printByPreOrder(nodes, index * 2 + 1);
		printByPreOrder(nodes, index * 2 + 2);
	}
	
	static void printByInOrder(String[] nodes, int index) {
		if (index >= nodes.length) { return; }
		if (nodes[index] == null) { return; }
		
		printByInOrder(nodes, index * 2 + 1);
		System.out.print(nodes[index]);		
		printByInOrder(nodes, index * 2 + 2);
	}
	
	static void printByPostOrder(String[] nodes, int index) {
		if (index >= nodes.length) { return; }
		if (nodes[index] == null) { return; }
		
		printByPostOrder(nodes, index * 2 + 1);
		printByPostOrder(nodes, index * 2 + 2);
		System.out.print(nodes[index]);		
	}
}
