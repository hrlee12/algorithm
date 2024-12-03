package 해쉬;

import java.util.HashMap;
import java.util.Map;

public class PRO_전화번호목록 {
	public static void main(String[] args) {
		boolean result = Solution.solution(new String[]{"123","456","789"});
		System.out.println(result);


	}

	class Solution {
		public static boolean solution(String[] phone_book) {


			Map<String, Integer> phone_map = new HashMap<>();

			for (int idx = 0; idx < phone_book.length; idx++){
				phone_map.put(phone_book[idx], idx);
			}

			for (int idx = 0; idx < phone_book.length; idx++) {
				String word = phone_book[idx];
				for (int inner_idx = 0; inner_idx < word.length()-1; inner_idx++) {
					if (phone_map.containsKey(word.substring(0, inner_idx+1))){
						return false;
					}
				}
			}
			return true;
		}
	}
}
