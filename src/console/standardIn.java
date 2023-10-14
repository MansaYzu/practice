package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class standardIn {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("請輸入文字: ");
			String line = br.readLine();
			System.out.println("您輸入: " + line);
		} catch (IOException e) {
			System.err.print(e);
		}
	}

}
