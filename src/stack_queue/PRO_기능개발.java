package 스택_큐;

import java.util.*;
public class 기능개발 {
	public static void main(String[] args) {}


	class Solution {

		int frontIdx = 0;
		List<Integer> deployCount = new ArrayList<>();

		public int[] solution(int[] progresses, int[] speeds) {

			while(frontIdx < progresses.length){
				for (int idx = 0; idx < progresses.length; idx++) {
					progresses[idx] += speeds[idx];
				}

				if (progresses[frontIdx] >= 100) {
					int deploy = 1;
					for (int idx = frontIdx+1; idx<=progresses.length; idx++){
						if (idx == progresses.length) {
							frontIdx = idx;
							break;
						}

						if (progresses[idx] >= 100)
							deploy++;
						else{
							frontIdx = idx;
							break;
						}

					}

					deployCount.add(deploy);


				}
			}


			int[] answer = new int[deployCount.size()];

			for (int idx = 0; idx < deployCount.size(); idx++){
				answer[idx] = deployCount.get(idx);
			}
			return answer;
		}
	}
}
