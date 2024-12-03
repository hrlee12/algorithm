package DFS_BFS;



public class 타겟넘버 {

	public static void main(String[] args) {
		System.out.println(Solution.solution(new int[]{4 ,1, 2, 1} ,4));
	}

	class Solution {
		public static int target_num, result, length;
		public static int[] nums;

		public static int solution(int[] numbers, int target) {

			target_num = target;
			length = numbers.length;
			nums = numbers;


			dfs(-1, 0);

			return result;
		}




		public static void dfs(int idx, int sum){


			if (idx == length-1) {
				if (sum == target_num)
					result++;

				return;
			}

			for (int adj_idx = 0; adj_idx < 2; adj_idx++) {
				int adj_num = nums[idx + 1];
				int add_num = 0;

				if (adj_idx == 0) {
					dfs(idx + 1, sum - adj_num);
				} else {
					dfs(idx + 1, sum + adj_num);
				}
			}
		}
	}
}
