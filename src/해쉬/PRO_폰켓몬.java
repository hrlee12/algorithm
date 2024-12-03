package 해쉬;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
	public static void main(String[] args) {

		int result = Solution.solution(new int[]{3, 3, 3, 2, 2, 2});
		System.out.println(result);
	}

	class Solution {
		public static int solution(int[] nums) {
			Map	<Integer, Integer> alreadyCheck = new HashMap<>();



			int maxNum = 0;
			int halfNum = nums.length/2;
			for (int idx = 0; idx < nums.length; idx++) {
				if (!alreadyCheck.containsKey(nums[idx])) {
					alreadyCheck.put(nums[idx], 1);
					maxNum++;
					if (maxNum >= halfNum)
						break;
				}

			}
			return maxNum;
		}
	}
}
