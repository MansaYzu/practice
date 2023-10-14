package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class properties {

	public static void main(String[] args) {
		System.out.println("env: " + System.getProperty("env"));
		System.out.println();
		
		Properties prop = new Properties();

//		try (InputStream fr = Files.newInputStream(Paths.get("D:/repos/practice/ServerInfo.properties"), StandardOpenOption.READ);) {
//			prop.load(fr);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try (BufferedReader br = Files.newBufferedReader(Paths.get("D:/repos/practice/ServerInfo.properties"))) {
			prop.load(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		prop.list(System.out);
		
		System.out.print("hostName: ");
		System.out.println(prop.getProperty("hostName") + "\n");

		System.out.println("properties [elements]:");
		for (Enumeration<Object> e = prop.elements(); e.hasMoreElements();) {
		  System.out.println(e.nextElement());
		}
		System.out.println();

		System.out.println("properties [entrySet]:");
		Set<Entry<Object,Object>> ps = prop.entrySet();
		Iterator<Entry<Object, Object>> psi = ps.iterator();
		for (;psi.hasNext();) {
			System.out.println(psi.next());
		}
		System.out.println();
	}

}
