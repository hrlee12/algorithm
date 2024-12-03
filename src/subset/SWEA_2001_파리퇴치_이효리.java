package algorithm.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.io.FileReader;

public class SWEA_2001_파리퇴치_이효리 {

	static int[][] map;
	static int catch_size;
	static int map_size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		String file = "./input_fly.txt";
//		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map_size = Integer.parseInt(st.nextToken());
			catch_size = Integer.parseInt(st.nextToken());
			map = new int[map_size][map_size];
			for (int row=0; row<map_size; row++) {
				st = new StringTokenizer(br.readLine());
				for (int column=0; column<map_size; column++) {
					map[row][column] = Integer.parseInt(st.nextToken());
				}
			}
			int max_catch = catch_fly(0, 0, 0);
			System.out.printf("#%d %d\n", tc+1, max_catch);
		}
	}
	
	
	private static int catch_fly(int max_catch, int row, int column) {
		if (row +(catch_size-1) >= map_size) {
			return max_catch;
		}
		
		int sum = 0;
		for (int c_row=0; c_row <catch_size; c_row++) {
			for (int c_column=0; c_column<catch_size; c_column++) {
				sum += map[row+c_row][column+c_column];
			}
		}
		if (sum > max_catch) {
			max_catch = sum;
		}
		
		
		if (column+catch_size < map_size){
			return catch_fly(max_catch, row, column+1);
		} else {
			return catch_fly(max_catch, row+1, 0);
		}
	}
}
