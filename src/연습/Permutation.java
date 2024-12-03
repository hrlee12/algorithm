package algorithm_practice;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	
	static List<int[]> permutation = new ArrayList<int[]>();
	static boolean[] isSelected = new boolean[11];
	public static void generate_permutation(int[] nums, int[] tmp_array, int total_length, int current_length) {
		// 모든 원소에 대해서 돌아가면서 함. 
		for (int num : nums) {	
			// 첫번째 원소면 isSelected 초기화 
			// 인덱스 1을 바꿔도 되지만 그냥 깔끔하게 초기화. 
			if (current_length == 0) {
				isSelected = new boolean[11];			
			}
			
			// 순열을 전부 채웠으면 permutation에 저장하고 리턴
			if (total_length == current_length) {
				// 값만 가져가서 저장하기
				permutation.add((tmp_array.clone()));
//			System.out.println("현재 숫자 " + num + " 현재 길이 " + current_length + " " +Arrays.toString(tmp_array));
				
				return;
			}
			// 이미 사용된 원소면 넘어가기
			if (isSelected[num]) continue;  
			// 순열이므로 겹치지 않게 넣은 원소는 true표시
			isSelected[num] = true;
			
			tmp_array[current_length] = num;
			
			// 다음 원소를 채우러 재귀 호출. 
			generate_permutation(nums, tmp_array, total_length, current_length+1);
			
			isSelected[num] = false;
		}
	}
	
	
	
	 // 사용자 편의성 고려한 오버로딩 함수
	 // 최초로 호출할 때 쓰임
	public static void generate_permutation(int[] nums) {
		permutation.clear();
		isSelected = new boolean[11];
		generate_permutation(nums, new int[nums.length], nums.length, 0);
	}
	
	
	 // 사용자 편의성 고려한 오버로딩 함수
	 // 최초로 호출할 때 쓰임
	public static void generate_permutation(int[] nums, int total_length) {
		permutation.clear();
		isSelected = new boolean[11];
		generate_permutation(nums, new int[total_length], total_length, 0);
	}
	
	
	

	public static void main(String args[]) {

		generate_permutation(new int[]{1,2,3,4,5});
		
		for (int[] array: permutation)
			System.out.println(Arrays.toString(array));
			
	
		System.out.println(permutation.size());
	}	
}
