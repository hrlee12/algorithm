package sliding_window;

/*
n번째 큰 수 구하기.
근데 시간복잡도와 공간복잡도를 최소화한.


우선순위 큐를 n의 크기로 유지하면서 하면
Nlogn의 시간복잡도

근데 냅다 전부 다 넣으면
n^2logn^2

냅다 정렬해도
n^2logn^2
 */

import java.util.*;
import java.io.*;

public class BOJ_2075_N번째큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>();


		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < n; idx++){
			pq.add(Integer.parseInt(st.nextToken()));
		}


		for (int row = 1; row < n; row++){

			st = new StringTokenizer(br.readLine());

			for (int col = 0; col < n; col++){
				int num = Integer.parseInt(st.nextToken());
				if (num > pq.peek()){
					pq.poll();
					pq.add(num);
				}


			}

		}

		System.out.println(pq.poll());


	}
}
