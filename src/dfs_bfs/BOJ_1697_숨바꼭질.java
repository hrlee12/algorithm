package dfs_bfs;
/*
<최단거리 찾기 = dfs>

dfs, bfs는 노드를 중복해서 방문하지 않는다.
왜냐, 중복체크를 안하고 중복 방문을 허용한다면
사이클이 존재하는 경우 무한히 탐색하게 됨.
visited를 중복 방문을 방지함으로써 효율적으로 완전탐색을 할 수 있게 됨.


이 상황에서 dfs는 노드를 방문했을 때, 최단거리가 아니게 됨.
bfs는 가까운데 먼저 들리기 때문에 최단거리를 파악할 수 있음.


<내가 처음으로 썼던 방법>
깊이 우선으로 탐색하지만 중복 체크를 안 했음.
이렇게 하면 사이클이 생김. dfs, bfs는 중복 체크가 필수임!!!!!!!!!!1


<범위를 넘어가지 않는지 확인>
분명 노드는 0~ 100,000임.
근데 위치가 그 범위에 드는지 확인을 안 한다면 index out of bound 문제가 생김.
범위 먼저 확인하고 visited 배열에 접근하자.
0~ 100,000을 인덱스로 확인해야 하므로
visited[100001]로 초기화.



처음에 차이가 0또는 음수인 경우, bfs를 안 한 것은 분명 효과적인 방법임.
결국 -1씩 빼서 차이가 답이 되기 때문임.
그러나 절대값을 반환해야 한단 것을 간과했음.

 */



import java.util.*;
import java.io.*;

public class BOJ_1697_숨바꼭질 {

	private static int subin, sibling, gap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		subin = Integer.parseInt(st.nextToken());
		sibling = Integer.parseInt(st.nextToken());

		// subin이 더 클 경우, -1을 차이만큼 하게 됨.
		// 굳이 bfs 안 해봐도 됨.
		gap = sibling - subin;

		if (gap == 0){
			System.out.println(gap);
			return;
		} else if (gap < 0){
			System.out.println( gap * -1);
			return;
		}


		System.out.println(bfs());
	}



	// 최단거리이므로 bfs로 찾기.
	private static int bfs(){

		// 방문 확인 -> 중복 방문 X 필수.
		boolean[] visited = new boolean[100001];
		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[]{0, subin});



		while(true){
			int[] target = queue.poll();

			int location = target[1];
			int second = target[0];


			if (location == sibling){
				return second;
			}

			// +1 탐색
			// 조건 1) 범위 안에 있고
			// 조건 2) 방문하지 않은 노드인 경우
			if (location+1 <= 100000 && !visited[location+1]){
				visited[location+1] = true;
				queue.offer(new int[]{second+1, location+1});
			}

			// -1 탐색
			if (location-1 >= 0 && !visited[location-1]){
				visited[location-1] = true;
				queue.offer(new int[]{second+1, location-1});
			}

			// *2 탐색
			if (location*2 <= 100000 && !visited[location*2] ){
				visited[location*2] = true;
				queue.offer(new int[]{second+1, location*2});
			}
		}
	}
}
