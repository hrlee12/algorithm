package algorithm_practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.IOException;

public class Inclass_perm  {
	
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	
	public static void main(String args[]) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken()); 
	M = Integer.parseInt(st.nextToken()); // 주사위 던지기 모드 : 1 - 중복순열, 2 - 순열
	
	numbers = new int[N];
	switch (M) {
	case 1:
		dice1(0);
		System.out.println(sb.toString());
		break;
	case 2: 
		isSelected = new boolean[7];
		dice2(0);
		System.out.println(sb.toString());
		break;
	}
	
	
	
	}
	
	private static void dice1(int cnt) {
		
		if (cnt== N) {
			for (int i=0; i<N; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=1; i <= 6; i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
			
		}
	}   
	
	
	private static void dice2(int cnt) {
		
		if (cnt== N) {
			for (int i=0; i<N; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=1; i <= 6; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			
			dice2(cnt+1);
			
			isSelected[i] = false;
		}
	}


}
