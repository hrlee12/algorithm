package algorithm.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_3040_백설공주와일곱난쟁이_이효리 {
	
	public static int[] nums = new int[9];
	public static int[] selected = new int[7];
	public static int comb_length = 7;
	public static int total_length = 9;
	public static int[] result;
	public static boolean isDone;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int idx = 0; idx<9; idx++) {
			nums[idx] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0, 0);

	}
	
	
	public static void combination(int count, int start, int sum) {
		if (count == comb_length) {
			if (sum == 100) {
				for (int idx=0; idx<comb_length; idx++) {
					System.out.println(selected[idx]);
				}

				isDone = true;
			}
			
			return;
		}
		if (isDone) return;
		for (int idx = start; idx<total_length; idx++) {
			selected[count] = nums[idx];
			combination(count+1, idx+1, sum+nums[idx]);
		}
	}

}
