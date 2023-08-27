package string;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sbuff = new StringBuffer(100);
		sbuff.append("\", the lightning flashed and the thunder\r\n" + "rumbled.\\n");
		sbuff.insert(0, "It was a dark and stormy night");
		sbuff.reverse();
		System.out.println(sbuff.toString());
	}

}
