package sliding_window;

import java.util.*;
import java.io.*;
public class BOJ_2559_수열 {

	private static int arrLength, targetLength;
	private static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		arrLength = Integer.parseInt(st.nextToken());
		targetLength = Integer.parseInt(st.nextToken());

		arr = new int[arrLength];

		st = new StringTokenizer(br.readLine());

		for (int idx = 0; idx < arrLength; idx++){
			arr[idx] = Integer.parseInt(st.nextToken());
		}



		System.out.println(slidingWindow());

	}

	private static int slidingWindow(){
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int idx = 0; idx < targetLength; idx++){
			sum += arr[idx];
		}

		if (sum > maxSum){
			maxSum = sum;
		}


		for (int idx = 1; idx < arrLength-targetLength+1; idx++){

			sum -= arr[idx-1];
			sum += arr[idx+targetLength-1];

			if (maxSum < sum ){
				maxSum = sum;
			}
		}





		return maxSum;
	}
}
