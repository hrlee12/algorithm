package DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 여행경로 {

	public static void main(String[] args) {
		String[] result = Solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
		System.out.println(Arrays.toString(result));
	}
	class Solution {

		public static Map<String, List<String>> adj = new HashMap<>();
		public static List<String> result = new LinkedList<>();
		public static String[] dfs_result;
		public static int length;
		public static String[] solution(String[][] tickets) {

			length = tickets.length;
			dfs_result = new String[length+1];
			dfs_result[0] = "ICN";
			// 인접 리스트 만들기
			for (int idx = 0; idx<tickets.length; idx++) {
				String start = tickets[idx][0];
				String end = tickets[idx][1];
				if (!adj.containsKey(start)) {
					adj.put(start, new ArrayList<String>());
				}
				List<String> tmp = adj.get(start);
				tmp.add(end + "_n");
			}

			dfs("ICN", 0);

			// for (int idx =0; idx < result.size(); idx++) {
			// 	System.out.println(Arrays.toString(result.get(idx)));
			// }

			Collections.sort(result);


			return result.get(0).split(" ");
		}

		public static void dfs(String current, int count){
			if (count >= length) {
				String result_string = "";

				for (int idx = 0; idx < length+1; idx++) {
					result_string += dfs_result[idx] + " ";
				}
				result.add(result_string);
			}

			List<String> current_adj = adj.get(current);
			if (current_adj == null) {
				return;
			}
			for (int idx = 0; idx < current_adj.size(); idx++) {
				String dest;
				String isVisited;
				String[] split = current_adj.get(idx).split("_");
				dest = split[0];
				isVisited = split[1];

				if (isVisited.equals("y"))
					continue;

				current_adj.remove(idx);
				current_adj.add(idx, dest+"_y");

				dfs_result[count+1] = dest;
				dfs(dest, count+1);

				current_adj.remove(idx);
				current_adj.add(idx, dest+"_n");

			}
		}
	}
}
