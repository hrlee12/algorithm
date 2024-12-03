package DFS_BFS;

import java.util.LinkedList;
import java.util.List;

public class 게임맵최단거리_BFS {

	public static void main(String args[]) {
		System.out.println(
			Solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}

	class Solution {

		public static int[][] map;
		public static int[][] adj = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

		public static int solution(int[][] maps) {
			map = maps;
			return bfs();
		}

		public static int bfs(){

			List<int[]> queue = new LinkedList<>();
			queue.add(new int[]{0, 0, 1});

			while(!queue.isEmpty()){
				int[] cur_location = queue.remove(0);
				int row = cur_location[0];
				int col = cur_location[1];
				int dist = cur_location[2];

				if (row == map.length-1 && col == map[0].length-1){
					return dist;
				}


				for (int idx = 0; idx < 4; idx++) {
					int next_row = row + adj[idx][0];
					int next_col = col + adj[idx][1];

					if (next_row < 0 || next_row >= map.length) continue;
					if (next_col < 0 || next_col >= map[0].length) continue;
					if (map[next_row][next_col] == 0) continue;

					map[next_row][next_col] = 0;


					queue.add(new int[]{next_row, next_col, dist+1});
				}
			}

			return -1;
		}
	}
}
