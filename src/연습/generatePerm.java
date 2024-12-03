package algorithm_practice;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class generatePerm {
	
	static List<int[]> permutation = new ArrayList<int[]>();
	static boolean[] isSelected = new boolean[11];
	public static void generate_permutation(int[] nums, int[] tmp_array, int total_length, int current_length) {
		for (int num : nums) {
			
			if (current_length == 0) {
				isSelected = new boolean[11];			
			}
			
			if (total_length == current_length) {
				// 값만 가져가서 저장하기
				permutation.add((tmp_array));
			System.out.println("현재 숫자 " + num + " 현재 길이 " + current_length + " " +Arrays.toString(tmp_array));
				
				return;
			}

			if (isSelected[num]) continue;             
			isSelected[num] = true;
			tmp_array[current_length] = num;
			
//			System.out.println("현재 숫자 " + num + " 현재 길이 " + current_length + " " +Arrays.toString(tmp_array));
			generate_permutation(nums, tmp_array, total_length, current_length+1);
			
		}
	}
	
	public static void generate_permutation(int[] nums) {
		permutation.clear();
		isSelected = new boolean[11];
		generate_permutation(nums, new int[nums.length], nums.length, 0);
	}
	
	public static void generate_permutation(int[] nums, int total_length) {
		permutation.clear();
		isSelected = new boolean[11];
		generate_permutation(nums, new int[total_length], total_length, 0);
	}
	
	
	
//	public void generate_permutation(int[] nums) {
//		for (int)
//	}
	public static void main(String args[]) {
		// {1,2,3, ...9} 순열 생성하기
		
//		
		generate_permutation(new int[]{1,2,3});
//		for (int[] array: permutation) {
//			for (int atom: array) {
//				System.out.print(atom + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println(permutation.size());
//	
		
		System.out.println(Arrays.toString(permutation.get(0)));
		System.out.println(Arrays.toString(permutation.get(1)));
		System.out.println(Arrays.toString(permutation.get(2)));
	}
}
