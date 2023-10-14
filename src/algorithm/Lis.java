package algorithm;

import java.util.Arrays;

/**
 * 最長遞增子串列
 */
public class Lis {

	public static void main(String[] args) {
		int[] arr = new int[] {-7, 9, 10, 2, 3, 11, 8};
		System.out.print("較優先吻合的LIS: " + Arrays.toString(Lis.firstMeaat(arr)) + "\n");
		System.out.printf("總數較高吻合的LIS: %s%n", Arrays.toString(Lis.preferBigVal(arr)));
	}

	/**
	 * 找最先吻合的LIS
	 * @param sequence
	 * @return
	 */
	public static int[] firstMeaat(int[] sequence) {
		// 輸入值防呆驗證
		if (sequence == null || sequence.length == 0) { return new int[0]; }
		
		// 先算出序列各元素結尾的LIS長度存進另一個陣列裡(分治+動態規劃)
		int[] lisLens = new int[sequence.length];
		int[] lisPrev = new int[sequence.length];
		Arrays.fill(lisLens, 1);
		Arrays.fill(lisPrev, -1);
		for (int i = 0; i < sequence.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (sequence[j] < sequence[i] && lisLens[j] + 1 > lisLens[i]) {
					lisLens[i] = lisLens[j] + 1;
					// 算出LIS長度時，記錄前一個元素的索引(類似鍵結串列概念)
					lisPrev[i] = j;
				}
			} 
		}
		
		// 找各元素結尾時LIS最大值，得到它的索引
		int maxLisLenPos = lisLens[0];
		for (int i = 0; i < lisLens.length; i++) {
			if (lisLens[i] > lisLens[maxLisLenPos]) {
				maxLisLenPos = i;
			}
		}
		
		// 從取到的索引一直往前一個紀錄的元素索引找，將元素依序記到另一個序列即LIS
		int[] retArr = new int[lisLens[maxLisLenPos]];
		for (int i = maxLisLenPos, k = retArr.length - 1; i >= 0; i = lisPrev[i]) {
			retArr[k] = sequence[i];
			k--;
		}
				
		return retArr;
	}
	
	/**
	 * 找數值較大的LIS
	 * @param sequence
	 * @return
	 */
	public static int[] preferBigVal(int[] sequence) {
		// 輸入值防呆驗證
		if (sequence == null || sequence.length == 0) { return new int[0]; }
		
		// 先算出序列各元素結尾的LIS長度存進另一個陣列裡(分治+動態規劃)
		int[] lisLens = new int[sequence.length];
		int[] lisPrev = new int[sequence.length];
		Arrays.fill(lisLens, 1);
		Arrays.fill(lisPrev, -1);
		for (int i = 0; i < sequence.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (sequence[j] < sequence[i]) { 
					if (lisLens[j] + 1 > lisLens[i]) { // 長度更大
						lisLens[i] = lisLens[j] + 1;
						// 算出LIS長度時，記錄前一個元素的索引(類似鍵結串列概念)
						lisPrev[i] = j;
					} else if (lisLens[j] + 1 == lisLens[i]) { // 長度一樣
						if (sequence[j] > sequence[lisPrev[i]]) { // 若數字比較大選數字大的
							lisPrev[i] = j;	
						}
					}
				}
			} 
		}
		
		// 找各元素結尾時LIS最大值，得到它的索引
		int maxLisLenPos = lisLens[0];
		for (int i = 0; i < lisLens.length; i++) {
			if (lisLens[i] > lisLens[maxLisLenPos]) { // 長度更大
				maxLisLenPos = i;
			} else if (lisLens[i] == lisLens[maxLisLenPos]) { // 長度一樣
				if (sequence[i] > sequence[maxLisLenPos]) { // 看序列數值有沒有比之前找到的更大
					maxLisLenPos = i;
				}
			}
		}
		
		// 從取到的索引一直往前一個紀錄的元素索引找，將元素依序記到另一個序列即LIS
		int[] retArr = new int[lisLens[maxLisLenPos]];
		for (int i = maxLisLenPos, k = retArr.length - 1; i >= 0; i = lisPrev[i]) {
			retArr[k] = sequence[i];
			k--;
		}
				
		return retArr;
	}
}
