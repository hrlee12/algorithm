package algorithm.etc;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기_이효리 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int test_case = Integer.parseInt(in.nextLine());
		for (int tc = 0; tc < test_case; tc++) {
			String target = in.nextLine();
			char[] memory = target.toCharArray();
			
			char prev = '0';
			int count = 0;

			for (char bit : memory) {
				if (bit != prev) { 
				count++;
				prev = bit;
				}
			}
			
			System.out.printf("#%d %d\n", tc+1, count);
		}
		
	}
}
