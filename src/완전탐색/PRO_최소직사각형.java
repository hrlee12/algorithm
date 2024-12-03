package 완전탐색;

public class 최소직사각형 {

	class Solution {
		public int solution(int[][] sizes) {


			int bigger = 0;
			int smaller = 0;

			for (int[] size : sizes){
				if (size[0] > size[1]) {
					if (bigger < size[0])
						bigger = size[0];
					if (smaller < size[1])
						smaller = size[1];
				} else {
					if (bigger < size[1])
						bigger = size[1];
					if (smaller < size[0])
						smaller = size[0];
				}
			}
			int answer = bigger * smaller;
			return answer;
		}
	}
}
