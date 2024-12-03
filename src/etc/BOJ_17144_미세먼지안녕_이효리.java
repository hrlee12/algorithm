import java.util.*;
import java.io.*;

public class BOJ_17144_미세먼지안녕_이효리 {
	public static int width, height, time, map[][], fresher[], next_map[][];
	public static int[] dy = {0, -1, 0, 1};
	public static int[] dx = {-1, 0, 1, 0};


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());

		map = new int[height][width];
		fresher = new int[2];
		int fresher_idx = 0;
		
		for (int row = 0; row < height; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < width; col++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == -1) {
					fresher[fresher_idx++] = row;
				}
				map[row][col] = input;
			}
		}
		
		int result = solution();
		
		System.out.println(result);
		

		
	}
	
	
	public static int solution() {


		run(0, map);

		
		return getResult();
	}
	
	
	// 시간만큼 진행시키는 메서드
	public static void run(int count, int[][] before_map) {
		if (count == time) return;
		
		
		// 연산결과를 next_map에 저장. 
		next_map = new int[height][width];
		
		
		spread_dust(before_map, next_map);
		
		fresh_air(next_map);
		
		run(count+1, next_map);
	}
	
	public static void spread_dust(int[][] before_map, int[][] next_map) {
		// 연산하기
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (before_map[row][col] == 0) continue;
				if (before_map[row][col] == -1) continue;
				
				int spread_cnt = 0;
				int spread_amount = before_map[row][col] / 5;
				
				for (int dir = 0; dir < 4; dir++) {
					int target_r = row + dy[dir];
					int target_c = col + dx[dir];
					
					if (target_r < 0 || target_r >= height) continue;
					if (target_c < 0 || target_c >= width) continue;
					if (before_map[target_r][target_c] == -1) continue;
				
					next_map[target_r][target_c] += spread_amount;
					spread_cnt++;
				}
				
				next_map[row][col] += before_map[row][col] - spread_cnt * spread_amount;
			}
		}
		
		
		
		next_map[fresher[0]][0] = -1;
		next_map[fresher[1]][0] = -1;
		
	}
	public static void fresh_air(int[][] next_map) {

		// 위쪽 공기청정기
		
		for (int row = fresher[0]-1; row > 0; row--) {
			next_map[row][0] = next_map[row-1][0];
		}
		
		for (int col = 0; col < width-1; col++) {
			next_map[0][col] = next_map[0][col+1];
		}
		
		for (int row = 0; row < fresher[0]; row++) {
			next_map[row][width-1] = next_map[row+1][width-1];
		}
		
		for (int col = width-1; col > 1; col--) {
			next_map[fresher[0]][col] = next_map[fresher[0]][col-1];
		}

		next_map[fresher[0]][1] = 0;
		
		// 아래쪽 공기청정기
		
		for (int row = fresher[1]+1; row < height-1; row++) {
			next_map[row][0] = next_map[row+1][0];
		}
				
		for (int col = 0; col < width-1; col++) {
			next_map[height-1][col] = next_map[height-1][col+1];
		}
		
		for (int row = height-1; row > fresher[1]; row--) {
			next_map[row][width-1] = next_map[row-1][width-1];
		}
		
		for (int col = width-1; col > 1; col--) {
			next_map[fresher[1]][col] = next_map[fresher[1]][col-1];
		}
		
		next_map[fresher[1]][1] = 0;
	
	}
	
	
	public static int getResult() {
		int sum = 0;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				int val = next_map[row][col];
				if (val != -1) {
					sum += val;
				}
			}
		}
		return sum;
	}

}
