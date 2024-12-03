package algorithm.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		// 데이터 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
	
		for (int tc = 0; tc <test_case; tc++){
			// 입력받은 사이즈로 이중 배열 선언 
			int size = Integer.parseInt(br.readLine());
			int farm[][] = new int[size][size];
			
			// 각 행 단위로 데이터를 입력받고 정수로 바꿔서 배열의 각 원소에 넣어줌. 
			for (int row = 0; row <size; row++){
				String input = br.readLine();
				for (int column = 0; column<size; column++) {
					farm[row][column] = Character.getNumericValue(input.charAt(column));
				}

			}
			
			
		// 각 줄에서 특정한 길이만큼 앞뒤로 제외하고 수확함.
		// 그 길이를 tab_size라고 하자. 
		// 첫번째 줄은 tab_size가 size/2 -> tab_size부터 size-tab_size 전까지 수확 대상. 
		// 중간줄(size/2)전까지는 tab_size를 1씩 줄임.
		// 중간줄(size/2)부터는 tab_size를 1씩 늘임. 
		int sum = 0;
		int middle_row = size / 2;
		int tab_size = size / 2;

		for (int row=0; row<size; row++){
			for (int idx = tab_size; idx<size-tab_size; idx++) {
				sum += farm[row][idx];				
			}
			tab_size = row < middle_row ? tab_size-1 :tab_size+1;
		}
		
		System.out.printf("#%d %d\n", tc+1, sum);
			
		}
	}
}
