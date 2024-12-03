package algorithm.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_16435_스네이크버드_이효리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int fruit_num = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int[] fruits = new int[fruit_num];
		st = new StringTokenizer(br.readLine());
		
		for (int idx = 0; idx<fruit_num; idx++) {
			fruits[idx] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruits);
		
		for (int idx =0; idx<fruit_num; idx++) {
			if (length >= fruits[idx]) {
				length++;
			}
		}
		System.out.println(length);
	}
}
