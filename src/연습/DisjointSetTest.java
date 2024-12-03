package inClass;

public class DisjointSetTest {
	
	static int N;	// 초기 집합의 개수
	static int parents[];
	
	public static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			// 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다. (자신이 곧 대표자인 루트로 표현)
			parents[i] = i;	
		}
	}
	
	private static int find(int a) {
		if (a==parents[a]) return a;
		return parents[a] = find(parents[a]);	// path compression
	}
	
	// a가 속한 집합과 b가 속한 집합을 합칠 수 있다면 합치고 true 반환
	// 아니면 false 반환
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 서로의 대표자가 같음. 
		// 즉, 같은 집합이므로 union 하지 않음. 
		if (aRoot==bRoot) return false;
		
		// bRoot 집합을 aRoot 밑으로 합침. 
		// 최적화 안 된 버전. 
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		N = 10; 
		
		make();
		
		for (int idx = 0; idx < N; idx++) {
		System.out.println(find(idx));
		}

		
		union(1, 2);
		union(2, 3);
		union(3, 4);
		
	}

}
