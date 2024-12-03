package 완전탐색;

import java.util.*;
public class 모의고사 {



	class Solution {
		public int[] solution(int[] answers) {
			int[] first = {1, 2, 3, 4, 5};
			// 두번째, 세번째 수험자는 홀수, 짝수 나눠서 생각.
			int[] second = {1, 3, 4, 5};
			int[] third = {3, 1, 2, 4, 5};

			int[] rightCount = new int[3];

			// 그랬더니 각 수험자별 패턴이 달라져서 각자 로직을 짰음.
			for (int idx = 0; idx < answers.length; idx++) {
				// 첫번째 수험자
				if (answers[idx] == first[idx % 5])
					rightCount[0]++;

				// 두번째 수험자
				if (idx % 2 == 0) {
					if (answers[idx] == 2)
						rightCount[1]++;
				} else {
					if (answers[idx] == second[idx / 2 % 4])
						rightCount[1]++;
				}

				// 세번째 수험자
				if (answers[idx] == third[idx / 2 % 5])
					rightCount[2]++;
			}

			// 자바는 맥스 함수로 바로 최댓값을 못 구한다는 사실 ~~
			int max = 0;
			for (int idx = 0; idx < 3; idx++) {
				if (max < rightCount[idx])
					max = rightCount[idx];
			}



			List<Integer> answer = new ArrayList<>();

			for (int idx = 0; idx < rightCount.length; idx++) {
				if (rightCount[idx] == max)
					answer.add(idx+1);
			}


			// 이부분 왠지 꾸리꾸리해서 더 좋은 방법이 있을 거 같아서 지피티한테 물어본거임.
			int[] result = new int[answer.size()];

			for (int idx = 0; idx<answer.size(); idx++){
				result[idx] = answer.get(idx);
			}

			return result;
		}
	}
}
