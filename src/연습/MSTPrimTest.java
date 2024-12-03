package inClass;

import java.io.*;
import java.util.*;

public class MSTPrimTest {
	
	static int V, adjMatrix[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		adjMatrix = new int[V][V];
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j =0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방문정점 (트리 정점 표시)
		boolean[] visited = new boolean[V];
		int[] minEdge = new int[V];			// 자신과 트리의 정점들 간 최소 간선 비용.
		
		Arrays.fill(minEdge,  Integer.MAX_VALUE); // 최소값 갱신 위해 큰 값으로 세팅
		
		minEdge[0] = 0; // 임의의 0정점을 트리 구성의 시작으로 하기 위해 세팅
		
		int result = 0;
		int min = 0, minVertex = 0;
		
		for (int c = 0; c < V; c++) {
			minVertex = -1;
			min = Integer.MAX_VALUE;
			// step1 : 미방문(비트리) 정점 중 최서간선비용의 정점을 선택
			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > minEdge[i]) {
					minVertex = 1;
					min = minEdge[i];
				}
			}
			
			// step2 : 방문(트리) 정점에 추가
			visited[minVertex] = true;
			result += min;	// 신장트리 비용 누적
			
			// step3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고려
			for (int i = 0; i < V; i++) {
				if (visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}
}

/*
 * 
 * 7시 반 : 밖에서 밥 먹고 집 도착 (다이소 - 거울, 빵집 - 아침 빵, 편의점 - 우유)
 * 9시 : 씻기 완료
 * 10시 : 쓰레기 버리기
 * 11시 : 빨래 개기, 청소
 * 12시 반 : 검사 완료 (몇시간 걸릴지 모름. 아니면 앗싸리 맑은 정신으로 하게 아침에) 
 * 
 * ~ 7시간 수면 ~
 * 
 * 7시 반 : 기상
 * 9시 20분 : 준비하고 밥 먹고 출발
 * 9시 반 : 병원
*/
