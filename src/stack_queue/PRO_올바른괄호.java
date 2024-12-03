package stack_queue;

import java.util.*;

public class PRO_올바른괄호 {
	public static void main(String[] args) {

	}


	class Solution {
		boolean solution(String s) {
			char[] chars = s.toCharArray();

			int stackCount = 0;


			for (int idx = 0; idx<chars.length; idx++) {
				if (chars[idx] == '('){
					stackCount++;
				} else {
					if (stackCount <= 0) {
						return false;
					} else {
						stackCount--;
					}
				}
			}

			if (stackCount != 0)
				return false;


			return true;
		}
	}
}
