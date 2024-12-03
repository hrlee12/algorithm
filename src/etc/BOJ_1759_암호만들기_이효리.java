package algorithm.etc;

import java.util.*;
import java.io.*;


public class BOJ_1759_암호만들기_이효리 {

	public static int[] vowel = new int[] {97, 101, 105, 111, 117};
	public static List<Integer> vowels = new ArrayList<>();
	public static List<Integer> others = new ArrayList<>();
	public static int[] result;
	public static int pw_length, alpha_num, vowel_idx, other_idx;
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		pw_length = Integer.parseInt(st.nextToken());
		alpha_num = Integer.parseInt(st.nextToken());
		result = new int[pw_length];
		
		String input = br.readLine();
		
		for (int idx = 0; idx < alpha_num; idx++) {
			int code = (int)input.charAt(idx*2);
			for (int i = 0; i <vowel.length; i++) {
				if (vowel[i] == code) {
					vowels.add(code);
				} else {
					others.add(code);
				}
			}
		}
		
		
		
		
	}
	public static void search(int vowel_num, int count, int start) {
		if (count == pw_length) {
			for (int idx = 0; idx < pw_length; idx++) {
				sb.append(result[idx]);
			}
			sb.append("\n");
			
		}

		// for (int idx = start; idx < alpha_num; idx++) {
		// 	if (count < 1) {
		// 		result[idx] = vowels.get(idx);
		// 		search(count+1, idx+1);
		// 	} else if (idx < pw_length-2) {
		// 		result[idx] = vowels.get(idx);
		// 		search(count+1, idx+1);
		// 		result[idx] = others.get(idx);
		// 		search(count+1, idx+1);
		// 	} else {
		// 		result[idx] = others.get(idx);
		// 		search(count+1, idx+1);
		// 	}
		// }
	}
}