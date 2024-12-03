package algorithm.dfs_bfs;

import java.util.*;
import java.io.*;

public class BOJ_1697_숨바꼭질_이효리 {
	
	public static int start, end;
	public static int[] visited = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dfs();
		
		System.out.println(visited[end]);
	}
	
	
	public static void dfs() {
		Queue<Integer> queue = new LinkedList<>();
		Arrays.fill(visited, -1);
		
		queue.offer(start);
		visited[start] = 0;
		
		while (true) {
			int out = queue.poll();
			if (out == end) {
				break;
			}
			
			if (out*2 <= 100000 && visited[out*2] == -1) {
				queue.offer(out*2);
				visited[out*2] = visited[out]+1;
			}
			if (out-1 >= 0 && visited[out-1] == -1) {
				queue.offer(out-1);
				visited[out-1] = visited[out]+1;
			}
			if (out+1 <= 100000 && visited[out+1] == -1) {
				queue.offer(out+1);
				visited[out+1] = visited[out]+1;
			}		
		}
		

	}
}