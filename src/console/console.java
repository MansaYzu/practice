package console;

import java.io.Console;

public class console {

	public static void main(String[] args) {
		Console cons = System.console();
		
		if (cons != null) {
			System.out.print("請輸入文字: ");
			String line = cons.readLine();
			System.out.print("輸入的文字: " + line);
			
			System.out.print("請輸入密碼: ");
			String pwd = new String(cons.readPassword());
			System.out.print("輸入的密碼: " + pwd);
		}
	}

}
