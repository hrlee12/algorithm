import java.util.*;
import java.io.*;


public class BOJ_4013_특이한자석_이효리 {
	
	public static int num, magnets[][], pointer[];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < test_case; tc++) {
			
			magnets = new int[4][8];
			pointer = new int[4];
			num = Integer.parseInt(br.readLine());
			
			for (int magnet = 0; magnet < 4; magnet++) {
				st = new StringTokenizer(br.readLine());
				
				for (int idx = 0; idx < 8; idx++) {
					magnets[magnet][idx] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = solution();
			
			System.out.printf("#%d %d\n", tc+1, result);

			
		}
	}
	
	public static int solution() throws IOException {
		
		run();
		
		return getResult();

	};
	
	
	public static void run() throws IOException {
		
		for (int idx = 0; idx < num; idx++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			left_run(num, dir);
			pointer[num] = getIndex(pointer[num], dir);
			right_run(num, dir);
		}
	}
	
	public static void left_run(int num, int dir) {

		
		int pntr = pointer[num];
		int[] current = magnets[num];
		
		
		if (num-1 >= 0) {
			int current_target = current[getIndex(pntr, -2)];
			
			int[] left = magnets[num-1];
			int left_target = left[getIndex(pointer[num-1], 2)];
			if (current_target != left_target){
				
				left_run(num-1, -1 * dir);
			}
		}
		
		pointer[num] = getIndex(pointer[num], -1*dir);
	}
	
	
	
	
	public static void right_run(int num, int dir) {
		
		int pntr = pointer[num];
		int[] current = magnets[num];

		if (num+1 < 4) {
			int current_target = current[getIndex(pntr, 2)];
			
			int[] right = magnets[num+1];
			int right_target = right[getIndex(pointer[num+1], -2)];
			if (current_target != right_target){
				
				right_run(num+1, -1 * dir);
			}
		}
		
		pointer[num] = getIndex(pointer[num], -1*dir);
	}
	
	public static int getIndex(int current, int gap) {
		if (current+gap >= 8) {
			return current+gap - 8; 
		} else if (current+ gap < 0) {
			return current+gap + 8;
		} else {
			return current+gap;
		}
	}

	public static int getResult() {
		int sum = 0; 
		
		for (int idx = 0; idx < 4; idx++) {
			if (magnets[idx][pointer[idx]] == 1) {
				sum += (int)Math.pow(2, idx);
			}
		}
		
		return sum;
	}
}

