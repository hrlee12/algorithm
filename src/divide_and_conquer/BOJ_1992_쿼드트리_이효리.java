package algorithm.divide_and_conquer;

import java.io.*;
import java.util.*;

public class BOJ_1992_쿼드트리_이효리 {
	
	public static int length, map[][];
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		length = Integer.parseInt(br.readLine());
		map = new int[length][length];
		
		for (int row = 0; row<length; row++) {
			String line = br.readLine();
			for (int column = 0; column<length; column++) {
				char num = line.charAt(column);
				map[row][column] = Character.getNumericValue(num);
			}
		}
		
		
		search(length, 0, 0);
		System.out.println(sb);

	}

	
	public static void search(int length, int start_r, int start_c) {

		
		// 기저조건
		// 재귀호출을 멈추는 때 : 더 이상 분할하지 않아도 될 때
		// 전부 같은 원소일 때
		if (isSame(length, start_r, start_c)) {
			sb.append(Integer.toString(map[start_r][start_c]));
			return;
		}
		
		
		// 유도부분
		sb.append("(");
		
		int half = length/2;
		
		search(half, start_r, start_c);
		search(half, start_r, start_c+half);
		search(half, start_r+half, start_c);
		search(half, start_r+half, start_c+half);

		sb.append(")");
		
	}
	
	// 분할한 영역의 원소가 모두 같은지 검사하는 메서드
	public static boolean isSame(int length, int start_r, int start_c) {
		int before = map[start_r][start_c];

		for (int row = start_r; row<start_r+length; row++) {
			for (int column = start_c; column<start_c+length; column++) {
				if (before != map[row][column])
					return false;
			}
		}
		
		return true;
		
	}
}