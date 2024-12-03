package union_find;

/*
 * @author 이효리
 * 
 * <두개의 작업 수행>
 * 
 * 	1) 두개의 집합을 합친다. 
 * 	2) 두개의 원소가 같은 집합에 위치해 있는지 확인한다. 
 * 
 * -> 이 작업들은 결국 특정 원소의 루트를 찾는 find함수를 통해 구현 가능하다. 
 * 
 * 
 * 
 * <시간복잡도와 최적화>
 * 
 * 단순히 트리로 서로소 집합을 구현하면 시간복잡도 O(N)이 되서 시간제한에 맞출 수 없다. 
 * 
 * 서브트리의 수가 작->큰 쪽으로 합쳐 서브트리의 수를 최소로 늘리는 최적화(rank 최적화)를 하면
 * 시간복잡도는 O(logN)이 된다. 
 * (참고로 로그시간은 무적이다. 데이터가 100만개면 20이고 10억이면 30이다. 걍 무적이다.)
 * 
 * 	-> rank최적화를 하고 path압축도 같이 해줄 것이다. 
 * 	(path압축이란 find연산에서 루트를 찾으러 타고 들어간 노드에 대하여 링크가 루트로 바로 이어지게 바꾸는 것이다)
 * 
 * 
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class SWEA_3289_서로소집합_이효리 {
	
	public static int[] parents, ranks;
	
	// 특정 원소가 속한 집합의 루트를 찾는 메서드
	public static int find(int a) {
		// 부모의 인덱스 값을 저장하는 parents배열의 값이 본인이면
		// 더 타고 들어가지 않는 루트 노드이다. 
		if (parents[a] == a) return a;
		
		// 리턴되는 루트 노드의 값으로 탐색한 노드의 링크 모두 바꿈. 
		return parents[a] = find(parents[a]);
	}
	
	
	// 두 원소가 같은 집합에 속하는 확인하는 메서드
	public static int isSame(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 루트 값이 같으면 같은 집합
		if (aRoot == bRoot) 
			return 1;
		else 
			return 0;
	}
	
	
	// 주어진 두 원소가 속한 집합을 합치는 메서드
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 둘이 같은 집합에 속한다면 합칠 필요 없으니 리턴
		if (aRoot == bRoot) return;
		
		// aRoot의 랭크(서브트리)가 더 많으면
		// b집합을 a집합에 이어서 서브트리 늘어나는 것 방지
		if (ranks[aRoot] > ranks[bRoot]) {
			parents[bRoot] = aRoot;
		// 반대로 bRoot의 랭크가 더 많을 때
		} else if (ranks[aRoot] < ranks[bRoot]) {
			parents[aRoot] = bRoot;
		// 둘의 서브트리 수가 같을 때
		// 아무데나 합쳐도 상관없고 합쳐지는 집합은 서브트리 수 하나 늘어남. 
		} else {
			ranks[aRoot]++;
			parents[bRoot] = aRoot;
		}
	}
	
	// 주어진 길이만큼의 수를 각각 단위집합으로 만드는 연산
	public static void make(int n) {
		// 숫자의 수만큼 변수 초기화
		parents = new int[n+1];
		ranks = new int[n+1];
		
		// 초기에는 모두 원소가 하나인 단위집합이므로
		// 본인을 root롤 설정
		for (int idx=0; idx < n+1; idx++) {
			parents[idx] = idx;
		}
		
		// ranks는 초기에 서브트리의 수가 모두 0이므로 초기화 한 그대로 두기
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 입력받기
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc < test_case; tc++) {
			// 스트링빌더로 모아서 한번만 출력
			sb.append(String.format("#%d ", tc+1));
			// 원소의 수, 연산 횟수 입력받기
			st = new StringTokenizer(br.readLine());
			int num_elem = Integer.parseInt(st.nextToken());
			int num_cal = Integer.parseInt(st.nextToken());
			
			// 단위집합 생성
			make(num_elem);
			
			// 연산횟수 만큼 연산
			for (int cal = 0; cal < num_cal; cal++) {
				st = new StringTokenizer(br.readLine());
				// 연산의 타입
				String type = st.nextToken();
				// 연산 대상인 원소
				int elem_a = Integer.parseInt(st.nextToken());
				int elem_b = Integer.parseInt(st.nextToken());
				
				// 타입이 0이면 합집합 만들기
				if (type.equals("0")) {
					union(elem_a, elem_b);
				// 타입이 1이면 두 원소가 같은 집합에 속했는지 확인
				} else if (type.equals("1")) {
					int same = isSame(elem_a, elem_b);
					sb.append(same);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}