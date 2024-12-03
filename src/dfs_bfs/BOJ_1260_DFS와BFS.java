package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1260_DFS와BFS {

	public static int vNumber;
	public static int eNumber;
	public static int startVNumber;
	public static boolean[][] adj;
	public static boolean[] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		vNumber = Integer.parseInt(st.nextToken());
		eNumber = Integer.parseInt(st.nextToken());
		startVNumber = Integer.parseInt(st.nextToken());

		adj = new boolean[vNumber+1][vNumber+1];
		visited = new boolean[vNumber+1];

		for (int idx = 0; idx < eNumber; idx++) {
			st = new StringTokenizer(br.readLine());
			int adjV1 = Integer.parseInt(st.nextToken());
			int adjV2 = Integer.parseInt(st.nextToken());

			adj[adjV1][adjV2] = true;
			adj[adjV2][adjV1] = true;



		}

		// for (int idx = 0; idx < vNumber+1; idx++){
		// 	System.out.println(Arrays.toString(adj[idx]));
		// }
		// System.out.println("dfs");
		dfs(startVNumber);
		System.out.println();

		visited = new boolean[vNumber+1];
		// System.out.println("bfs");
		bfs();
	}


	public static void dfs(int target){

		visited[target] = true;
		System.out.print(target + " ");

		for (int idx = 1; idx < vNumber+1; idx++) {
			if (adj[target][idx] && !visited[idx]){
				dfs(idx);
			}
		}
	}


	public static void bfs(){

		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(startVNumber);
		visited[startVNumber] = true;


		while(!queue.isEmpty()){
			int target = queue.poll();
			System.out.print(target + " ");
			for (int idx = 1; idx < vNumber+1; idx++){
				if (adj[target][idx] && !visited[idx]){
					queue.offer(idx);
					visited[idx] = true;

				}
			}
		}
	}
}
