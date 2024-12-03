package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination {
//	static int comb_length;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	private static void dice_comb (int cnt, int start) {
		// 출력하기
		if (cnt >= numbers.length) {
			for (int idx=0; idx<numbers.length; idx++) {
				sb.append(numbers[idx] + " ");
			}
			sb.append("\n");
			return;
		}
		
		// 처음 스타트는 1이지만 두번째로 호출하면 스타트가 나 다음 수부터 되므로
		// 1은 2,3,4,5,6 다 하고 2는 3,4,5,6만 하고 6은 아무것도 안 한다. 
		// 이렇게 함으로써 구성은 같고 순서만 다른 경우를 없앨 수 있다. -> 조합 구현 
		 
		for (int i = start; i <=6; i++) {
			numbers[cnt] = i;
			dice_comb(cnt+1, i+1);

			
		}
	}
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int length = Integer.parseInt(br.readLine());
//		numbers = new int[0];
//		dice_comb(0, 1);
		System.out.println(sb.toString());		
		for (int length=0; length<=6; length++) {
			numbers = new int[length];
			dice_comb(0, 1);
			System.out.println(sb.toString());		
			sb.setLength(0);
			
		}

	}
}