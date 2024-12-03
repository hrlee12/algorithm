package algorithm_practice;


/*
 * 밀집 그래프의 경우 인접배열 사용
 * 조회하는게 배열이 더 빠름 + 어차피 거의 다 인접하므로 배열로
 * 
 * 리스트는 조회가 더 느리지만 인접한 애들만 확인하면 됨 -> 희소그래프인 경우는 인접 리스트가 더 빠름
 * 정점이 엄청 많으면(ex. 1만개) 보통 희소 그래프로 주어짐. 
 */


import java.util.*;
import java.util.Map.Entry;
import java.io.*;


public class Bfs_graph_adjArray {

	public static int length;
	public static boolean[][] adj;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static int target = 4;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		length = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		adj = new boolean[length][length];
		visited = new boolean[length];
		
		for (int idx = 0; idx<count; idx++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from][to] = true;
//			adj[to][from] = true;
		}
		
		
		bfs();
//		System.out.println(sb);
		
	}
	
	
	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		int depth = 1;
		
		queue.offer(0);
		queue.offer(-1);
		visited[0] = true;
		
		
		while (!queue.isEmpty()) {
			
			int out = queue.poll();
			if (out == target) {
				System.out.println(depth);
//				break;
			}
			if (out < 0) {
				depth = -1 * out;
				if (queue.size()==0) {
					break;
				}
				queue.offer(out-1);
				continue;
			}
			sb.append(out + " ");
			
			for (int idx=1; idx<length; idx++) {
				if (adj[out][idx] == true && visited[idx] == false) {
					queue.offer(idx);
					visited[idx] = true;

				}
			}
		}
	}
}


/*

7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
  
*/
