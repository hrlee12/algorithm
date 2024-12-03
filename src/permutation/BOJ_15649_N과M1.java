package algorithm.permutation;



import java.util.Scanner;


public class BOJ_15649_N과M1 {

	static boolean[] isSelected = new boolean[20];
	public static void generate_permutation(int[] nums, int[] tmp_array, int perm_length, int current_length) {
		// 모든 원소에 대해서 돌아가면서 함. 
		for (int num : nums) {	
			// 첫번째 원소면 isSelected 초기화 
			// 인덱스 1을 바꿔도 되지만 그냥 깔끔하게 초기화. 
			if (current_length == 0) {
				isSelected = new boolean[11];			
			}
			
			// 순열을 전부 채웠으면 출력하고 리턴
			if (perm_length == current_length) {
				// 순열의 원소 출력
				for (int idx = 0; idx<perm_length; idx++) {
					System.out.printf("%d ",  tmp_array[idx]);
				}
				System.out.println();
				
				return;
			}
			// 이미 사용된 원소면 넘어가기
			if (isSelected[num]) continue;  
			// 순열이므로 겹치지 않게 넣은 원소는 true표시
			isSelected[num] = true;
			

			tmp_array[current_length] = num;
			
			// 다음 원소를 채우러 재귀 호출. 
			generate_permutation(nums, tmp_array, perm_length, current_length+1);
			
			isSelected[num] = false;
		}
	}
	
	
	

	
	 // 사용자 편의성 고려한 오버로딩 함수
	 // 최초로 호출할 때 쓰임
	public static void generate_permutation(int number, int perm_length) {
		isSelected = new boolean[11];
		int[] nums = new int[number];
		for (int idx =0; idx <number; idx++) {
			nums[idx] = idx+1;
		}
		generate_permutation(nums, new int[perm_length],
				perm_length, 0);
	}
	
	
	

	public static void main(String args[])  {
		// 데이터 입력받기
		Scanner sc = new Scanner(System.in);
		int array_length, perm_length;
		array_length = sc.nextInt();
		perm_length = sc.nextInt();
		
		generate_permutation(array_length, perm_length);
	}	
}