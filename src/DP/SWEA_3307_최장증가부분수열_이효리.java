/*
 * 최장 증가 부분 수열
 * 
 * 원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중, 
 * 각 원소가 이전 원소보다 크다는 조건을 만족하고, (순서는 기존 수열에서와 같음)
 * 그 길이가 최대인 부분 수열을 최장 증가 부분 수열이라고 합니다.
 * 
 * { 6, 2, 5, 1, 7, 4, 8, 3}
 * 
 * -> 2, 5, 7, 8
 * -> 4개 
 *
 * length라는 배열을 만들어서
 * 수열의 첫번째 원소부터 
 * length[idx] = 1으로 초기화하고
 * 
 * 현재 idx보다 앞 원소들을 첫번째부터 확인하면서 
 * 현재 원소보다 작으면 
 * 현재 원소의 length와 비교 원소의 length+1 중 큰 녀석으로 
 * 현재 녀석의 length를 업데이트 시켜준다. 
 *
 */

package DP;

import java.util.*;
import java.io.*;

public class SWEA_3307_최장증가부분수열_이효리 {
	
	public static int num, numbers[], length[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < test_case; tc++){
			num = Integer.parseInt(br.readLine());
			
			numbers = new int[num];
			length = new int[num];
			
			st = new StringTokenizer(br.readLine());
			
			for (int idx = 0; idx < num; idx++) {
				numbers[idx] = Integer.parseInt(st.nextToken());
			}
			
			int result = solution(0);
			System.out.printf("#%d %d\n", tc+1, result);
			
		}
		
		
		
	}
	
	public static int solution(int count) {
		int max = 0;
		for (int idx = 0; idx < num; idx++) {
			length[idx] = 1;
			
			for (int before = 0; before < idx; before++) {
				if (numbers[idx] > numbers[before]) 
					length[idx] = Math.max(length[idx], length[before]+1);
			}
			
			if (max < length[idx])
				max = length[idx];
			
		}
		
		return max;
		
	}

}