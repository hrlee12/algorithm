import java.util.*;
import java.io.*;


public class 가장큰수 {
	public static void main(String args[]) {
		System.out.println("hi");
	}


	class Solution {
		public String solution(int[] numbers) {

			String[] nums = new String[numbers.length];

			for (int idx = 0; idx < numbers.length; idx++) {
				nums[idx] = Integer.toString(numbers[idx]);
			}

			Arrays.sort(nums, (o1, o2) -> {
				return (o2+o1).compareTo(o1+o2);
			});

			if (nums[0].equals("0")) {
				return "0";
			}
			StringBuilder sb = new StringBuilder();

			for (int idx = 0; idx <numbers.length; idx++) {
				sb.append(nums[idx]);
			}
			return sb.toString();
		}
	}
}