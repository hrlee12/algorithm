package two_pointer;/*
n이 4,000,000이므로
nlogn은 간당간당할 수 있음(여유 1,000,000)

nlog(logn), n, logn

소수 구하기(에라토스테네스의 체) + 투포인터


 */

import java.util.*;
import java.io.*;
public class BOJ_1644_소수의연속합 {

	private static int target;
	private static List<Integer> primes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		target = Integer.parseInt(br.readLine());
		primes = new ArrayList<>();
		getPrime(target);

		// System.out.println(primes.toString());

		System.out.println(getContinuousSumCount());

	}

	private static void getPrime(int number){
		boolean[] nums = new boolean[number+1];
		nums[0] = true;
		nums[1] = true;

		for (int idx = 2; idx <= number/2; idx++){
			if (nums[idx] == true) continue;
			for (int mul = 2; mul <= number/idx; mul++){
				// System.out.println(idx*mul);
				nums[idx * mul] = true;
			}
		}


		for (int idx = 2; idx <= number; idx++){
			if (nums[idx] == false){
				primes.add(idx);
			}
		}

	}


	private static int getContinuousSumCount(){
		int left = 0;
		int right = 0;
		int count = 0;
		int sum = 0;
		while(true){
			// System.out.println(sum);
			if (sum == target){
				count++;
			}

			if (sum < target){
				if (right+1 > primes.size())
					break;


				sum += primes.get(right);
				right++;
			} else {
				sum -= primes.get(left);
				left++;
			}
		}

		return count;
	}
}
