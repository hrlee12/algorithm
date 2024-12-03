/*
 * 완전탐색의 연산횟수 구하기
 * 
 *  9^81로 시간이 터지지만 백트래킹을 믿어보자. 
 *  
 * 
 * 
 * 
 * <빈칸의 값을 정할 때 고려할 점>
 * 
 * 1) 행, 열, 섹션(3*3)에서 겹치는 수가 없는가?
 * 
 * 
 * 2) 이 값을 할당했을 때 스도쿠를 완성할 수 있는가?
 * 
 * - 한 빈칸의 값을 정할 때도 전체가 가능한지 확인해야 하므로 
 *   확인하는 메서드를 재귀적으로 호출하도록 설계
 *   
 * - 빈칸들을 순서대로 확인하며 빈칸에 값을 채울 수 없을 때(1번 조건 미충족)는 
 * 	 false를 반환해서 그 전 호출로 돌아가서 다음 수를 확인해본다. 
 * 
 * 
 * 
 * 
 * <흐름>
 * 1) 입력값을 받으면서 빈칸의 좌표를 저장. 
 * 2) 첫번째 빈칸부터 1~9를 순서대로 넣어보며 가능한지 확인한다. 
 * 	2-1) 행, 열, 섹션에서 겹치는 수가 없는가?
 * 		-> 거짓 -> 다음 수 넣어보기
 * 		-> 참 -> 2-2	
 * 2-2) 빈칸에 이 값을 넣었을 때 스도쿠를 완성시킬 수 있는가?
 * 		-> 다음 빈칸을 채울 수 있는가?(재귀) -> 2번으로 가기
 * 3) 완성된 스도쿠를 출력한다. 

 * 
 * 
 * 첫번째 빈칸부터 1부터 할당해보므로 자동적으로 완성된 스도쿠를 나열했을 때 가장 작은 수가 된다.  
 */




package etc;

import java.util.*;
import java.io.*;

public class BOJ_2239_스도쿠_이효리 {
	public static int[][] sudoku = new int[9][9];
	public static ArrayList<int[]> blanks = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		for (int row = 0; row < 9; row++) {
			String line = br.readLine();
			for (int col = 0; col < 9; col++) {
				int input = line.charAt(col) - '0';
				if (input == 0) blanks.add(new int[] {row, col});
				sudoku[row][col] = input;
			}
		}
		
//		for (int row = 0; row < 9; row++) {
//			System.out.println(Arrays.toString(map[row]));
//		}
//		
//		for (int idx = 0; idx < blanks.size(); idx++) {
//			System.out.println(Arrays.toString(blanks.get(idx)));
//		}
		
		run(0);
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				System.out.print(sudoku[row][col]);
			}
			System.out.println();
		}
		
	}

	// 결과적으로 sudoku를 완성시킬 수 있는가? 
	public static boolean run (int count) {
		if (count == blanks.size()) return true;
		
		// count번째 빈칸의 좌표값 가져오기
		int row = blanks.get(count)[0];
		int col = blanks.get(count)[1];
		
		// 빈칸에 1~9를 넣어보면서 가능한지 확인
		for (int value = 1; value <10; value++) {
			sudoku[row][col] = value;
			// 나만 되면 되는게 아니라 다른 애들도 되는지 확인
			// 현재 빈칸에 value를 넣었을 때 sudoku를 완성할 수 있는지 마지막 blank까지 확인
			// 중간에 안되는 blank가 있으면 false리턴하고 돌아옴(백트래킹) ->  다음 value로 확인
			if (isValid(row, col))
				if (run(count+1)) 
					return true;
		}
		
		// 백트래킹
		// 기저조건
		sudoku[row][col] = 0;
		return false;
	}
	
	// blank의 행, 열, section에 겹치는 숫자가 없는지 확인
	private static boolean isValid(int row, int col){
		   // 행, 열에 겹치는 게 있는가?
		   for(int idx = 0; idx < 9; idx++){
			  // 열 체크
		      if(row != idx && sudoku[idx][col] == sudoku[row][col]) return false;
		      
		      // 행 체크
		      if(col != idx && sudoku[row][idx] == sudoku[row][col]) return false;
		   }
		 
		   // 섹션 체크
		   for(int box_row = (row/3)*3,cnt_r = 0; cnt_r < 3; box_row++, cnt_r++){
		      for(int box_col = (col/3)*3, cnt_c=0; cnt_c<3; cnt_c++, box_col++){
		         if(box_row != row && box_col != col && sudoku[box_row][box_col]==sudoku[row][col]) return false;
		      }
		   }
		 
		   // 모든 역경과 고난을 겪고 극복했다면 true 리턴
		   return true;
		}
}



