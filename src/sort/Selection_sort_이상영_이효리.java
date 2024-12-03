package sort;

import java.util.*;
import java.io.*;

public class Selection_sort_이상영_이효리 {
	public static void main(String[] args) throws IOException {
		
		// 입력 받기
		System.out.println("정렬하고자 하는 숫자를 띄어쓰기로 구분하여 입력하세요 : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] data = new int[st.countTokens()];
		
		for (int idx = 0; idx < data.length; idx++) {
			data[idx] = Integer.parseInt(st.nextToken());
		}
		
		// 선택 정렬 메소드 호출
		selection_sort(data);
		
		// 결과 출력
		System.out.println(Arrays.toString(data));
	}
	
	
	// 선택 정렬 메소드
	public static void selection_sort(int[] data){
		// 포인터를 따라
		for (int pointer = 0; pointer<data.length-1; pointer++) {
			// 일단 맨 처음 원소를 min에 넣음. 
			int min = data[pointer];
			int min_idx = pointer;

			// 두번째 원소부터
			for (int idx = pointer+1; idx <data.length; idx++) {
				// 더 작으면 min에 넣음. 
				if (data[idx] < min) {
					min = data[idx];
					min_idx = idx;
				}

			}
			
			// 포인터 위치의 원소와 제일 작은 원소의 위치를 바꿈. 
			data[min_idx] = data[pointer];
			data[pointer] = min;
		}
		
	}
}
