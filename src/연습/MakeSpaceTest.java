package inClass;

import java.util.*;
import java.io.*;

public class MakeSpaceTest {

	static int spaces[][];
	static int white, green;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		spaces = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c =0; c < N; c++) {
				spaces[r][c] = sc.nextInt();
			}
		}
		makeSpace(0, 0, N);
		System.out.println(white);
		System.out.println(green);
		
	}
	
	private static void makeSpace(int sr, int sc, int size) { // 영역의 좌상단 r,c, 영역 크기 size
		
		int sum = 0;
		for (int r = sr; r < sr+size; r++) {
			for (int c =sc; c < sc+size; c++) {
				sum += spaces[r][c];
			}
		}
		
		if (sum == 0) {
			white++;
		}else if (sum == size*size) {
			green++;
		}else {	// 두 색이 섞여있는 공간
			int half = size/2;			
			makeSpace(sr, sc, half);
			makeSpace(sr, sc+half, half);
			makeSpace(sr+half, sc, half);
			makeSpace(sr+half, sc+half, half);
		}
	}
}
