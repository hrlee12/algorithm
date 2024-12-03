package inClass;

/*
 * 인접 행렬로 표현
 */

import java.util.*;

public class AdjMatrixTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V]; // 초기값 0
		// 간선 있으면 1, 없으면 0
		
		for (int i = 0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		for (int[] is: adjMatrix) {
			System.out.println(Arrays.toString(is));
		}
	}

}
