public class Permutation_2{

	public static int[] numbers;
	public static boolean[] visited;
	public static int[] permArray;

	public static void main(String args[]){

		numbers = new int[]{1, 2, 3, 4};
		visited = new boolean[numbers];


	}

	public void perm(int count){
		if (count >= numbers.length){
			System.out.println(Arrays.toString(permArray));

			return;
		}


		for (int idx = 0; idx < number.length; idx++){
				if (visited[idx]) continue;
				visited[idx] = true;
				permArray[count] = numbers[idx];
				perm(count+1);
				visited[idx] = false;
		}
	}

}