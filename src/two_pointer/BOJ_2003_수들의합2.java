/*

최대 길이 N인 자연수 배열의 부분집합 중에서 원소의 합이 M인 것을 구하여라
N이 10,000

일단 N이 10,000이므로 조합은 시간복잡도 NO!!!!
조합은 원소의 수가 20개까지 가능

그럼 뭘 해야 하나?

부분집합의 길이가 가변적 -> 투 포인터
부분집합의 길이가 고정 -> 슬라이딩 윈도우

시간복잡도는?
O(N)!!!!

부분 배열의 원소도 추가/제외되는 것들만 새로 계산해주면 됨 !!!


<배열의 원소가 자연수>
- 배열의 총합이 특정 값보다 작으면 부분배열의 경우도 무조건 작으려면
배열의 원소가 자연수여야 함 !!







 */


package two_pointer;

import java.util.*;
import java.io.*;
public class BOJ_2003_수들의합2 {

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
		int count = 0;

		int start = 0;
		int end = 1;

		int sum = arr[0];

		while(true){

			if (sum == target){
				count++;
			}

			// sum이 target보다 작은 경우
			// end를 키워줌
			if (sum < target){
				end++;

				if (end > length)
					break;

				sum += arr[end-1];
			// sum이 target보다 큰 경우 + 일치하는 경우
			// start를 키워줌.
			// -> 근데 만약 start = end-1이다? 그럼 값이 합이 0이 되서 다음 루프에서 start를 눌려줄 것
			// 일치하는 경우는 end를 키워주도 됨.
			} else {
				start++;

				sum -= arr[start-1];
			}
		}

		return count;
	}



}
