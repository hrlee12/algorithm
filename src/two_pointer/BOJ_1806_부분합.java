package two_pointer;
/*
n이 100,000
-> nlogn, n, logn

투포인터를 사용하면 n

 */

import java.util.*;
import java.io.*;

public class BOJ_1806_부분합 {

	private static int length, target;
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		length = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		arr = new int[length];

		st = new StringTokenizer(br.readLine());

		for (int idx = 0; idx < length; idx++){
			arr[idx] = Integer.parseInt(st.nextToken());
		}

		System.out.println(twoPointer());

	}

	private static int twoPointer(){
		int minLen = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int sum = 0;
		while (true){
			if (sum >= target){
				if (minLen > right-left){
					minLen = right-left;
				}

				sum -= arr[left++];

			} else {
				if (right >= arr.length){
					break;
				}

				sum += arr[right++];
			}
		}

		if (minLen == Integer.MAX_VALUE)
			minLen = 0;

		return minLen;
	}
}
