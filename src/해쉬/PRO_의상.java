package 해쉬;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PRO_의상 {
	public static void main(String[] args) {
		int result = Solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglassed", "eyewear"}, {"green_turban", "headgear"}});
		System.out.println(result);
	}
	class Solution {
		static int result = 0;
		static int[] category_number;
		static int[] comb_number;
		public static int solution(String[][] clothes) {

			Map<String, Integer> categorized = new HashMap<>();

			for (int idx = 0; idx < clothes.length; idx++) {
				String name = clothes[idx][0];
				String category = clothes[idx][1];

				if (categorized.containsKey(category)) {
					categorized.replace(category, categorized.get(category) +1);
				} else {
					categorized.put(category, 1);
				}
			}

			category_number = new int[categorized.size()];

			Set<String> categories = new HashSet<>();
			categories = categorized.keySet();

			int size = categories.size();

			int result = 1;
			for (String category: categories) {
				result *= categorized.get(category)+1;

			}

			return result--;




		}
	}
}
