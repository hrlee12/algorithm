package algorithm.etc;

import java.io.*;
import java.util.*;


public class BOJ_6987_월드컵_이효리 {
	public static int win[], tie[], lose[], hasMatch[][];
	public static StringBuilder sb = new StringBuilder();
	public static int game_count;
	public static List<int[]> comb;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		for (int tc = 0; tc < 4; tc++) {
//			win = new int[6];
//			tie = new int[6];
//			lose = new int[6];
//			hasMatch = new int[6][6];
//			game_count = 0;
//			st = new StringTokenizer(br.readLine());
//			
//			for (int team_count = 0; team_count < 6; team_count++) {
//				hasMatch[team_count][team_count] = 1;
//				win[team_count] = Integer.parseInt(st.nextToken());
//				tie[team_count] = Integer.parseInt(st.nextToken());
//				lose[team_count] = Integer.parseInt(st.nextToken());
//			}
//			
			
//			System.out.printf("win : %s\n", Arrays.toString(win));
//			System.out.printf("lose : %s\n", Arrays.toString(lose));
//			System.out.printf("tie : %s\n", Arrays.toString(tie));
//			System.out.println("hasMatch");
//			for (int i=0; i<6; i++) {
//				System.out.println(Arrays.toString(hasMatch[i]));
//				
//			}
			comb = new ArrayList<>();
			makeComb(new int[] {1, 2, 3, 4}, 3, 0, 0, new int[3]);
			
			for (int idx=0; idx<comb.size(); idx++) {
				System.out.println(Arrays.toString(comb.get(idx)));
			}
//			check();
			
	
		}
//		sb.deleteCharAt(sb.length()-1);
//		System.out.println(sb);
//	}
	
	public static void check() {
		for (int idx = 0; idx < 6; idx++) {
			if (!checkWin(idx)) {
//				System.out.println("checkWin!!!!!!!!!!!!");
				sb.append("0 ");
				return;
			};
		
			if (!checkLose(idx)) {
//				System.out.println("checkOut!!!!!!!!!!!!");
				sb.append("0 ");
				return;
			};
		}
		
//		if (!isEmpty("win")) {
//			sb.append("0");
//			return;
//		}
//		
		for (int idx = 0; idx<6; idx++) {
			if (!checkTie(idx)) {
//				System.out.println("checkTie!!!!!!!!!!!!");
				sb.append("0 ");
				return;
			};
		}
		
//		if (!isEmpty("tie")) {
//			sb.append("0");
//			return;
//		}
//		
		
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 6; column++) {
				if (hasMatch[row][column] == 0) {
//					System.out.println("hasMatch!!!!!!!!!!!!");
					sb.append("0 ");
					return;
				}
			}
		}
		
		if (game_count != 15) {
			sb.append("0 ");
			return;
		}
		
		sb.append("1 ");
	}
	
	
	public static boolean checkWin(int team) {
		int win_count = win[team];
		
		for (int idx = 0; idx<6; idx++) {
			if (win_count == 0) break;
			if (lose[idx] > 0 && hasMatch[team][idx] == 0) {
				lose[idx]--;
				hasMatch[team][idx] = 1;
				hasMatch[idx][team] = 1;
				win_count--;
				game_count++;
			}
		}
		
		win[team] = win_count;
		
		if (win_count != 0) return false;
		
		return true;
	}
	
	
	public static boolean checkLose(int team) {
		int lose_count = lose[team];
		
		for (int idx = team+1; idx<6; idx++) {
			if (lose_count == 0) break;
			if (win[idx] > 0 && hasMatch[team][idx] == 0) {
				win[idx]--;
				hasMatch[team][idx] = 1;
				hasMatch[idx][team] = 1;
				lose_count--;
				game_count++;
			}
		}
		
		lose[team] = lose_count;

		if (lose_count != 0) return false;
		
		return true;

	}
	
	public static boolean checkTie(int team) {
		int tie_count = tie[team];
		
		for (int idx = team+1; idx<6; idx++) {
			if (tie_count == 0) break;
			if (tie[idx] > 0 && hasMatch[team][idx] == 0) {
				tie[idx]--;
				hasMatch[team][idx] = 1;
				hasMatch[idx][team] = 1;
				tie_count--;
				game_count++;
			}
		}
		
		tie[team] = tie_count;

		if (tie_count != 0) return false;
		
		return true;
	}
	
	public static boolean isEmpty(String type) {
		if (type == "win") {
			for (int idx = 0; idx<6; idx++) {
				if (win[idx] != 0) return false;
				if (lose[idx] != 0) return false;
			}
		}else if (type == "tie") {
			for (int idx = 0; idx<6; idx++) {
				if (tie[idx] != 0) return false;
			}
		}
		
		return true;
	}
	
	
	public static void makeComb(int[] arr, int length, int start, int count, int[] result) {
		if (count == length) {
			comb.add(result.clone());
			return;
		}
		
		for (int idx=start; idx<arr.length; idx++) {
			result[count] = arr[idx];
			
			makeComb(arr, length, idx+1, count+1, result);
		}
	}
}
