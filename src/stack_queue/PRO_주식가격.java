package stack_queue;


/*
주식 값이 배열로 주어질 때, 떨어지지 않은 날이 얼마인지 각각 날짜별로 배열로 리턴하는 문제

나는 이걸 풀 때, 첫째 날짜를 고정하고 구하는 게 아니라 모든 날짜에 대해서 돌아가면서 확인하면서 날짜를 하나씩 더해주게 풀었음.
하지만 이런 방법도 있음 !
 */




import java.util.*;
public class PRO_주식가격 {
	public static void main(String[] args) {

	}


	class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];

			// 첫째 날짜부터 고정
			for(int i = 0; i < answer.length; i++) {
				// 그래서 첫째 날짜는 얼마나 되는고?
				for(int j = i + 1; j < answer.length; j++) {
					// 일단 냅다 하나 더하고
					answer[i]++;

					//
					if(prices[i] > prices[j]) break;
				}
			}

			return answer;
		}
	}
}
