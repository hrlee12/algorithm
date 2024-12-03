package two_pointer;/*
배열의 크기 n = 1,000,000

테케가 1,000,000일 때, nlogn까지 좋음!!!


<리스트를 정렬하기>

배열의 정렬은 최악의 경우 n^2
리스트의 정렬은 최악에도 평균과 같이 nlogn



ArrayList와 LinkedList 중에서 선택하기
정렬은 둘 다 같음.
마지막에 stringBuilder에서 전부 다 조회하므로
ArrayList는 조회 O(1) -> n번 조회하면 n
LinkedList는 조회 O(n) -> n번 조회하면 n**2

n**2은 10,000 까지만 됨!!! 다 조회하면 절대 LinkedList 쓰면 안됨!!!


<투포인터>
- 이미 정렬되어 있으므로
두 배열에 하나씩 포인터를 두고 두 배열의 값 비교하며 값 할당하기.


*/

import java.util.*;
import java.io.*;

public class BOJ_11728_배열합치기_투포인터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int aLength = Integer.parseInt(st.nextToken());
		int bLength = Integer.parseInt(st.nextToken());

		int[] arrA = new int[aLength];
		int[] arrB = new int[bLength];

		st = new StringTokenizer(br.readLine());

		for (int idx = 0; idx < aLength; idx++) {
			arrA[idx] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int idx = 0; idx < bLength; idx++) {
			arrB[idx] = Integer.parseInt(st.nextToken());
		}

		int aPointer = 0;
		int bPointer = 0;
		int[] result = new int[aLength+bLength];

		for (int idx = 0; idx < result.length; idx++){

			if (aPointer >= aLength){
				result[idx] = arrB[bPointer++];
			} else if (bPointer >= bLength){
				result[idx] = arrA[aPointer++];
			} else if (arrA[aPointer] < arrB[bPointer]){
				result[idx] = arrA[aPointer++];
			} else {
				result[idx] = arrB[bPointer++];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < result.length; idx++) {
			sb.append(result[idx]);
			sb.append(' ');
		}

		sb.deleteCharAt(sb.length()-1);

		System.out.println(sb.toString());


	}

}
