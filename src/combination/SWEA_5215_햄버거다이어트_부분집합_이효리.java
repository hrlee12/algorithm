package algorithm.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.FileReader;

public class SWEA_5215_햄버거다이어트_부분집합_이효리 {
	
	public static int[][] ingres;
	public static int length;
	public static int limit;
	public static int max_taste = 0;
	public static int comb_length;
	public static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./hamburger_input.txt"));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc<test_case; tc++) {

			st = new StringTokenizer(br.readLine());
			length = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			ingres = new int[length][2];
			isSelected = new boolean[length+1];
			for (int idx =0; idx<length; idx++) {
				st = new StringTokenizer(br.readLine());
				ingres[idx][0] = Integer.parseInt(st.nextToken());
				ingres[idx][1] = Integer.parseInt(st.nextToken());	
			}
			
		
			for(int cnt = 0; cnt<length+1; cnt++) {
				comb_length = cnt;
				combination(0, 0, 0, 0);
			}
			System.out.printf("#%d %d\n", tc+1, max_taste);
			max_taste = 0;
		}
	}

	
	public static void combination(int start, int count, int taste, int calory) {
		if (count == comb_length) {
			if (taste > max_taste && calory <= limit)
				max_taste = taste;
			return;
		}

		for (int idx = 0; idx<length; idx++) {
			

			combination(idx+1, count+1, taste+ingres[idx][0], calory+ingres[idx][1]);
		}
	}
}

