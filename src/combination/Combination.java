/*

n이 20이하일 때 조합 가능
n이 40이하일 때, 반으로 나눠서 접근 가능

 */

package combination;


import java.util.Arrays;

public class Combination{

	public static int[] numbers;
	public static int[] combArray;

	public static void main(String args[]){

		numbers = new int[]{1, 2, 3, 4};
		combArray = new int[2];
		comb(0, 0);


	}


	// 길이가 2인 조합
	public static void comb(int count, int start){
		if (count >= 2){
			System.out.println(Arrays.toString(combArray));
			return;
		}

		for (int idx = start; idx < numbers.length; idx++){
			combArray[count] = numbers[idx];
			comb(count+1, idx+1);
		}

	}

}