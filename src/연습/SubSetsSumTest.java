package algorithm_practice;

import java.util.Scanner;

public class SubSetsSumTest {
	static int N, SUM, input[];
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
	}
	
	
	private static void generateSubset(int cnt) {
		if (cnt == N) {
			int temp = 0, tCnt = 0;
				for (int i=0; i< N; i++) {
				if (isSelected[i]) {
						temp += input[i];
						tCnt++;
					}
				}
				
				if (temp == SUM) {
					for (int i=0; i<N; i++) {
						if (isSelected[i]) {
							System.out.println(input[i] +"\t");
						}
					}
				System.out.println();
				}
				return;
			}
			
			isSelected[cnt] = true;
			generateSubset(cnt+1);
			isSelected[cnt] = false;
			generateSubset(cnt+1);
		 
	}

}