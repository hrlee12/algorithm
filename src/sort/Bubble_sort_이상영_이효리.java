package sort;

import java.io.*;
import java.util.*;


public class Bubble_sort_이상영_이효리 {

	public static void main(String[] args) throws IOException {
		
		// 입력 받기
		System.out.println("정렬하고자 하는 숫자를 띄어쓰기로 구분하여 입력하세요 : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] data = new int[st.countTokens()];
		
		for (int idx = 0; idx < data.length; idx++) {
			data[idx] = Integer.parseInt(st.nextToken());
		}
		
		// 버블 정렬 메소드 호출
		bubble_sort(data);
		
		// 결과 출력
		System.out.println(Arrays.toString(data));
	}
	
	// 버블 정렬 메소드
	public static void bubble_sort(int[] data) {
		// 뒤의 것부터 정렬되므로
		// 한번 돌때마다 탐색하는 길이를 줄여감. 
		int length = data.length;
		
		// 한번 돌때마다 마지막 하나씩 정렬되므로
		// 두번째것 정렬하면 첫번째 것도 정렬됨 -> 길이-1 번 돌기
		for (int count = 0; count < data.length-1; count++) {
			// 인덱스 뒤의 것이랑 비교하므로
			// 길이-2의 인덱스까지만 확인
			for (int idx = 0; idx <length-1; idx++) {
				// 현재 원소가 뒤의 원소보다 크면
				if (data[idx] > data[idx+1]) {
				// 자리 바꾸기
				int tmp = data[idx];
				data[idx] = data[idx+1];
				data[idx+1] = tmp;
				}
			}
			// 탐색 범위 하나 줄이기
			length--;
		}
	
	
	}
}
