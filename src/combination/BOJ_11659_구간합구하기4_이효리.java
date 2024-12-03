package algorithm.combination;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class BOJ_11659_구간합구하기4_이효리 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length_nums = Integer.parseInt(st.nextToken());
		int length_add = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[length_nums];
		
		st = new StringTokenizer(br.readLine());
		

		for (int idx=0; idx<length_nums; idx++) {
			if (idx == 0) {
				nums[idx] = Integer.parseInt(st.nextToken());
				continue;
			}
		
			nums[idx] = nums[idx-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int count = 0; count < length_add; count++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			add_nums(nums, start, end);
		}
		
		System.out.print(sb.toString());
	}
	
	
	private static void add_nums(int[] nums, int start, int end) {
		int sum = 0;
		
		if (start <= 1) {
			sum = nums[end-1];
		} else {
			sum = nums[end-1] - nums[start-2];
		}
		sb.append(sum + "\n");
		
	}
}
