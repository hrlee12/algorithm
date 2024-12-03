package stack_queue;

import java.util.*;

public class PRO_같은숫자는싫어 {
	public static void main (String[] args) {

	}




	public class Solution {
		public int[] solution(int []arr) {
			List<Integer> answer = new ArrayList<>();

			answer.add(arr[0]);

			for (int idx = 1; idx < arr.length; idx++) {
				int lastIdx = answer.size()-1;
				if(answer.get(lastIdx) != arr[idx]){
					answer.add(arr[idx]);
				}
			}

			int[] finalAnswer = new int[answer.size()];

			for (int idx = 0; idx< answer.size(); idx++) {
				finalAnswer[idx] = answer.get(idx);
			}


			return finalAnswer;
		}
	}
}
