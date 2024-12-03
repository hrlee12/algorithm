package inClass;

import java.io.*;
import java.util.*;

/*
 * 같은 행에는 퀸을 놓지 않는 버전
 * _
 * 놓아진 퀸의 열번호를 기록하는 버전
 */

public class NQueenTest1 {

	static int N, col[], ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1]; // 1행부터 사용
		ans = 0; // 가능한 경우의 수
		
		setQueen(1);
		System.out.println(ans);
	}

	// 해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
	private static void setQueen(int row) {	// row : 퀸을 놓으려는 행
		
		// 가지치기 : 직전까지 놓아진 상태로 
		if(!isAvailable(row-1)) return;
		
		// 기저조건
		if (row > N) {
			ans++;
			return;
		}
		
		// 최적화시키는 코드
		// 같은 행, 대각선 두 개 : 각각 boolean배열을 만들어서 체크해두고 여기서 확인.  
		// 같은 행 : boolean배열에 행에 체크. 
		// 오른쪽-왼쪽 대각선 : 행과 열 인덱스의 합이 같음. 
		// 왼쪽-오른족 대각선 : 행과 열 인덱스의 차이가 같음. 
		
		// 유도파트
		for (int c =1; c <= N; c++) {	// 1열부터 N열까지 시도
			col[row] = c;
			setQueen(row+1);
		}
	}
	
	
	private static boolean isAvailable(int row) {	// row : 마지막으로 놓아진 행의 퀸

		
		// 최적화하면 모든 선택된 퀸에 대해서 X
		// 각 체크항목의 배열에 대해서 한번만 확인하면 됨. -> 최적화 Good
		
		// 최적화 X
		// 모든 선택된 퀸에 대해 for문으로 체크
//		for (int i=1; i<row; i++) {
//			if (col[i] == col[row] || row-i == Math.abs(col[i]-col[row]) )
//				return false;
//		}
		
		return true;
	}
}