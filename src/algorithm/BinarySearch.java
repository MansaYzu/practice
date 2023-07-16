package algorithm;

import java.util.Arrays;

/** 
 * 二元搜尋
 */
public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(BinarySearch.find(new int[]{1,2,3,4,5}, 2));
		System.out.println(BinarySearch.find2(new int[]{1,2,3,4,5}, 2));
	}
	
	/**
	 * 尋找陣列中的數字，找到就回傳目標索引
	 * @param array 
	 * @param target
	 * @return 目標的索引，否則回傳 -1
	 */
	static int find(int[] array, int target) {
		int startIdx = 0, endIdx = array.length - 1;
		while (startIdx <= endIdx) {
			int mid = (int) Math.floor((startIdx + endIdx)  / 2);
			if (array[mid] == target) {
				return mid;
			} else if (target > array[mid]) {
				startIdx = mid + 1;
			} else {
				endIdx = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * 尋找陣列中的數字，找到就回傳目標索引
	 * @param array 
	 * @param target
	 * @return 目標的索引，否則回傳 -1
	 */
	static int find2(int[] array, int target) {
		int mid = (int) Math.floor(array.length  / 2);
		if (array[mid] == target) {
			return mid;
		} else if (target > array[mid]) {
			return mid + 1 + BinarySearch.find2(Arrays.copyOfRange(array, mid + 1, array.length), target);
		} else {
			return BinarySearch.find2(Arrays.copyOfRange(array, 0, mid), target);
		}
	}

}
