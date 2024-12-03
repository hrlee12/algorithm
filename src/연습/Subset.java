package algorithm_practice;

import java.util.Scanner;

public class Subset {
	static int[] array;
	static int size;
	static boolean[] isSelected;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		array = new int[size];
		isSelected = new boolean[size];
		
		for (int idx=0; idx<size; idx++) {
			array[idx] = sc.nextInt();
		}
		
		subset(0);
	}
	
	private static void subset(int current_idx) {
		if (current_idx == size) {
			for (int idx=0; idx<size; idx++) {
				System.out.print((isSelected[idx]?array[idx]:"X")+"\t");;
			}
			System.out.println();
			return;
		}
		
		isSelected[current_idx] = true;
		subset(current_idx+1);
		isSelected[current_idx] = false;
		subset(current_idx+1);
	}
		
}