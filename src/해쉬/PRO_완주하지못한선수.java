package 해쉬;

import java.util.HashMap;
import java.util.Map;

public class PRO_완주하지못한선수 {

	public static void main(String[] args) {
		String result = Solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
		System.out.println(result);
	}

	class Solution {
		public static String solution(String[] participant, String[] completion) {

			Map<String, Integer> done = new HashMap<>();

			String answer = "";

			for (int idx = 0; idx < completion.length; idx++) {
				if (done.containsKey(completion[idx])){
					done.replace(completion[idx], done.get(completion[idx])+1);
				} else {
					done.put(completion[idx], 1);
				}

			}


			for (int idx = 0; idx < participant.length; idx++) {
				String currentPart = participant[idx];

				if (done.containsKey(currentPart)) {
					int amount = done.get(currentPart);
					if (amount == 1) {
						done.remove(currentPart);
					} else {
						done.replace(currentPart, amount-1);
					}
				} else {
					answer = currentPart;
					break;
				}
			}

			return answer;
		}
	}
}
