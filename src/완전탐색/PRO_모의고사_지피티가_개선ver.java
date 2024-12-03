package 완전탐색;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_지피티가_개선ver {

	public class Solution {
		public int[] solution(int[] answers) {
			// 언제부터 다차원 배열일 때, 길이가 들쑥날쑥이어도 됐던거냐
			// -> 원래 됐음. 비정형 배열
			// 나는 두번째, 세번째 수험자는 짝수일 때, 홀수일 때를 나눠서 생각했는데
			// 굳이 그렇게 안해도 그냥 패턴 그대로 배열에 넣고 그 길이만큼 돌려도 되는구나
			int[][] patterns = {
				{1, 2, 3, 4, 5}, // 첫 번째 수험자의 답안 패턴
				{2, 1, 2, 3, 2, 4, 2, 5}, // 두 번째 수험자의 답안 패턴
				{3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 세 번째 수험자의 답안 패턴
			};

			int[] score = new int[3]; // 각 수험자의 정답 개수를 저장할 배열

			// 모든 문제에 대해 각 수험자의 답안을 확인하고 점수 계산
			for (int i = 0; i < answers.length; i++) {
				for (int j = 0; j < 3; j++) {
					if (answers[i] == patterns[j][i % patterns[j].length]) {
						score[j]++;
					}
				}
			}

			// 최고 점수 찾기
			int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				if (score[i] == maxScore) {
					list.add(i + 1);
				}
			}

			// 결과를 배열로 변환하여 반환
			// 진짜 스트림 못 쓰면 바보네 -> 나는 바보다
			return list.stream().mapToInt(i -> i).toArray();
		}
	}
}
