package algorithm.combination;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class SWEA_1954_달팽이숫자_이효리 {
	private static int[][] snail;
	private static int length;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<test_case; tc++) {
			// 각 테스트케이스마다 배열의 크기 받아서 snail_number함수 호출
			length = Integer.parseInt(br.readLine());
			snail = new int[length][length];
			snail_number(0, 0, 0, "right");
			
			System.out.printf("#%d\n", tc+1);
			
			// 결과값 출력
			for (int snail_r = 0; snail_r<length; snail_r++) {
				for (int snail_c = 0; snail_c<length; snail_c++) {
					System.out.printf("%d ", snail[snail_r][snail_c]);
				}
				System.out.println();
			}
		}
	}
	
	
	/*달팽이 숫자를 생성하는 메서드
	 * 
	 * 매개변수
	 * count : 현재 몇번째 원소인지
	 * row : 현재 원소의 행
	 * column : 현재 원소의 열
	 * direction : 진행방향
	 * 
	 * 
	 * direction(현재 진행방향)을 기준으로 인덱스를 넘어가면 방향을 틀어준다. 
	 *  + 이미 값이 있는 원소의 경우에도 방향을 틀어준다. 
	 */
	private static void snail_number(int count, int row, int column, String direction) {
		// 배열의 원소를 다 채우면 리턴
		if (count == length*length) 
			return;
		
		// 원소 넣기
		snail[row][column] = count+1;
		
		
		// 각각의 현재 진행방향 별로 진행
		if (direction == "right") {
			// 현재 진행방향대로 가면 인덱스가 범위를 넘거나 이미 값을 지정한 원소의 값을 바꾸는 경우 
			if (column+1 >= length || snail[row][column+1] != 0) {
				// 방향을 아래로 바꾸어 원소의 값 지정. 
				snail_number(count+1, row+1, column, "down");
			// 현재 진행방향에 문제 없으면 그대로 진행
			} else {
				snail_number(count+1, row, column+1, "right");
			}
		} else if (direction == "down") {
			if (row+1 >= length || snail[row+1][column] != 0) {
				snail_number(count+1, row, column-1, "left");
			} else {
				snail_number(count+1, row+1, column, "down");
			}
		} else if (direction == "left") {
			if (column-1 < 0 || snail[row][column-1] != 0) {
				snail_number(count+1, row-1, column, "up");
			} else {
				snail_number(count+1, row, column-1, "left");
			}
		} else if (direction == "up") {
			if (row-1 < 0 || snail[row-1][column] != 0) {
				snail_number(count+1, row, column+1, "right");
			} else {
				snail_number(count+1, row-1, column, "up");
			}
		}
	}
}
