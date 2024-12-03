/*
 * 1. 입력값 받기
 * 2. 맵의 빈 공간 중 3개를 조합으로 뽑아서 벽으로 만든다.
 * 3. 모든 바이러스를 bfs(dfs도 무관)로 퍼뜨린다. 
 * 4. 남은 빈 공간의 수를 세서 제일 큰 경우를 출력한다.  
 * 
 */




package dfs_bfs;

import java.util.*;
import java.io.*;

public class BOJ_14502_연구소_이효리 {
	public static int height, width, virus_cnt, max_blank, map[][], test_map[][];
	public static int[][] virus = new int[10][2];
	public static int[][] walls = new int[3][2];
	public static int[][] direction = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static List<int[][]> new_walls = new ArrayList<int[][]>();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 입력값 받기
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		
		
		for (int row = 0; row < height; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < width; col++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 2) {
					virus[virus_cnt][0] = row;
					virus[virus_cnt][1] = col;
					virus_cnt++;
				}
				map[row][col] = input;
			}
		}
		
		

		// 솔루션 실행
		solution();
		
	}	
	
	public static void solution() {


		// 2. 맵의 빈 공간 중 3개를 조합으로 뽑아서 벽으로 만들기
		
		// 맵의 빈 공간 3개 조합 만들기
		make_wall(0, 0);

		
		// 조합의 모든 경우마다
		for (int[][] wall: new_walls) {
			// 원본이 바뀌지 않게 map을 test_map변수에 복사하기
			test_map = new int[height][width];
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					test_map[row][col] = map[row][col];
				}
			}
			
			// 뽑은 조합의 좌표를 벽으로 만들기
			for (int idx = 0; idx < 3; idx++) {
				test_map[wall[idx][0]][wall[idx][1]] = 1;
			}
			
			// 3. 모든 바이러스를 퍼뜨리기
			// 각 바이러스마다
			for (int idx = 0; idx < virus_cnt; idx++) {
				// dfs함수 실행
				runVirus(virus[idx][0], virus[idx][1]);
			}
			
			// 4. 빈 공간의 수를 세서 제일 작다면 기록한다. 
			countBlank();
		
		}
		
		// 결과값 출력
		System.out.println(max_blank);
	}
	
	
	// 빈 공간 3개의 조합 구하는 메서드
	public static void make_wall(int start, int count) {
		
		// 세개를 뽑았다면
		if (count == 3) {
			
			// 좌표들을 복사해서
			int[][] tmp = new int[3][2];
			for (int idx = 0; idx < 3; idx++) {
				tmp[idx][0] = walls[idx][0];
				tmp[idx][1] = walls[idx][1];				
			}
			
			// 리스트에 append
			new_walls.add(tmp);
			
			return;
		}
		
		
		// 시작 행, 열 구하기
		int start_row = start / width;
		int start_col = start % width;
		
		
		// 시작 행부터
		for (int row = start_row; row < height; row++) {
			// 시작 열은 행이 시작행보다 작거나 같을 때만 해당
			for (int col = 0; col < width; col++) {
				if (row == start_row && col <start_col)
					continue;
				
				// 빈 공간이 아니면 패쓰
				if (map[row][col] != 0)
					continue;
				

				// 뽑은 좌표를 저장
				walls[count][0] = row;
				walls[count][1] = col;
				
				// 재귀호출
				// row, col을 하나의 변수로 만들어서 넘기기
				make_wall(row*width+col+1, count+1);
			}
		}
	}
	
	// 해당 바이러스를 퍼뜨리는 메서드
	// dfs
	public static void runVirus(int row, int col) {
		
		for (int[] dir: direction) {
			int next_row = row + dir[0];
			int next_col = col + dir[1];
			
			if (next_row < 0 || next_row >= height) continue;
			if (next_col < 0 || next_col >= width) continue;
			if (test_map[next_row][next_col] != 0) continue;
			
			test_map[next_row][next_col] = 1;
			
			runVirus(next_row, next_col);
		}
	}
	
	// 빈 공간을 세고 제일 많다면 기록하는 메서드
	public static void countBlank() {
		int blank = 0;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (test_map[row][col] == 0)
					blank++;
			}
		}
		
		if (max_blank < blank) {
			max_blank = blank;
		}
	}
}
