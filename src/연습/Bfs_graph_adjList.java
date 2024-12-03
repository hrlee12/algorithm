package algorithm_practice;

import java.util.*;
import java.io.*;

public class Bfs_graph_adjList {
	public static int length;
	public static Map<Integer, List<Integer>> adj = new HashMap<>();
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static int target = 2;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		length = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		visited = new boolean[length];
		
		for (int idx = 0; idx<count; idx++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (!adj.containsKey(from)) {
				adj.put(from, new ArrayList<>());
			}
			adj.get(from).add(to);

		}
		
		System.out.println(adj);
		bfs();
//		System.out.println("result : " + sb);
		
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
				break;
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
			
			if (!adj.containsKey(out))
				continue;
			
			
			List<Integer> out_adj = adj.get(out);
			
			
			for (int idx=0; idx<out_adj.size(); idx++) {

				int to = out_adj.get(idx);
				if (visited[to] == false) {
					queue.offer(to);
					visited[to] = true;
//
//					System.out.println("out : " + out  + "to : " + to);
//					System.out.println(queue);
//					System.out.println("visited : " + Arrays.toString(visited));
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
