package algorithm.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Arrays;

public class SWEA_9229_한빈이와SpotMart_이효리 {
	
	public static int test_case;
	public static int length;
	public static int[] snacks;
	public static int max_weight;
	public static int result;
	public static int[] picked_snacks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < test_case; tc++) {
			
			result = -1;
			picked_snacks = new int[2];
			
			st = new StringTokenizer(br.readLine());
			length = Integer.parseInt(st.nextToken());
			max_weight = Integer.parseInt(st.nextToken());
			snacks = new int[length];
			
			st = new StringTokenizer(br.readLine());
			
			for (int idx =0; idx<length; idx++) {
				snacks[idx] = Integer.parseInt(st.nextToken());
			}
			
			collection(0, 0);
			System.out.printf("#%d %d\n", tc+1, result);
			
		}
		
		
	}
	
	
	public static void collection(int count, int start_index) {
		if (count == 2) {
			int current_weight = picked_snacks[0] + picked_snacks[1];
			if (current_weight <= max_weight && result < current_weight) {
				result = current_weight;
			}
			
			return;
		}
		
		for (int idx = start_index; idx < length; idx++) {
			
			picked_snacks[count] = snacks[idx];
			collection(count+1, idx+1);
		}
	}
}
