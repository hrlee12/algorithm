package algorithm_practice;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*
 * 하노이 탑 만들기
 * 
 * 문제
 * 3개의 기둥이 있을 때, 첫번째 기둥의 모든 원반을 마지막 기둥으로 옮기는 문제
 * 
 * 조건
 * 1) 한번에 하나의 원반만 옮길 수 있음. 
 * 2) 원반은 무조건 큰 것 위에 작은 것이 옴. 작은 것 위에 큰 것은 오지 못한다. 
 * 
 * 하노이 탑 문제는 큰 문제를 작게 쪼갤 수 있고 작은 문제가 큰 문제와 같은 문제임. 
 * ex)  원반 4개를 옮기려면 원반 3개를 임시 기둥에 옮기고 (하나의 하노이 탑 문제)
 * 		원반 4를 목표기둥에 옮기고 
 *		원반 3개를 다시 임시기둥에서 목표기둥에서 옮겨야 함. (하나의 하노이 탑 문제)
 * 
 * 이렇게 작은 문제가 하나의 하노이 탑 문제가 될 수 있으므로 재귀함수로 풀 수 있음. 
 * 
 * 돌아오는 시점 : 원반이 한개일 때, 그 원반을 옮겨주고 리턴. 
 * 
 */
public class Hanoi {
	static List<Integer>[] columns = new ArrayList[3];
	

	
	// 사용자 편의성 고려한 오버로딩 함수
	// 최초로 호출할 때 쓰임. 
	private static void  hanoi(int carriedNum) {
		// 초기상태 출력하고 하노이 함수 호출
		System.out.printf("기둥 상태 : %s  %s  %s\n", columns[0], columns[1], columns[2]);
		hanoi(carriedNum, 0, 2, 1);
	}
	
	
	
	private static void hanoi(int carriedNum, int start_column, int target_column, int tmp_column) {
		
		// 옮기는 원반이 1개이면 그 원반을 옮기고 리턴
		if (carriedNum == 1) {
			movePlate(carriedNum, start_column, target_column);
			return;
		}
		

		// 옮기고자 하는 원반의 전 원반(N-1)까지를 임시기둥으로 옮김. 
		hanoi(carriedNum-1, start_column, tmp_column, target_column);
		
		// 원반 N을 목표 원반으로 옮김.  
		movePlate(carriedNum, start_column, target_column);
		
		// 임시로 옮겨둔 N-1까지의 원반을 목표 원반으로 옮김. 
		hanoi(carriedNum-1, tmp_column, target_column, start_column);
	}
	
	
	
	// 원반을 옮기는 함수
	private static void movePlate(int moveNum, int start, int target) {
		columns[start].remove(Integer.valueOf(moveNum));
		columns[target].add(moveNum);
		System.out.printf("기둥 상태 : %s  %s  %s\n", columns[0], columns[1], columns[2]);
	}
	
	
	
	
	
	public static void main(String args[]) {
		// 기둥 배열을 초기화함. 
		for (int i=0; i<columns.length; i++) {
			columns[i] = new ArrayList<Integer>();
		}
		
		
		// 원반의 수를 입력받음. 
		Scanner in = new Scanner(System.in);
		int hanoi_num = in.nextInt();
		
		// 원반을 첫번째 기둥에 순서대로 넣어줌. 
		for (int i=hanoi_num; i>0; i--) {
			columns[0].add(i);
		}
		
		
		hanoi(hanoi_num);
	}
}