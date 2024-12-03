package etc;

import java.util.*;
import java.io.*;

/*
Map으로 안 풀어도 됨.
character의 ascii코드를 사용해서 배열의 인덱스로 체크해도 됨.
그치만 Map의 사용법을 익힐 겸 Map으로 풀어봄.


효율은 배열이 더 좋음 -> 배열도 랜덤접근 가능.
근데 Map의 경우, count 갱신시, 있는지 확인하고 값 조회하고 하느라 한번 할 걸 세번 함.
그래서 Map이 더 비효율적임.

 */
public class BOJ_1157_단어공부 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();

		// Map 버전
		Map<Character, Integer> alpha = new HashMap<>();



		for (int idx = 0; idx < word.length(); idx++){
			char target = word.charAt(idx);

			if (Character.isLowerCase(target)){
				// System.out.println(Character.toUpperCase(target));
				target = Character.toUpperCase(target);
			}

			if (!alpha.containsKey(target)) {
				alpha.put(target, 1);
			} else {
				alpha.replace(target, alpha.get(target)+1);
			}
		}

		Iterator<Character> keys = alpha.keySet().iterator();

		int max = 0;
		char maxChar = 'a';
		boolean isDuplicated = false;


		while (keys.hasNext()){
			Character key = keys.next();
			int value = alpha.get(key);

			if (value > max){
				max = value;
				maxChar = key;
				isDuplicated = false;

			} else if (value == max){
				isDuplicated = true;
			}

		}


		if (isDuplicated)
			System.out.println("?");
		else
			System.out.println(maxChar);


		// // 아스키코드 + 배열 버전
		// int[] count = new int[32];
		//
		// for (int idx = 0; idx < word.length(); idx++){
		// 	char target = word.charAt(idx);
		// 	int ascii = target;
		// 	if (ascii >= 97)
		// 		ascii -= 32;
		//
		// 	ascii -= 65;
		//
		// 	count[ascii]++;
		// }
		//
		//
		// int max = 0;
		// int maxAscii = 0;
		// boolean isDuplicated = false;
		//
		// for (int idx = 0; idx < count.length; idx++){
		//
		// 	if (max == count[idx] && count[idx] != 0) {
		// 		isDuplicated = true;
		// 	} else if (max < count[idx]) {
		// 		max = count[idx];
		// 		maxAscii = idx;
		// 		isDuplicated = false;
		// 	}
		// }
		//
		// if (isDuplicated)
		// 	System.out.println("?");
		// else
		// 	System.out.println((char)(maxAscii+65));
	}
}
