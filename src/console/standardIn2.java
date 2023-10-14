package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class standardIn2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入文字: ");
		String s = sc.next();
		System.out.println("您輸入: " + s);
		
		System.out.print("請輸入數字: ");
		int n = sc.nextInt();
		System.out.println("您輸入: " + n);
		sc.close();
	}

}
