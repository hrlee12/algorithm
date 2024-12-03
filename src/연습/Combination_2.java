package algorithm_practice;

import java.util.Arrays;

public class Combination_2 {
	public static int length = 3;
	public static int[] arr;
	public static int[] result = new int[3];
	
	public static void main(String args[]) {
		arr = new int[] {1, 2, 3, 4};
		
		combination(0, 0);
	}
	
	
	public static void combination(int start, int count) {
		if (count == length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int idx=start; idx<arr.length; idx++ ) {
//			System.out.println("count : " + count);
//			System.out.println("idx : " + idx);
			result[count] = arr[idx];
			combination(idx+1, count+1);
		}
	}
}
