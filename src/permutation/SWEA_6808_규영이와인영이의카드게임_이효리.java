package algorithm.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Arrays;

public class SWEA_6808_규영이와인영이의카드게임_이효리 {

	
	// 입력받은 카드 번호 저장
	public static int[] input_cards;
	// 입력되지 않은 카드 번호 저장
	public static int[] left_cards;
	
	
	public static int win = 0;
	public static int lose = 0;

	
	public static int size = 18;
	public static int half_size = size/2;
	
	public static boolean[] selected = new boolean[half_size];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		

		// 테스트케이스 수만큼 반복
		for (int tc = 0; tc<test_case; tc++) {
			// 입력값 받기
			// 입력받은 카드에 해당하는 배열
			input_cards = new int[half_size];
			// 나머지 카드에 해당하는 배열
			left_cards = new int[half_size];
			// 입력받은 카드를 체크할 boolean 배열
			boolean[] cards = new boolean[size+1];
			
			st = new StringTokenizer(br.readLine());
			
			// 카드를 9개 입력받으므로 9번 반복
			for (int idx = 0; idx<half_size; idx++) {
				
				int input_num = Integer.parseInt(st.nextToken());
				input_cards[idx] = input_num;
				// 입력받은 카드는 true처리
				cards[input_num] = true;				
			}
			
			// for문에서는 boolean배열의 인덱스를 따라가므로 
			// left_cards의 인덱스는 따로 관리
			int left_cards_idx = 0;
			for (int idx = 1; idx<size+1; idx++) {
				// false이면 left_cards에 추가. 
				if (cards[idx] == true) continue;
				
				left_cards[left_cards_idx] = idx;
				left_cards_idx++;
			}
			win = 0;
			lose = 0;

			card_game(0, 0, 0);
			
			System.out.printf("#%d %d %d\n", tc+1, win, lose);
			
		}
	}
	
	
	
	
	public static void card_game(int count, int input_score, int left_score) {
		
		// 순열을 전부 다 채우면 return
		if (count == half_size) {
			if (input_score > left_score) {
				win++;
			}
			
			else if (input_score <left_score ) {
				lose++;		
			}

			return;
		}
		
		
		
		for(int idx =0; idx<half_size; idx++) {
			if (selected[idx] == true) 
				continue;
			
			selected[idx] = true;
			
			// input_card는 순서가 정해져 있으므로 몇번째 원소냐에 해당하는 count를 씀. 
			if (input_cards[count] > left_cards[idx]) {
				card_game(count+1, input_score+input_cards[count]+left_cards[idx], left_score);
			}
			if (input_cards[count] < left_cards[idx]) {
				card_game(count+1, input_score, left_score+input_cards[count]+left_cards[idx]);
			}
			selected[idx] = false;
		}
		
		
	}

}

