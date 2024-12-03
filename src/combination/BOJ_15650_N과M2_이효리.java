package algorithm.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.StringBuilder;


public class BOJ_15650_N과M2_이효리 {

	static StringBuilder sb = new StringBuilder();
	static int[] comb_array;
	static int array_length;
	static int comb_length;
	
	public static void main(String[] args) throws IOException {
		// 입력값 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		array_length = Integer.parseInt(st.nextToken());
		comb_length = Integer.parseInt(st.nextToken());
		// 조합을 담을 변수에 배열 생성하여 할당
		comb_array = new int[comb_length];
		
		
		combination(1, 0);
		
		// 결과 출력
		System.out.println(sb.toString());
	}
	
	private static void combination(int start, int current_idx) {
		// 조합을 다 채우면 StringBuilder에 넣어서 출력 준비
		if (current_idx == comb_length) {
			for (int atom: comb_array) {
				sb.append(atom + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int value = start; value<=array_length; value++) {
			comb_array[current_idx] = value;
			
			combination(value+1, current_idx+1);
		}
	}
}
