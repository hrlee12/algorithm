package stack_queue;

import java.util.*;

public class PRO_다리를지나는트럭 {

	class Solution {
		public static int solution(int bridge_length, int weight, int[] truck_weights) {

			int time = 0;
			int current_weight = 0;
			List<Integer> bridge_on_time = new LinkedList<Integer>();
			int current_idx = 0;
			int pass_count = 0;


			while (pass_count < truck_weights.length) {
				time++;

				if (bridge_on_time.size() >= 1) {
					int first_one = bridge_on_time.get(0);
					if (first_one + bridge_length == time) {
						current_weight -= truck_weights[current_idx -bridge_on_time.size()];
						bridge_on_time.remove(0);
						pass_count++;
					}

				}
				if (current_idx < truck_weights.length && current_weight + truck_weights[current_idx] <= weight) {
					bridge_on_time.add(time);
					current_weight += truck_weights[current_idx];
					current_idx++;

				}

				// System.out.println(time);
				// System.out.println(current_idx);
			}


			return time;
		}
	}
}
