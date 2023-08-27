package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("the");
		Matcher matcher = pattern.matcher("It was the best of times. It was the worst of times");
		while (matcher.find()) {
			System.out.println("Find: " + matcher.group());
			System.out.println("index from " + matcher.start() + " to " + matcher.end());
			;
		}
		System.out.println();
		
		String email = "george.washington@example.com";
		Pattern p1 = Pattern.compile("(\\S+?)\\.(\\S+?)@(\\S+)");
		Matcher m1 = p1.matcher(email);
		while (m1.find()) {
			System.out.println("First: " + m1.group(1));
			System.out.println("Last: " + m1.group(2));
			System.out.println("Domain: " + m1.group(3));
			System.out.println("Everything Matched: " + m1.group(0));
		}
	}

}
