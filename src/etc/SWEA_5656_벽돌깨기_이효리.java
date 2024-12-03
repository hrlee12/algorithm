
import java.util.*;
import java.io.*;

public class SWEA_5656_벽돌깨기_이효리 {

	public static int count, width, height, result, map[][], shoot_col[];
	public static boolean first, second, third;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			
			count = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
		
			map = new int[height][width];

		
			for (int row = 0; row < height; row++) {
				st = new StringTokenizer(br.readLine());
				
				for (int col = 0; col < width; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			
			
		}

			
			result = 10000000;
			
			dfs(0, map);
			System.out.println("#" + (tc+1) + " " + result);	

	}

	}
	
	// 공의 수만큼 들어감
	// width를 처음부터 끝까지 중복되게 다 탐색함. 
	public static void dfs(int ball_cnt, int[][] run_map) {
		if (ball_cnt == count) {
			int tmp = count_left_brick(run_map);
			if (tmp < result) 
				result = tmp;

			return;
		}
		
		
		for (int col = 0; col < width; col++) {	
			

			int[][] next_map = new int[height][width];
			
			for (int row = 0; row < height; row++) {
				for (int c = 0; c < width; c++) {
				next_map[row][c] = run_map[row][c];
				}
			}
		
		
			shoot(col, next_map);


			// 재귀 호출
			dfs(ball_cnt+1, next_map);
		}
	}
	
	
	// col 좌표가 주어지면 가장 row가 작은 벽돌을 맞춘다. 
	public static void shoot(int target_col, int[][] run_map) {
		
		for (int row = 0; row < height; row++) {
			if (run_map[row][target_col] != 0) {
				
				pop(row, target_col, run_map);
				break;
			}
		}
		
		fall(run_map);
	}
	
	public static void pop(int row, int col, int[][] run_map) {
		
			int pop_length = run_map[row][col]-1;
			
			run_map[row][col] = 0;
			
			if (pop_length == 0) return;
			
			// 가로 pop
			for (int col_pop = col - pop_length; col_pop <= col+pop_length; col_pop++) {
				
				if (col_pop < 0) continue;
				if (col_pop >= width) break;
				
				if (run_map[row][col_pop] != 0) {
					pop(row, col_pop, run_map);
				}
			}
						
			// 세로 pop
			for (int row_pop = row - pop_length; row_pop <= row + pop_length; row_pop++) {
				if (row_pop < 0) continue;
				if (row_pop >= height) break;
				
				if (run_map[row_pop][col] != 0) {
					pop(row_pop, col, run_map);
				}
			}
		
	}
	
	// 벽돌 내리기
	public static void fall(int[][] run_map) {
		
		for (int col = 0; col < width; col++) {
			// 벽돌이 내려올 위치
			int blank_row = -1; 
			
			// 밑에서부터 확인
			for (int row = height-1; row >= 0; row--) {

				
				// 처음 발견한 빈칸이면
				// 내려올 위치를 현재 빈칸으로
				if (run_map[row][col] == 0 && blank_row == -1) {
					blank_row = row;
				}
				
				
				
				// 벽돌이고 현재 내려올 빈칸이 있으면
				if (run_map[row][col] != 0 && blank_row != -1) {
					
					// 빈칸으로 벽돌을 내려줌. 
					run_map[blank_row][col] = run_map[row][col];
					run_map[row][col] = 0;
					
					// 빈칸 윗 칸이 다음 내려올 위치가 됨. 
					blank_row -= 1;
				}
				
				
				// 빈칸이지만 밑에 이미 있다면 아무 일도 안 일어남. (밑에 떨어지니까)
				
				// 벽돌이지만 밑에 빈칸이 전혀 없다면 아무 일도 안 일어남. 
			}
		}
	}
	
	
	// 남은 벽돌의 수를 반환하는 함수
	public static int count_left_brick(int[][] run_map) {
		int left_brick = 0; 
		
		// 열별로 바닥부터 확인(row 큰 수부터)해서 0이 나오면 위에도 없으므로 다음 열로 넘어가기
		for (int col = 0; col < width; col++) {
			for (int row = height-1; row >= 0; row--) {
				if (run_map[row][col] ==0) break;
				
				left_brick++;
			}	
		}
		return left_brick;
	};
}
