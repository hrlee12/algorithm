package algorithm.dfs_bfs;

/*
 * 인접한 노드에 대한 정보 있고
 * 완전 탐색 해야 되고
 * 방문한 노드 다시 방문 안 하고.
 * 한 깊이씩 방문하고
 * 
 * -> bfs
 * 
 * 마지막깊이에서 방문한 노드들 중 가장 큰 수 출력
 * 
 * 
 */


import java.util.*;
import java.io.*;

public class SWEA_1238_Contact_이효리 {

	public static Map<Integer, List<Integer>> adj = new HashMap<>();
	public static int[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 0; tc < 10; tc++) {
			adj.clear();
			visited = new int[101];
			Arrays.fill(visited, -1);
			
			st = new StringTokenizer(br.readLine());
			int adj_length = Integer.parseInt(st.nextToken());
			int start_node = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int adj_count = 0; adj_count < adj_length/2; adj_count++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (!adj.containsKey(from)) {
					adj.put(from, new ArrayList<Integer>());
				}
					
					adj.get(from).add(to);
			}

			int result = bfs(start_node);
			sb.append(String.format("#%d %d\n",  tc+1, result));
			

		}
		System.out.println(sb);
		
	}
	
	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		visited[start] = 0;
		
		int depth_count = 0;
		
		while (!queue.isEmpty()) {
			
			int out = queue.poll();
			depth_count = visited[out];
			
			if (!adj.containsKey(out)) continue;
			
			for (int idx = 0; idx < adj.get(out).size(); idx++) {
				int adj_node = adj.get(out).get(idx);
				if (visited[adj_node] != -1) continue;
				queue.offer(adj_node);
				visited[adj_node] = depth_count+1;
				
			}
		}
		
		int max_one = 0;
		
		for (int idx = 0; idx < 101; idx++) {
			if (visited[idx] == depth_count) {
				if (max_one < idx) max_one = idx;
			}
		}
		
		return max_one;
	}
}