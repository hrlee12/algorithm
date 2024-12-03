package algorithm_practice;

import java.util.Arrays;

/*
 * 
 * 디버깅하기
 */

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] {3, 2, 1, 5, 7, 8, 9, 4, 11, 35, 99, 132, 12};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int result = binarySearch(arr, 132, 0, arr.length-1);
		
		System.out.println(result);
		
	}
	
	
	
	/*
	 * 중간 인덱스 구하기
	 * 8
	 * 1 2 3 4 5 6 7 8
	 * 
	 * start = 0, end = 7
	 * 7/2 = 3
	 * 
	 * 
	 * 무조건 end가 더 크거나 같아야 함. 그런데 찾는 수가 없는 경우 end보다 start가 더 커짐. 
	 * 그러면 찾는 수가 없는 것이니 -1을 리턴하자. 
	 * 
	 */
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		
		
		int mid = (end - start) / 2;
		System.out.println(mid);
		if (mid < 0) 
			return -1;
		
		if (arr[mid] == target) 
			return mid;
		else if (arr[mid] > target) 
			return binarySearch(arr, target, start, mid-1);
		else
			return binarySearch(arr, target, mid+1, end);

		
	}
}
