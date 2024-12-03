package algorithm_practice;

public class DisjointSet {
	
	public static int N;
	public static int[] parents, ranks;
	
	
	// 서로소 단위집합 만들기
	public static void make() {
		parents = new int[10];
		ranks = new int[10];
		
		for (int idx = 0; idx < N; idx++) {
			parents[idx] = idx;
		}
	}
	
	
	// 해당 원소가 속한 집합의 root 찾기
	public static int find(int a) {
		// 스스로를 가리키고 있다면 루트 노드이다. 
		if (parents[a] == a) return a;
		
		// 경로 압축
		// 루트를 찾기 위해 따라 올라가면서  탐색한 노드에 대해 바로 루트로 연결될 수 있도록 대입을 해준다. 
		// 반환되는 값 = 루트
		return parents[a] = find(parents[a]);		
	}
	
	
	// 두 집합을 하나로 합치기
	public static boolean union(int a, int b) {
		// 각 집합의 루트를 찾는다. 
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 루트가 같다면 같은 집합이므로 합치지 않고 리턴한다. 
		if (aRoot == bRoot)
			return false;
		
		// 트리의 깊이를 늘리지 않기 위해 랭크가 높은 쪽으로 붙인다. 
		// 트리의 깊이가 작을수록 루트를 찾기 위해 하는 연산이 줄어듬. 
		if (ranks[aRoot] > ranks[bRoot]) {
			parents[bRoot] = aRoot;
		} else if (ranks[aRoot] < ranks[bRoot]){
			parents[aRoot] = bRoot;
		// 깊이가 같은 경우 둘 중 아무쪽으로 합치든 상관없고
		// 트리의 깊이가 하나 늘어난다. 
		} else {
			parents[bRoot] = aRoot;
			ranks[aRoot]++;
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		N = 10;
		
	}
}