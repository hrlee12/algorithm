/*


n이 11미만일 때 순열 가능

 */

package permutation;

import java.util.Arrays;

public class permutation{

	public static int[] numbers;
	public static boolean[] isSelected;
	public static int[] permArray;


	public static void main(String args[]){

		numbers = new int[]{1, 2, 3, 4};
		isSelected = new boolean[numbers.length];
		permArray = new int[numbers.length];
		perm(0);



	}

	// 길이가 numbers인 perm
	public static void perm(int count){
		if (count >= numbers.length){
			System.out.println(Arrays.toString(permArray));

			return;
		}


		for (int idx = 0; idx < numbers.length; idx++){
			if (isSelected[idx]) continue;
			isSelected[idx] = true;
			permArray[count] = numbers[idx];
			perm(count+1);
			isSelected[idx] = false;
		}
	}

}