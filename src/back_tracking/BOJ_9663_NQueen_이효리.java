package algorithm.back_tracking;

import java.io.*;
import java.util.*;


/*
 * 완전탐색으로 풀면 15!으로 조가 넘는 연산으로 시간초과
 * -> 중간에 답이 아닌 걸 확인하면 더 깊게 탐색을 하지 않고 다음 탐색으로 넘어가는 백트래킹 기법 사용. 
 * 
 * dfs 이용. 
 * 현재 보고있는 가지의 뽑은 녀석들을 바로 확인할 수 있음. 
 * (보통 백트래킹에서 가능성 확인은 현재까지 뽑은 녀석들의 누적된 결과로 알 수 있음)
 * 
 * bfs는 확인이 어려움. (할 수는 있지만 매우매우 번거롭고 비효율적)
 * 
 * 
 * 
 * 
 * N-Queen은 
 * 뽑은 좌표들과 행, 열이 일치하지 않고 대각선의 위치에 있지 않으면 탐색 진행. 
 * 
 * 체스판의 크기 n과 퀸의 개수n이 같으므로 한 행당 하나의 퀸을 위치시킴. 
 * 같은 행에 있으면 안되므로 하나를 뽑으면 다음 퀸은 행을 하나 증가시켜 위치시킴. 
 * 즉, 열의 값만 정하면 됨. 
 * 
 * 
 * 
 * 
 * 가지치기 최적화 시키기
 * 현재 보고 있는 좌표가 괜찮은지 확인하기 위해서는 모든 선택된 좌표들에 대해서 확인해봐야 한다. 
 * -> 연산횟수 많아짐. 
 * 
 * 대각선에 대해 같은 대각선에 있을 때의 규칙이 있음. 
 * 오른쪽-왼쪽 방향 대각선 : 행과 열의 인덱스를 더한 값이 같음. 
 * 					  0~length*2-1의 값. 
 * 왼쪽-오른쪽 방향 대각선 : 행과 열의 인덱스를 뺀 값이 같음. 
 * 					  0-length-1 ~ length-1    ->  + length-1을 하면   0~length*2-1
 * 					   결국엔 확인하는 좌표도 같은 규칙대로 해서 그 인덱스의 값이 true인지 false인지 확인하는 것이므로 ㅇㅋ
 *
 * 이 값을 배열의 인덱스로 사용해서 좌표를 고르면 true로 표시
 *  
 * 열, 대각선 두개를 체크하는 배열을 각각 만들고 
 * 가능성 확인한는 메서드에서 한번씩만 체크해주면 연산횟수 줄어듬
 * 
 * 
 * 
 * 
 *
 */

public class BOJ_9663_NQueen_이효리 {
	// 체스판의 길이(=퀸의 수), 가능한 경우의 수, 뽑은 좌표 저장하는 배열(뽑은 좌표를 출력해볼 수 있음)
	public static int length, result, picked[];
	// 퀸을 놓을 수 있는 좌표인지 확인할 때 쓰이는 배열
	public static boolean[] c_check, right_left_check, left_right_check;
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		length = Integer.parseInt(br.readLine());
		picked = new int[length];
		c_check = new boolean[length];
		// 대각선의 수는 length*2-1
		right_left_check = new boolean[length*2-1];
		left_right_check = new boolean[length*2-1];
		
		
		search(0);
		System.out.println(result);
		
	}
	
	// 백트래킹 탐색 메서드
	public static void search(int row) {

		// 기저조건
		// 퀸을 위치시킬 좌표를 다 고르면 return
		if (row == length) {
//			System.out.println(Arrays.toString(picked));   뽑은 좌표 출력
			result++;
			return;
		}
		
		// 유도파트
		for (int c_idx = 0; c_idx<length; c_idx++) {
			// 가지치기
			// 더 깊게 안 들어가고 다음 경우를 탐색하러 감. 
			if (!isAvailable(row, c_idx))
				continue;
			
			// 가지치기에서 통과하면 현재 좌표를 저장. 
			picked[row] = c_idx;
			
			// 현재 선택한 좌표의 같은 열, 대각선 위치 표시
			// 가지치기에서 사용
			c_check[c_idx] = true;
			right_left_check[c_idx+row] = true;
			left_right_check[c_idx-row+length-1] = true;
			
			// 다음 퀸의 좌표 고르러 감.
			search(row+1);
			
			// 이 좌표에 대한 탐색을 모두 끝냈으므로 원상복귀
			c_check[c_idx] = false;
			right_left_check[c_idx+row] = false;
			left_right_check[c_idx-row+length-1] = false;
	
			
			
		}
	};
	
	// 가지치기 메서드
	public static boolean isAvailable(int row, int column) {
		if (c_check[column] || right_left_check[column+row] || left_right_check[column-row+length-1])
			return false;

		
		return true;
	};
}