/*
이 문제의 포인트는 주어진 논문 인용횟수 말고도 그 사이의 값들도 h-index가 될 수 있음을 간파하는 것임.
ex) [0, 1, 3, 5, 6, 7, 8]
이 경우 H-index는 4임.

그러니까 주어진 논문 인용횟수를 기준으로 하되, 그 사이사이 값들도 정확하게 체크하기.

 */






package sort;

import java.util.*;

public class H_index {

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{0, 2, 4, 5, 5}));
    }


    class Solution {
        public int solution(int[] citations) {

            // 일일이 다 확인하면 시간 초과
            // 정렬해서 인덱스로 비교하면 몇번 이상 인용된게 몇개인지 바로 알 수 있음.
            Arrays.sort(citations);

            int hIndex = 0;


            // 모든 논문 인용횟수를 기준으로 확인하되 그 사이 값들도 꼼꼼하게 전부 확인하기
            for (int idx =0 ; idx < citations.length; idx++) {


                // 첫번째 값보다 적은 경우 에크
                if (idx == 0) {
                    for (int subIdx = 0; subIdx < citations[0]; subIdx++) {
                        if (citations.length >= subIdx){
                            hIndex = subIdx;
                        }

                    }
                }

                // 현재 논문인용 횟수보다 큰 인용횟수를 비교해서 그만할지 정하기.
                if (citations.length-idx >= citations[idx]){


                    hIndex = citations[idx];

                    // 마지막 인용횟수라면 뒤 인덱스와 비교하지 않으므로 끝내기
                    if (idx == citations.length-1){
                        break;
                    }

                    // 다음 주어진 인용 횟수 사이의 값들 확인하기
                    for (int subIdx = 1; subIdx < citations[idx+1]-citations[idx]; subIdx++)
                        // 현재 인덱스의 논문은 포함하지 않으므로 인용 횟수 이상 논문 하나 빼주기
                        if (citations.length-idx-1 >= citations[idx]+subIdx){
                            hIndex = citations[idx]+subIdx;
                        } else {
                            // 사실 내부 for문 아니고 외부 for문 break 하는 게 맞음.
                            break;
                        }

                } else
                    break;
            }

            return hIndex;


        }
    }
}
