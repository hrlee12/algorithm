package heap;

import java.util.*;
public class PRO_디스크컨트롤러 {
	public static void main(String args[]){

	}


	class Solution {
		public int solution(int[][] jobs) {

			Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);


			int currentTime = 0;
			int totalTime = 0;
			int jobCount = 0;
			int inputCount = 0;

			while (true) {
				for (int idx = inputCount; idx < jobs.length; idx++) {
					if (jobs[idx][0] <= currentTime){
						pq.offer(jobs[idx]);
						inputCount++;
					} else {
						break;
					}
				}

				if (pq.isEmpty()){
					currentTime++;
					continue;
				}
				int[] doneJob = pq.poll();
				jobCount++;
				totalTime += currentTime + doneJob[1]  - doneJob[0];
				currentTime += doneJob[1];
				if (jobCount >= jobs.length) break;
			}

			return totalTime / jobs.length;
		}
	}


}
