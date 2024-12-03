package algorithm_practice;

import java.util.Arrays;
import java.util.Comparator;
public class Sort_practice {

	
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {{1, 2}, {4, 2}, {1, 1}, {-1, 2}};
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
//		
//		Arrays.sort(arr, new Comparator<int[]>() {
//		    @Override
//		    public int compare(int[] o1, int[] o2) {
//		        return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
//		        //return o2[0]-o1[0]; // 첫번째 숫자 기준 내림차순 {5,40}{4,20}{3,50}{2,10}{1,30}
//		        //return o1[1]-o2[1]; // 두번째 숫자 기준 오름차순 {2,10}{4,20}{1,30}{5,40}{3,50}
//		        //return o2[1]-o1[1]; // 두번째 숫자 기준 내림차순 {3,50}{5,40}{1,30}{4,20}{2,10}
//		    }
//		});
		for (int[] elem: arr) {
			System.out.println(Arrays.toString(elem));
		}
	}

}
