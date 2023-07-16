package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] unsortedArray1 = new int[]{4,3,5,1,7,6,2};
//		Sort.selectionSort(unsortedArray1);
//		Sort.bubbleSort(unsortedArray1);
//		Sort.quickSort(unsortedArray1, 0, unsortedArray1.length - 1);
//		Sort.insertionSort(unsortedArray1);
		Sort.mergeSort(unsortedArray1, 0, unsortedArray1.length - 1);
		System.out.println("array1: " + Arrays.toString(unsortedArray1));
		
	}

	/**
	 * 選擇排序
	 * @param array
	 */
	static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] <= array[i]) {
					Sort.swap(array, i, j);
				}
			}
		}
	}
	
	/**
	 * 泡沫排序
	 * @param array
	 */
	static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean hasSwap = false;
			for (int j = 1; j < array.length - i; j++) {
				if (array[j - 1] > array[j]) {
					Sort.swap(array, j - 1, j);
					hasSwap = true;
				}
			}
			if (!hasSwap) {
				System.out.println("bubbleSort detect already sorted");
				break;
			}
		}
	}
	
	/**
	 * 快速排序
	 * @param array
	 * @param start 陣列索引(起)
	 * @param end 陣列索引(迄)
	 */
	static void quickSort(int[] array, int start, int end) {
		if (start >= end) { return; }

		int pivot = array[end];
		int i = start - 1; // i 右邊的陣列值都比pivot值大
		
		for (int j = start; j < end; j ++) {
			if (array[j] < pivot) {
				i++;
				Sort.swap(array, j, i);
			}
		}
		
		i++;
		Sort.swap(array, end, i);
		Sort.quickSort(array, start, i - 1);
		Sort.quickSort(array, i + 1, end);
	}
	
	/**
	 * 插入排序
	 */
	static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) { // i: 處理中的數字索引，所有數字掃一遍
			int key = array[i]; // 處理中的數字
			int j = i - 1; // 已排好的索引

			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
	
	/**
	 * 合併排序
	 * @param array
	 * @param start 陣列索引(起)
	 * @param end 陣列索引(迄)
	 */
	static void mergeSort(int[] array, int start, int end) {
		if (start >= end) { return; }
		int mid = (int) Math.floor((start + end) / 2);
		Sort.mergeSort(array, start, mid);
		Sort.mergeSort(array, mid + 1, end);
		
		ArrayList<Integer> leftSubList  = new ArrayList<Integer>();
		for (int i = start; i <= mid; i++) {
			leftSubList.add(array[i]);
		}
		leftSubList.add(Integer.MAX_VALUE);
		
		ArrayList<Integer> rightSubList  = new ArrayList<Integer>();
		for (int i = mid + 1; i <= end; i++) {
			rightSubList.add(array[i]);
		}
		rightSubList.add(Integer.MAX_VALUE);
		
		int leftSubIdx = 0;
		int rightSubIdx = 0;
		for (int i = start; i <= end; i++) {
			if (leftSubList.get(leftSubIdx) < rightSubList.get(rightSubIdx)) {
				array[i] = leftSubList.get(leftSubIdx++);
			} else {
				array[i] = rightSubList.get(rightSubIdx++);
			}
		}
	}
	
	static final <T> void swap (int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
