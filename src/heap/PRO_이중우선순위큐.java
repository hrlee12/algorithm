package 힙;

import java.util.*;
public class 이중우선순위큐 {

	public static void main(String[] args){}


	class Solution {
		public int[] solution(String[] operations) {

			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

			for (int idx = 0; idx < operations.length; idx++) {
				String[] operation = operations[idx].split(" ");
				if (operation[0].equals("I")){
					Integer inputValue = Integer.valueOf(operation[1]);
					minHeap.offer(inputValue);
					maxHeap.offer(inputValue);
				} else {
					if (minHeap.isEmpty())
						continue;
					else if (operation[1].equals("-1")){
						Integer minValue = minHeap.poll();
						maxHeap.remove(minValue);
					} else if (operation[1].equals("1")){
						Integer maxValue = maxHeap.poll();
						minHeap.remove(maxValue);
					}


				}
			}

			int[] answer = new int[2];

			if (minHeap.isEmpty()){
				return answer;
			} else {
				if (minHeap.size() == 1) {
					Integer minMaxValue = minHeap.poll();
					answer[0] = minMaxValue;
					answer[1] = minMaxValue;
				} else {
					Integer minValue = minHeap.poll();
					Integer maxValue = maxHeap.poll();
					answer[0] = maxValue;
					answer[1] = minValue;
				}

				return answer;
			}




		}
	}
}
