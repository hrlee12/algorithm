package dfs_bfs;


import java.util.*;
import java.io.*;

public class BOJ_14502_연구소_이효리_live {

	public static int height, width, map[][], max_blank, test_map[][];
	public static List<int[]> virus = new ArrayList<int[]>();
	public static List<int[][]> new_walls = new ArrayList<int[][]>();
	public static int[][] direct = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static int[][] new_wall = new int[3][2];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		map = new int[height][width];
		
		
		for (int row = 0; row < height; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < width; col++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 2) {
					virus.add(new int[] {row, col});
				}
				map[row][col] = input;
			}
		}
		
		
		solution();

	}
	
	public static void solution() {
		pickWall(0, 0);
		
		
		
		for (int cnt = 0; cnt < new_walls.size(); cnt++) {
			test_map = new int[height][width];
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					test_map[row][col] = map[row][col];
				}
			}
			
			for (int idx = 0; idx < 3; idx++) {
				test_map[new_walls.get(cnt)[idx][0]][new_walls.get(cnt)[idx][1]] = 1;
			}
			
			for (int[] vir : virus) {
				dfs(vir[0], vir[1]);
			}
			
			checkBlank();
			
			
			
		}
		
		System.out.println(max_blank);
	}
	
	
	public static void pickWall(int start, int count) {
		if (count==3) {
			int[][] tmp_wall = new int[3][2];
			
			for (int idx = 0; idx <3; idx++) {
				tmp_wall[idx][0] = new_wall[idx][0];
				tmp_wall[idx][1] = new_wall[idx][1];
			}

			
			new_walls.add(tmp_wall);
			return;
		}
		
		int start_row = start / width;
		int start_col = start % width;

		
		for (int row = start_row; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (row == start_row && col < start_col) {
					continue;
				}
				if (map[row][col] != 0) continue;
				
				new_wall[count][0] = row;
				new_wall[count][1] = col;
				
				pickWall(row*width+col+1, count+1);
				
				
			}
		}
		
		
	}
	
	public static void dfs(int row, int col) {
		
		
		for (int dir[] : direct) {
			
			int next_row = row+dir[0];
			int next_col = col+dir[1];
			
			if (next_row < 0 || next_row >= height) continue;
			if (next_col < 0 || next_col >= width) continue;
			if (test_map[next_row][next_col] != 0) continue;
			
			test_map[next_row][next_col] = 1;
			dfs(next_row, next_col);
					
		}
	}
	
	public static void checkBlank() {
		int blank = 0; 
		
		for (int row =0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (test_map[row][col] == 0) blank++;
			}
		}
		
		if (max_blank < blank) 
			max_blank = blank;
	}
}
