package inClass;

import java.util.*;
import java.io.*;

public class MSTKruskalTest {
	
	// 간선 중심으로 그래프 표현
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
		 // return this.weight - o.weight;
			return Integer.compare(this.weight,  o.weight);
		}
		
	}

	static Edge[] edgeList;
	static int V, E;
	static int[] parents;
	
	static void make() {
		parents = new int[V];
		for (int i = 0; i <V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a]==a) return a;
		
		return parents[a] = find(parents[a]); 
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		for (int i= 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		// 간섭리스트를 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		// V개의 정점으로 make set 작업
		make();
	
		int result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == V-1) break;
			}
		}
		System.out.println(result);
	}

}


/*

15 10
20 1 5
30 2 10
40 3 8
50 4 7
61 2 5
71 3 3
81 4 6
92 3 1
102 4 3
113 4 1

output ==> 10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

*/