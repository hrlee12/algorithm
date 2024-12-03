/*

n = 100,000

n^2 = 10,000,000,000
-> 100억
100억이면 시간초과 !!!!

그러니까 두개의 수를 뽑는 조합은 안됨!!!!

<원리>
- 1부터 100까지의 자연수가 순서대로 나열되어 있을 때,
두 수를 더해서 100인 경우가 몇개가 있을까?

(1, 99), (2, 98),,, (49, 51)의 50개
어떻게 구했을까?
양쪽에 두개의 포인터를 두고 한칸씩 좁혀갔겠지.

그 방법을 응용하자 !

이것도 수가 중복되지 않아서 가능한 것.


<투 포인터>
- 두개의 포인터를 가지고 포인터의 위치를 옮겨 다님.
-> 그러다보니 두 포인터의 차는 달라질 수 밖에 없음.
인거지.
그 범위의 수를 전부 다 써야 하는 건 아님.

포인터가 위차한 수만 써도 됨.

<부분집합의 합일 구할 때>
범위(부분집합)의 합일 때는 두 포인터로 만든 범위의 수의 합보다 크면 ? 줄인다. 작으면? 늘린다.
로. 길이가 길어지면 합은 커진다를 이용

<두개의 수의 합을 구할 때>
근데 여기선 두개의 수잖아. 부분집합의 합을 사용 안 한다고.
이럴 땐, 수를 정렬해서 두 포인터가 가리키는 숫자의 합이 목표값보다 더 작으면 l 포인터 옮기기(수 키우기), 더 크면 r 포인터 옮기기(수 줄이기)
-> 배열 원소의 값은 중복되지 않아야 함.


< 원소가 서로 다른 값 >
- 원소가 같은 값이 있으면 안됨.
-> 일단 값이 목표값과 같으면 포인터를 움직임.
근데 같은 값이 있다? 그럼 인덱스를 유지하고 다른 수와 같은 합계를 낼 수 있음.
-> 투 포인터로 다 알아내지 못함.
ex)
1 2 2 11 11 12
인덱스 (1, 3)
인덱스 (1, 4)
인덱스 (2, 3)
인덱스 (2, 4)
모두 합이 13임. 근데 포인터를 다음으로 움직여야 함.



 */


package two_pointer;

import java.util.*;
import java.io.*;

public class BOJ_3273_두수의합 {

	private static int length, target;
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		length = Integer.parseInt(br.readLine());

		arr = new int[length];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int idx = 0; idx < length; idx++){
			arr[idx] = Integer.parseInt(st.nextToken());
		}


		target = Integer.parseInt(br.readLine());

		// System.out.println(Arrays.toString(arr));
		System.out.println(twoPointer());

	}

	private static int twoPointer(){

		Arrays.sort(arr);

		// System.out.println(Arrays.toString(arr));

		int count = 0;

		int left = 0;
		int right = length -1;

		// left = right면 다른 두 원소가 아니게 됨.
		// 그러므로 같은 경우도 멈추는 조건에 포함.
		while (left < right){

			int sum = arr[left] + arr[right];

			// System.out.println("left : " + left + " right : " + right);
			// System.out.println("sum : " + sum);


			if (sum == target){
				count++;
				// System.out.println("count 더하기 ");
				// System.out.println("count : " + count);
			}

			if (sum <= target){
				left++;
			} else {
				right--;
			}

		}

		return count;

	}
}
