package algorithm.permutation;


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BOJ_1244_스위치켜고끄기 {
	public static void main(String args[]) throws IOException {
		
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number_switch = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] switches = new int[number_switch+1];
		
		for (int count = 1; count<=number_switch; count++) {
			switches[count] = Integer.parseInt(st.nextToken());
		}
		
		int number_person = Integer.parseInt(br.readLine());
		
		int[][] persons = new int[number_person][2];
		
		
		for (int count = 0; count<number_person; count++) {
			st = new StringTokenizer(br.readLine());
			persons[count][0] = Integer.parseInt(st.nextToken());
			persons[count][1] = Integer.parseInt(st.nextToken());
		}

		
		
		// 각 셩별마다 작성된 메서드 호출
		for (int count = 0; count<number_person; count++) {
			if (persons[count][0] == 1) {
				switches = change_switch_man(persons[count][1], switches);
			} else {
				switches = change_switch_woman(persons[count][1], switches);
			}
	
		}
		
		// 결과 출력
		for (int idx = 1; idx<switches.length; idx++) {
			System.out.printf("%d ", switches[idx]);
			if (idx % 20 == 0) 
				System.out.println();
		}

	}
	
	
	// 남자일 때의 메서드
	private static int[] change_switch_man(int target_num, int[] switches) {
		int mul = target_num;
		// 3의 배수 스위치 바꾸기
		while (mul < switches.length) {			
			switches[mul] = switches[mul] == 0? 1 : 0;
			mul += target_num;
		}
		
		return switches;
	}
	
	// 여자일 때의 메서드
	private static int[] change_switch_woman(int target_num, int[] switches) {
		int gap = 0;
		
		// 좌우로 한칸씩 옮기면서 조건 확인
		while (true) {
			int left = target_num-(gap+1);
			int right = target_num+(gap+1);
			if (left <= 0 || right >= switches.length)  
				break;
			
			if (switches[left] != switches[right])
				break;
			
			
			gap += 1;
		}
		
		
		// 확인된 인덱스를 바탕으로 값 바꾸기
		switches[target_num] = switches[target_num] == 0? 1 : 0;
		for (int next = 0; next < gap; next++) {
			int left = target_num-(next+1);
			int right = target_num+(next+1);
			switches[left] = switches[left] == 0 ? 1 : 0;
			switches[right] = switches[right] == 0 ? 1 : 0;
		}
		
		
		return switches;
	}	
}
