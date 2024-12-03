package algorithm.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.util.Arrays;


/* 
 * 2인 요소부터 시작해서 역으로 시작 위치를 찾기
 * 
 * 
 * 현재 요소에서 사다리로 연결되어 있는 요소로 옮기는 것을 재귀함수로 구현
 * row가 0이 되면(끝까지 도달) 답을 적고 반환
 * 상하보다 좌우를 우선해서 이동하므로 좌우 먼저 살피고 위쪽 살핌
 * 좌우는 인덱스를 넘지 않는지 검사 +값이 1인지 검사 + 가려는 방향에서 방금 왔는지 검사 -> 모두 참이면 재귀
 * 위쪽은 값이 1인지만 검사 
 * 	- 앞서 재귀를 끝내는 부분에서 행이 0인지 확인하므로 인덱스 범위를 넘을 일이 없음 
 * 
 * 
 * 
 * 변수 정리
 * 
 * 전역변수
 * start_idx : 2인 원소의 좌표
 * result : result의 column값을 저장
 * map : 입력받은 데이터를 담는 배열
 * 
 * 
 * search_ladder의 매개변수
 * row : 현재 원소의 행 좌표값
 * columns : 현재 원소의 열 좌표값
 * horizen_move : 함수를 호출할 때 좌/우 어디로 이동했는지 표시 
 * 					좌로 이동했으면 -1, 우로 이동했으면 1, 위로 갔으면 0
 * 
 * 
 */




public class SWEA_1210_Ladder1_이효리 {

 static int[] start_idx;
 static int result;
 static int[][] map;
 
 
 
 private static void search_ladder(int row, int column, int horizen_move) {
	 // 행이 0이어서 끝에 도달했으면 정답 좌표의 column값 저장. 
	 if (row == 0) {
		 result = column;
		 return;
	 }
	 
	 // 좌로 이동
	 // 좌측이 인덱스 바운드를 넘는지 검사 + 값이 1인지 검사 + 이동하려는 방향에서(좌->우)로 온건지 검사
	 if (column-1>=0 && map[row][column-1]== 1 && horizen_move != 1) {
			 search_ladder(row, column-1, -1);
	 } 
	 // 우로 이동
	 else if (column+1<100 && map[row][column+1] == 1 && horizen_move != -1) {
		 search_ladder(row, column+1, 1);
	 } 
	 // 위로 이동
	 else if (map[row-1][column] == 1) {
		 search_ladder(row-1, column, 0);
	 } 
 }
 
 
 public static void main(String ars[]) throws NumberFormatException, IOException {
	 
	 // 파일을 읽기
	 String file_name = "./input.txt";
	 BufferedReader br = new BufferedReader(new FileReader(file_name));
	 
	 // 테스트케이스 10번 반복
	 for (int tc = 0; tc<10; tc++) {
		 // 테스트케이스마다 데이터를 담을 배열 초기화
		 map = new int[100][100];
		 // 테스트케이스 번호는 버림. 이미 for문의 지역변수 tc가 있음. 
		 br.readLine();
		 
		 // 매 행매다
		 for (int row =0; row <100; row++) {
			 // 한줄을 받아서
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 // 각 원소에
			 for (int column =0; column<100; column++) {
				 // 토큰을 정수로 변환하여 배열에 넣어줌. 
				 int data = Integer.parseInt(st.nextToken());
				 map[row][column] = data;
				 
				 // 다시 반복문 돌 필요 없이 
				 // 데이터 넣을 때 목표 지점인 2인 좌표 저장하기. 
				 if (data == 2) {
					 start_idx = new int[] {row, column};
				 }
			}
		 }
		 
		 // 정답 찾는 함수 돌리고 결과 출력하기
		 search_ladder(start_idx[0], start_idx[1], 0);
		 System.out.printf("#%d %d\n", tc+1, result);
	 }
 }
}