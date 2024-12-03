/*
선택 정렬 : 제일 작은 수 찾아서 앞으로 가져오기
삽입 정렬 : 이미 정렬된 배열 부분과 비교하면서 자신의 위치를 찾음.
버블 정렬 : 인접한 두 원소 비교해서 자리 바꿈.
-> n**2

병합 정렬 : 원소의 크기가 1이 될 때까지 분할 한 후, 하나씩 정렬하며 합친다.
nlogn

퀵 정렬 : nlogn 최악 n**2

힙 정렬 : nlogn

걍 선택 정렬이 신간 편함.
삽입 정렬 개 빡침.
 */


package sort;

import java.util.*;
import java.io.*;

public class softeer_GPT식숫자비교_삽입정렬 {

	private static List<Integer[]> splitNums = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		String[] nums = new String[num];

		for (int idx = 0; idx < num; idx++){
			nums[idx] = br.readLine();
		}


		// '.'을 기준으로 분할해서 배열에 정수로 담기
		// 나누기와 나머지를 이용하지 않은 이유 : 3.0과 3을 구분해야 했음.
		for (int idx = 0; idx < nums.length; idx++){
			String[] tmp = nums[idx].split("\\.");
			Integer[] splitNum = new Integer[tmp.length];

			for (int tmpIdx = 0; tmpIdx < tmp.length; tmpIdx++){
				splitNum[tmpIdx] = Integer.parseInt(tmp[tmpIdx]);
			}

			splitNums.add(splitNum);
		}


		insertionSort();

		System.out.println(makeAnswer());


	}


	private static void insertionSort(){



		for (int idx = 1; idx <splitNums.size(); idx++){

			Integer[] targetNum = splitNums.get(idx);

			boolean moveFront = true;

			for (int compareIdx = idx-1; compareIdx >= 0; compareIdx--){

				Integer[] compareNum = splitNums.get(compareIdx);


				// 1.정수부의 비교
				if(targetNum[0] < compareNum[0]){
					continue;
				} else if (targetNum[0] > compareNum[0]){
					insert(idx, compareIdx);
					moveFront = false;
					break;
				// 2. 정수부가 같은 경우 소수부 비교하기
				} else {
					// 2-1.둘 중에 하나라도 소수부가 없는 경우
					if (targetNum.length == 1 || compareNum.length == 1){
						if (targetNum.length == 1 &&  compareNum.length == 1){
							insert(idx, compareIdx);
							moveFront = false;
							break;
						} else if (targetNum.length == 1 && compareNum.length ==2){
							continue;
						} else if (targetNum.length == 2 && compareNum.length == 1){
							insert(idx, compareIdx);
							moveFront = false;
							break;
						}
					// 2-2. 소수부가 둘 다 있는 경우
					} else {
					if (targetNum[1] > compareNum[1]) {
						insert(idx, compareIdx);
						moveFront = false;
						break;
					} else if (targetNum[1] < compareNum[1]){
						continue;
					} else {
						insert(idx, compareIdx);
						moveFront = false;
						break;
					}
					}

				}


			}

			// 맨 앞자리로 오는 경우
			if (moveFront){
				insert(idx, -1);
			}



		}
	}


	private static void insert(int targetIdx, int compareIdx){
		Integer[] targetNum = splitNums.get(targetIdx);
		splitNums.remove(targetIdx);
		splitNums.add(compareIdx+1, targetNum);
	}


	private static String makeAnswer(){
		StringBuilder sb = new StringBuilder();

		for (int idx = 0; idx < splitNums.size(); idx++){
			Integer[] splitNum = splitNums.get(idx);

			sb.append(splitNum[0]);
			if (splitNum.length == 2){
				sb.append("." + splitNum[1]);
			}
			sb.append("\n");
		}

		sb.deleteCharAt(sb.length()-1);

		return sb.toString();

	}

}
