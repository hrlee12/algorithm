package algorithm.etc;

/*
 * 분할정복을 하는데 전부 다 탐색하면 시간초과 하는 문제
 * 
 * 우리는 맵의 길이를 알고 있고 타겟의 인덱스를 알고 있으니 굳이 다 탐색할 필요가 없음. 
 * 4분할해서 찾아가기 때문에 4분할 중 어디에 해당하는지 알면 (맵의 길이 /2 보다 target의 인덱스가 작은지 아닌지 확인)
 * 카운트를 임의로 더해줄 수 있음. 
 * 
 * 그렇게 임의로 더해주고 아닌 부분은 탐색 노
 * 해당되는 블럭만 똑같은 방법으로 탐색해주고
 * 마지막 2*2블럭으로 들어가면 네개 중 어느 위치인지 확인해서 1,2,3,4중 더해주고 리턴
 * 
 * 더 작은 블럭으로 들어가서 똑같은 작업을 반복하므로 재귀함수로 풀이. 
 * 
 */

import java.util.*;
import java.io.*;
import java.lang.Math;

public class BOJ_1074_Z_이효리 {
	
	// 현재 보고 있는 맵의 크기인 수의 2의 지수
	public static int length_count;
	// 결과값을 저장할 변수
	// 첫번째 블럭이 0으로 카운트되므로 -1부터 시작
	public static int result = -1;
	// 마지막 2*2블럭일 때 4개 중 어느 블럭인지 판별하는데 쓰일 인덱스
	public static int[][] directions = new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
	
	
	public static void main(String[] args) throws IOException {
		// 데이터 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		length_count = Integer.parseInt(st.nextToken());
		int target_row = Integer.parseInt(st.nextToken());
		int target_column = Integer.parseInt(st.nextToken());
		
		
		// 재귀함수 호출
		search(target_row, target_column, length_count, (int)Math.pow(2, length_count));
		// 결과값 출력
		System.out.println(result);
	}
	
	
	
	public static void search(int target_row, int target_column, int length_count, int length) {
		// 크기가 2*2인 블럭을 보고 있을 때
		if (length_count == 1) {
			// 4개 블럭 중 어느 위치인지 확인하고 위치값 결과변수에 더해주기
			for (int idx = 0; idx<directions.length; idx++) {
				if (target_row == directions[idx][0] && target_column == directions[idx][1]) {
					result += idx+1;
				}
			}
			return;
		}
		
		int half = length/2;
		
		if (target_row < half) {
			if (target_column < half) { // 타겟이 좌상 블럭에 해당할 때
				search(target_row, target_column, length_count-1, half);

			} else {					// 타겟이 우상 블럭에 해당할 때
				result += length*length/4;	// 현재 맵의 1/4만큼의 수 더해주고 다른블럭은 탐색 패쓰
				search(target_row, target_column-length/2, length_count-1, half);
			}
		} else {						// 타겟이 좌하 블럭에 해당할 때
			if (target_column < half) {
				result += length*length/4*2; // 현재 맵의 2/4만큼의 수 더해주고 다른 블럭은 탐색 패쓰
				search(target_row-length/2, target_column, length_count-1, length/2);

			} else {					// 타겟이 우하 블럭에 해당할 때
				result += length*length/4 *3;	// 현재 맵의 3/4만큼의 수 더해주고 다른 블럭은 탐색 패쓰
				search(target_row-length/2, target_column-length/2, length_count-1, length/2);
			}
		}
	}
}
