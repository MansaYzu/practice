package numeric;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class numeric {

	public static void main(String[] args) {
		Path inputFilePath = Paths.get("D:\\repos\\practice\\tmp\\103201.s01");
		ArrayList<String> vals = new ArrayList<>();
		ArrayList<Integer> intVals = new ArrayList<>();
		ArrayList<Double> doubleVals = new ArrayList<>();
		
		try (BufferedReader br = Files.newBufferedReader(inputFilePath, Charset.defaultCharset());) {
			String line;
			while ((line = br.readLine()) != null) {
				vals.add(line);
				try {
					int n = Integer.parseInt(line, 10);
					intVals.add(n);
				} catch (NumberFormatException e2) {
					try {
						double n = Double.parseDouble(line);
						doubleVals.add(n);
					} catch (NumberFormatException e3) {
						System.err.print(line + "is not a number.");
					}
				}
			}
			
			// 印出浮點數的
			System.out.print("nulldoubleValus:");
			printArray(sortArray(doubleVals.toArray()));
			
			// 印出整數的
			System.out.print("intValus:");
			printArray(sortArray(intVals.toArray()));
			
			// 好像是想考Arrays.fill
			String[] filledInts = new String[10];
			Arrays.fill(filledInts, 0, 10, "7");
			System.out.print("filledInt:");
			printArray(filledInts);

			// 比較兩陣列是否一樣
			Object[] intValues = intVals.toArray();
			Integer[] intValuesCopy = {1, 2, 4, 3, 5, 6};
			Object[] intValuesCopy2 = intValues.clone();
			if (printEquality(intValues, intValuesCopy)) {
				System.out.print("intValues == intValuesCopy");
			} else {
				System.out.print("intValues != intValuesCopy");
			}
			System.out.println();
			if (printEquality(intValues, intValuesCopy2)) {
				System.out.print("intValues == intValuesCopy2");
			} else {
				System.out.print("intValues != intValuesCopy2");
			}
			System.out.print("intValues ref == intValuesCopy2 ref ? " + (intValues == intValuesCopy2));
			System.out.println();
			
			System.out.println("searchForInt \"5\" in " + searchForInt(vals.toArray(), "5"));
		} catch (IOException e) {
			
		}
	}

	static int searchForInt(Object[] array, Object key) {
		return Arrays.binarySearch(array, key);
	}
	
	static Object[] printArray(Object[] array) {
		if (array == null || array.length == 0) {
			System.err.println("打印的陣列是空的");
			return array;
		}
		
		for (Object d: array) {
			System.out.print(" " + d);				
		}
		System.out.println();
		return array;
	}
	
	static Object[] sortArray(Object[] array) {
		if (array == null || array.length == 0) {
			System.err.println("打印的陣列是空的");
			return array;
		}
		if (array[0] instanceof String) {
			Arrays.sort((String[])array, Comparator.naturalOrder());
			// Arrays.sort((String[])array, Comparator.reverseOrder());
		} else {
			// 升冪
			Arrays.sort(array);
			// 降冪
			// Arrays.sort(array, Collections.reverseOrder());
		}
		return array;
	}
	
	static boolean printEquality(Object[] array1, Object[] array2) {
//		if (array1.length != array2.length ) {
//			return false;
//		}
//		for (int i = 0; i < array1.length; i++) {
//			if (!array1[i].equals(array2[i])) {
//				return false;
//			}
//		}
//		return true;
		return Arrays.equals(array1, array2);
	}
}
