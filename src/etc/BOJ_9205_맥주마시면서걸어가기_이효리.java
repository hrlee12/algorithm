/*
 * BFS로 풀었음. 
 * 
 * 배열에 모든 장소의 정보를 저장하고
 * 장소들이 1000미터 이내에 있으면 서로 인접하다고 체크
 * 
 * BFS를 돌렸을 때 축제 장소에 visited가 true면 갈 수 있는 것. 
 * 
 */

package etc;

import java.util.*;
import java.io.*;

public class BOJ_9205_맥주마시면서걸어가기_이효리 {

	public static int[] home, festival;
	public static int[][] place;
	public static int place_length;
	public static boolean adj[][];
	public static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < test_case; tc++) {
			
			place_length = Integer.parseInt(br.readLine())+2;
			
			place = new int[place_length][2];
			adj = new boolean[place_length][place_length];
			visited = new boolean[place_length];
			
	
			for (int idx = 0; idx < place_length; idx++) {
				st = new StringTokenizer(br.readLine());
				place[idx][0] = Integer.parseInt(st.nextToken());
				place[idx][1] = Integer.parseInt(st.nextToken());
			}
			
		
			solution();
		}
	}

	

	public static void solution() {
		make_conn();
		

		boolean result = can_go();
		
		System.out.println(result ? "happy" : "sad");
		
	}
	
	// 인접 배열 만들기
	// 1000미터 이내면 서로 인접함 
	public static void make_conn() {
		
		for (int target = 0; target < place_length; target++) {
			for (int compare = 0; compare < place_length; compare++) {
				if (target == compare) continue;
				
				int dist = Math.abs(place[target][0] - place[compare][0]) + Math.abs(place[target][1] - place[compare][1]);
				
				if (dist <= 1000) {
					adj[target][compare] = true;
					adj[compare][target] = true;
				}
			}
		}
	}

	// BFS돌리고 visited의 마지막 인덱스인 축제 장소가 true이면 true리턴
	public static boolean can_go() {
		
		 Queue<Integer> queue = new LinkedList<>();
		 
		 queue.add(0);
		 visited[0] = true;
		
		 while (!queue.isEmpty()) {
			 int out = queue.poll();
			 
			 for (int idx = 0; idx < place_length; idx++) {
				 	if (out == idx) continue;
					if (adj[out][idx] != true) continue;
					if (visited[idx] == true) continue;
					
					queue.add(idx);
					visited[idx] = true;
			 }
		 }
		 
		 
		 return visited[place_length-1];
	}
	
}
