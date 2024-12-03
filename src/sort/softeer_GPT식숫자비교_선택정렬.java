package sort;

import java.util.*;
import java.io.*;
public class softeer_GPT식숫자비교_선택정렬 {

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





		selectionSort();

		System.out.println(makeAnswer());
	}


	private static void selectionSort(){



		for (int idx = 0; idx < splitNums.size()-1; idx++){
			int minIdx = idx;
			Integer[] minValue = splitNums.get(idx);
			for (int compareIdx = idx+1; compareIdx < splitNums.size(); compareIdx++){

				Integer[] compareNum = splitNums.get(compareIdx);

				// 1.정수부의 비교
				if (minValue[0] > compareNum[0]){

					minIdx = compareIdx;
					minValue = compareNum;

				// 2. 정수부가 같은 경우 소수부 비교하기
				} else if (minValue[0] == compareNum[0]){
					// 2-1.둘 중에 하나라도 소수부가 없는 경우
					// 중 minValue가 갱신되는 경우
					if (minValue.length == 2 && compareNum.length == 1){
							minIdx = compareIdx;
							minValue = compareNum;

					// 2-2. 소수부가 둘 다 있는 경우
					} else {
						if (minValue.length == 2 && compareNum.length == 2 && minValue[1] > compareNum[1]) {
							minIdx = compareIdx;
							minValue = compareNum;
						}
					}

				}




			}

			if (minIdx != idx) {
				splitNums.add(minIdx + 1, splitNums.get(idx));
				splitNums.remove(idx);
				splitNums.add(idx, minValue);
				splitNums.remove(minIdx);
			}


			}
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
