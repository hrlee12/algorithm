package algorithm.linkedList;

/*
 * 데이터를 담은 리스트의 맨 마지막 원소 다음에 첫번째 원소로 연결하는 문제
 * 
 * 데이터의 길이가 정해져 있어 배열로 풀고 뺀 수를 0으로 처리해도 되지만
 * 비순차적으로 데이터를 삭제할 때 빠르게 동작하는 linkedList를 사용하였다. 
 * 
 * 
 * 리스트의 길이가 0이 될 때까지 모든 원소를 돌아가면서 탐색. 
 * 
 * 
 */


import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1158_요세푸스문제_이효리 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		int length = sc.nextInt();
		final int GAP = sc.nextInt();
		
		// 몇번째 원소인지 카운트하는 변수
		// 첫번째 원소는 한번 카운트 되므로 바로 1부터 시작. 
		int gap_count = 1;
		// 리스트에서 현재 몇번째 인덱스인지 알려주는 변수
		int current_idx = 0;
		
		
		
		
		// 처음에 데이터를 담고 있을 리스트
		List<Integer> circle = new LinkedList<>();

		
		for (int i=1; i<=length; i++) {
			circle.add(i);
		}
		
		// 스트링빌더에 바로 답을 넣을거임. 
		sb.append("<");
		
		// 리스트에 원소가 남아있는 동안
		while (circle.size() != 0) {
			
			// 인덱스가 마지막을 넘으면 다시 첫번째 인덱스로
			if (current_idx == length) {
				current_idx = 0;
			}
			
			
			// 현재 카운트가 다 됐으면
			if (gap_count == GAP) {
				// 출력준비하고 
				sb.append(circle.get(current_idx) + ", ");
				// 0부터 다시 세기
				gap_count = 0;
				// 링크드리스트의 원소 하나 삭제하므로 길이도 빼주기
				length--;
				// 원소 삭제
				circle.remove(current_idx);
				
			} else {
				// 삭제한 경우는 현재 인덱스 그대로 뒤의 인덱스를 가리키므로 그대로 놔두고
				// 삭제하지 않은 경우만 인덱스 값 더하기
				current_idx++;
			}
			
			gap_count++;
		}
			
			// 마지막에 입력된 ", " 빼주기
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);

			sb.append(">");
		
			System.out.println(sb);
	}	
}