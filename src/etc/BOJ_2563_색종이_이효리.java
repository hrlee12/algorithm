package algorithm.etc;


/*
 * BOJ_2563 색종이
 * 
 * 도화지 위에 색종이의 면적을 구하기. 
 * 
 * "색종이"를 기준으로 생각하면 안되고
 * "도화지"(칠해지는 대상)를 기준으로 생각하기
 * 
 * 도화지의 면적이 100*100임. 
 * 
 * "색종이"를 기준으로 할 때 겹치는 부분을 어떻게 처리하는지가 큰 문제였음. 
 * "도화지"를 기준으로 하면 어차피 한 좌표의 원소는 한개이므로 중복해서 체크해도 문제될 것 없음. 
 * 
 * 각 색종이에 해당되는 좌표를 도화지에 칠하기
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이_이효리 {

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[100][100];
		int length = Integer.parseInt(br.readLine());

		for (int count = 0; count<length; count++) {
			int x, y;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int x_idx = x; x_idx<x+10; x_idx++) {
				for (int y_idx = y; y_idx<y+10; y_idx++) {
					board[x_idx][y_idx] = 1;
				}
			}
		}

		int sum = 0;
		
		for (int row=0; row<100; row++) {

			for (int column=0; column<100; column++) {
				 sum += board[row][column];
			}
		}
		System.out.println(sum);
	}
}
