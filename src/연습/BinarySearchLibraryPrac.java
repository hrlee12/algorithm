package algorithm_practice;

import java.util.Arrays;

public class BinarySearchLibraryPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] li = new int[] {4, 2, 1, 3};
		Arrays.sort(li);
		System.out.println(Arrays.toString(li));
		System.out.println(Arrays.binarySearch(li, 3));
		
	}

}
