package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Merge_sort_이상영_이효리 {

	public static void main(String[] args) throws IOException {
		
		// 데이터 입력
		System.out.println("정렬하고자 하는 숫자를 띄어쓰기로 구분하여 입력하세요 : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] data = new int[st.countTokens()];
		
		for (int idx = 0; idx < data.length; idx++) {
			data[idx] = Integer.parseInt(st.nextToken());
		}

		// 병합 정렬 메소드 호출
		merge_sort(data);
		
		// 결과출력
		System.out.println(Arrays.toString(data));
	}

	
	public static void merge_sort(int[] data) {
		merge_sort(data, 0, data.length-1);
	}
	
	// 병합 정렬 메소드
	public static void merge_sort(int[] data, int start, int end) {

		// 나누다가 길이가 1이면 리턴
		if (start >= end) return;
		
		// 자르는 기준 인덱스
		// 처음의 배열에서 논리적으로 나눠서 사용. 
		// 시작, 끝 인덱스를 정해서 논리적으로 나눔. 
		int mid = start + (end - start) / 2;
		
		
		// 인덱스로 반으로 나눠 재귀호출
		// 호출하다가 길이가 1이면 나눈 부분을 병합해 가면서 리턴됨. 
		merge_sort(data, start, mid);
		merge_sort(data, mid+1, end);
		

		// 논리적으로 나눈 배열의 시작 인덱스(포인터)와 끝나는 인덱스를 변수로 만듦.  
		int pntr_1 = start;
		int end_1 = mid;
		int pntr_2 = mid+1;
		int end_2 = end;
		
		// 임시 결과 배열
		// 임시 결과 배열에 정렬하고 완성되면 원본 배열에 복사한다.
		int total_length = end-start+1;
		int[] tmp_array = new int[total_length];
		// 임시 결과 배열의 포인터
		int idx = 0;
		
		
		
		// 두 배열 중 하나라도 다 정렬하면 멈춘다.
		while(pntr_1 <= end_1 && pntr_2 <= end_2) {
			
			// 나눈 배열들을 첫번째 원소부터 확인하며 더 작은 것을 결과 배열로 옮겨줌. 
			// 카운터+1
			if (data[pntr_1] < data[pntr_2]) {
				
				tmp_array[idx++] = data[pntr_1++];
				
			} else {
				
				tmp_array[idx++] = data[pntr_2++];
				
			}
		}
		
		
		// 남은 배열의 남은 원소를 결과 배열로 전부 옮기기 
		// 결과 배열의 길이는 나눈 두 배열의 길이를 합한 것이므로
		// 남은 배열을 전부 다 옮기면 결과 배열의 마지막까지 채움. 
		if (pntr_1 > end_1) {
			for (int index = pntr_2; index <= end_2; index++, idx++) {
				tmp_array[idx] = data[index];
			}
		} else {
			for (int index = pntr_1; index <= end_1; index++, idx++) {
				tmp_array[idx] = data[index];
			}
		}
		
		
		// 원본 배열에 결과 배열 복사. 
		for (int index = 0; index < tmp_array.length; index++) {
			data[start+index] = tmp_array[index];
		}

	}
}
