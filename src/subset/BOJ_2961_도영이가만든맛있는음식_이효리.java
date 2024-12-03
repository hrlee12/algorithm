package algorithm.subset;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2961_도영이가만든맛있는음식_이효리 {
	static int[][] array;
	static int size;
	static boolean[] isSelected;
	static int result = 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		array = new int[size][2];
		isSelected = new boolean[size];
		
		for (int idx=0; idx<size; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			array[idx][0] = Integer.parseInt(st.nextToken());
			array[idx][1] = Integer.parseInt(st.nextToken());
		}
		result = 1000000000;
		subset(0);
		System.out.println(result);
	}
	
	private static void subset(int current_idx) {
		if (current_idx == size) {
			int sour = 1;
			int bitter = 0;
			boolean flag = false;
			for (int idx=0; idx<size; idx++) {
				if (isSelected[idx] == true) {
					flag = true;
					sour *= array[idx][0];
					bitter += array[idx][1];
					
				}
			}
			if (!flag) return;
			int gap = sour - bitter;
			if (gap <0) {
				gap *= -1;
			}
			
			if (gap < result) {
				result = gap;
			}
			return;
		}
		
		isSelected[current_idx] = true;
		subset(current_idx+1);
		isSelected[current_idx] = false;
		subset(current_idx+1);
	}
		
}
