package 완전탐색;

import java.util.*;

public class PRO_소수찾기 {


	class Solution {
		static char[] permResult;
		static int[] isSelected;
		static char[] numberChars;
		static Map<Integer, String> primes = new HashMap<>();

		public int solution(String numbers) {

			permResult = new char[numbers.length()];
			isSelected = new int[numbers.length()];
			numberChars = numbers.toCharArray();

			for (int idx = 1; idx <= numberChars.length; idx++) {
				perm(idx, 0);
			}


			return primes.size();
		}


		public void perm(int length, int current) {
			if (length == current) {
				String result = "";

				for (int idx = 0; idx < length; idx++) {
					result += permResult[idx];
				}

				int num = Integer.parseInt(result);

				if (isPrime(num)){
					if (!primes.containsKey(num))
						primes.put(num, null);
				}

				return;
			}



			for (int idx = 0; idx < numberChars.length; idx++) {
				// 중복되지 않는 순열은 인덱스를 활용한 마킹을 통해 체크한다.
				if (isSelected[idx] == 1) continue;

				isSelected[idx] = 1;
				permResult[current] = numberChars[idx];

				perm(length, current+1);

				isSelected[idx] = 0;
			}
		}


		// 소수 판별법
		// 2부터 제곱근까지 타겟이 나눠떨어지는지 확인.
		public boolean isPrime(int num) {
			if (num < 2)
				return false;

			for (int idx = 2; idx <= Math.sqrt(num); idx++) {
				if (num % idx == 0)
					return false;
			}

			return true;
		}
	}
}
