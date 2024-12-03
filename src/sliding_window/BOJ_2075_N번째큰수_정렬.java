package sliding_window;

/*
n은 2,250,000이 됨.
근데 Collections.sort()는 nlogn의 시간복잡도

근데 왜 시간초과 안 남....??????

최대 n의 크기가 출처마다 다 다르게 말함.
어디는 1,000,000이고 어디는 100,000이고....

 */

import java.util.*;
import java.io.*;

public class BOJ_2075_N번째큰수_정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int n = Integer.parseInt(br.readLine());
		List<Integer> nums = new LinkedList<>();

		for (int row = 0; row < n; row++){

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int col = 0; col < n; col++){
				nums.add(Integer.parseInt(st.nextToken()));

			}

		}

		Collections.sort(nums);

		System.out.println(nums.get(nums.size()-n));


	}
}

