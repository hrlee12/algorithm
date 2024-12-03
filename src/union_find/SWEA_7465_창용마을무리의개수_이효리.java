package union_find;
/*
 * 
 * 그래프에서 몇개의 뭉탱이가 있는지 구하는 문제
 * -> union-find 문제 
 * 
 * 
 * 데이터는 배열로 구현한 트리로 이어져있음. 
 * 인덱스에는 가리키고 있는 요소의 번호를 적음. 
 * 
 * 
 * 
 * <필요한 메서드>
 * 루트를 반환하는 메서드 -> 같은 무리인지 확인 가능
 * 
 * 초기세팅 : parent, rank배열 만들기. rank배열은 모두 0로 초기화(가만히 두기), parent배열은 자기 자신의 인덱스로 초기화. 
 * 
 * 삽입 메서드 : 뭉탱이의 루트끼리 연결함
 * 			 먼저 같은 뭉탱이인지 확인하고 아니라면 (isSame메서드로 빼기)
 * 			 루트의 parent를 다른 녀석의 parent로 바꿔줌. 
 *			 여기서 rank배열(단말노드까지의 깊이)을 가지고 rank가 더 낮은 쪽에서 높은 쪽으로 붙여 탐색 횟수 줄이기
 * 
 * 루트 확인 : 루트 노드 반환
 * 			union-find는 뭉탱이인지만 확인하면 되고 누가 누구랑 인접한지는 상관 없으므로 
 * 			경로 압축(path compression)을 통해 루트찾을 때 거친 노드의 부모를 모두 root로 바꿔줌. 
 */

import java.util.*;
import java.io.*;


public class SWEA_7465_창용마을무리의개수_이효리 {

	public static int len_node, len_link, parents[], ranks[];
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			len_node = Integer.parseInt(st.nextToken());
			len_link = Integer.parseInt(st.nextToken());
			
			init(len_node);
			
			for (int link = 0; link < len_link; link++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			int result = getCount();
			
			System.out.printf("#%d %d\n", tc+1, result);
		}
	}
	
	public static void init(int num) {
		parents = new int[num+1];
		ranks = new int[num+1];
		
		// 최초에는 스스로를 가리키는 있는 집합들.
		for (int idx = 0; idx < num+1; idx++) {
			parents[idx] = idx;
		}
	}
	
	public static int find(int num) {
		if (parents[num] == num) return num;
	
		// 경로 압축
		return parents[num] = find(parents[num]);
	}
	
	public static boolean isSame(int a, int b) {
		// 루트가 같으면 같은 뭉탱이임. 
		if (find(a) == find(b)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void union(int a, int b) {
		if (isSame(a, b)) return;
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (ranks[aRoot] > ranks[bRoot]){
			parents[bRoot] = aRoot;
		} else if (ranks[bRoot] > ranks[aRoot]) {
			parents[aRoot] = bRoot;
		} else {
			parents[aRoot] = bRoot;
			ranks[bRoot]++;
		}
	}
	
	public static int getCount() {
		int count = 0;
		
		for (int idx = 1; idx < len_node+1; idx++) {
			if (parents[idx] == idx) count++;
		}
		
		return count;
	}
}
