package dfs_bfs;

public class PRO_게임맵최단거리 {
	public static void main(String[] args) {

		int result = Solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});

		if (result == 100000)
			System.out.println(-1);
		else
			System.out.println(result);

		// result 가 0이면 return -1
	}


	class Solution {
		public static int[][] map;
		public static int result = 100000;
		public static int[][] adj = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

		public static int solution(int[][] maps) {

			map = maps;

			dfs(0, 0, 1);

			return result;
		}

		public static void dfs(int row, int col, int count) {
			if (row == map.length-1 && col == map[0].length-1){
			// System.out.println("row : " + row + " col : " + col + " count : " + count);
				if (result > count)
					result = count;

				return;
			}


			for (int idx = 0; idx < 4; idx++) {
				int next_row = row + adj[idx][0];
				int next_col = col + adj[idx][1];

				if (next_row < 0 || next_row >= map.length) continue;
				if (next_col < 0 || next_col >= map[0].length) continue;
				if (map[next_row][next_col] == 0) continue;

				map[next_row][next_col] = 0;
				dfs(next_row, next_col, count+1);
				map[next_row][next_col] = 1;
			}
		}
	}
}
