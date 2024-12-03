package 스택_큐;
import java.util.*;

public class 프로세스 {
	public static void main(String args[]) {
		System.out.println(Solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
	}

	class Solution {

		public static int solution(int[] priorities, int location) {

			int[] priority_count = new int[10];
			int top_priority = 0;
			int target_position = location;
			int return_count = 0;
			List<Integer> priority = new LinkedList<Integer>();

			for (int idx = 0; idx< priorities.length; idx++) {
				if (top_priority < priorities[idx]) {
					top_priority = priorities[idx];
				}
				priority.add(priorities[idx]);
				priority_count[priorities[idx]]++;
			}

			// System.out.println(Arrays.toString(priority_count));
			while(true) {
				int current = priority.remove(0);
				// System.out.println("remove : " + current);
				if (current != top_priority) {
					priority.add(current);
					if (target_position == 0)
						target_position = priority.size()-1;
					else
						target_position = target_position -1;
				} else {
					if (target_position == 0)
						return return_count+1;
					else {
						return_count = return_count+1;
						target_position = target_position -1;

						priority_count[top_priority] -= 1;
						if (priority_count[top_priority] == 0) {
							for (int idx = top_priority-1; idx >= 1; idx--) {
								if (priority_count[idx] > 0) {
									top_priority = idx;
									break;
								}
							}
						}
					}
				}

				// System.out.println(priority);
			}

		}
	}
}
