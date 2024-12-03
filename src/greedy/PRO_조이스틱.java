package Greedy;

/*
조이스틱을 움직이는 횟수를 정하는 것이 핵심인 문제
1) 정방향으로 끝까지 간 경우
2) 중간에 틀어서 뒤쪽을 가는 경우
3) 처음부터 뒤쪽으로 갔다가 다시 앞으로 가는 경우
	ex) ZYXAAAAAB
	X까지 갔다가 다시 B로 가는 것(5)보다
	B로 갔다가 X로 가는 게(4) 더 빠름


이 문제를 풀기 위해 A가 아닌 녀석들의 인덱스를 전부 리스트에 넣고
A가 아닌 녀석들을 기준으로 2,3번 검사를 해준다.




 */


import java.util.*;
public class 조이스틱 {




	class Solution {
		public int solution(String name) {

			int answer = 0;

			// 조이스틱 움직이는 부분

			int minCount = Integer.MAX_VALUE;


			List<Integer> notAList = new ArrayList<Integer>();

			// 냅다 뒤로 가는 경우도 확인하기 위해서 첫번째 인덱스를 넣는다.
			notAList.add(0);

			// A가 아닌 원소를 넣는다.
			for (int idx = 1; idx < name.length(); idx++){
				if (name.charAt(idx) != 'A'){
					notAList.add(idx);
				}
			}


			// A가 아닌 원소를 기준으로
			for (int idx = 0; idx < notAList.size()-1; idx++) {


				// 그 원소까지 가지 뒤로 돌아간 경우
				int moveCount = 0;
				moveCount += notAList.get(idx)*2;
				moveCount += name.length()-notAList.get(idx+1);
				if (minCount > moveCount){
					minCount = moveCount;
				}


				// 그 원소 전까지 뒤로 돌아가서 갔다가 앞으로 그 원소까지 간 경우
				moveCount = 0;

				moveCount += (name.length()-notAList.get(idx+1))*2;
				moveCount += notAList.get(idx);

				if (minCount > moveCount){
					minCount = moveCount;
				}
			}

			// 뒤로 돌아서 해당 원소 전까지 하고 다시 처음으로 와서 그 원소까지 해결한 경우
			int lastNotAIdx = notAList.get(notAList.size()-1);

			if (minCount > lastNotAIdx){
				minCount = lastNotAIdx;
			}
			System.out.println("minCount : " + minCount);
			answer += minCount;




			// 알파벳 구하는 부분

			int startNum = (int)'A';
			int endNum = (int)'Z';
			int halfGap = (endNum - startNum) / 2;

			for (int idx = 0; idx < name.length(); idx++) {
				char targetChar = name.charAt(idx);
				int targetCode = (int)targetChar;
				if (targetCode == 65) continue;
				System.out.println("targetCode : "+ targetCode);

				int moveCount = 0;
				if (targetCode <= 65+halfGap) {
					moveCount =  targetCode - startNum;
				} else {
					moveCount =  endNum - targetCode +1;
				}

				System.out.println(moveCount);
				answer += moveCount;
			}


			return answer;
		}
	}
}
