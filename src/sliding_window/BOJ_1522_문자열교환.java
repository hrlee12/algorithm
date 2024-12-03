package sliding_window;/*
<메인 아이디어>
b를 바꿔서 a가 연속되게 해야 함.
-> a의 길이만큼의 구간에서 b의 갯수의 최솟값을 구하자 !

결국 해당 구간에서 b를 a로 1:1로 바꿔야 하므로
b의 수가 교환의 수가 된다!

이때 사용되는 방식이 슬라이딩 윈도우 방식 !


< 슬라이딩 윈도우 >
고정 사이즈의 윈도우가 이동하면서 계산
윈도우가 이동할 때 제외된 값과 추가된 값만 반영하면 됨!

투포인트 알고리즘은 구간의 넓이가 바뀜.
슬라이딩 윈도우는 고정이기 때문에 시작 인덱스만 알면 됨 !
 */


import java.io.*;


public class BOJ_1522_문자열교환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int aNumber = 0;
		int minB = Integer.MAX_VALUE;


		// a의 갯수 세기
		for (int idx = 0; idx < input.length; idx++){
			if (input[idx] == 'a'){
				aNumber++;
			}
		}

		// 한칸씩 이동하면서 확인하므로
		// 굳이 매번 원소를 전부 확인할 필요 없이 최초로만 전부 다 확인하고
		// 한칸 옮길 때마다 제외되는 앞칸이랑 추가되는 뒷칸만 확인해서 값을 강신하자!
		int currentB = 0;

		// 인덱스 0에서는 전부 다 확인!
		for (int idx = 0; idx < aNumber; idx++){
			if (input[idx] == 'b')
				currentB++;
		}

		if (minB > currentB){
			minB = currentB;
		}


		// 이제 인덱스 1부터는 시작 전값과 마지막 값만 확인하면서 갱신하자.
		for (int startIdx = 1; startIdx < input.length; startIdx++){

				if (input[startIdx-1] == 'b'){
					currentB--;
				}


				int lastIdx = startIdx + aNumber-1;

				// 앞과 뒤가 연결된 연결리스트이므로
				// 최대 인덱스 넘었으면 나머지로 인덱스 구하기
				if (lastIdx / input.length >= 1)
					lastIdx %= input.length;

				if (input[lastIdx] == 'b'){
					currentB++;
				}

				if (minB > currentB){
					minB = currentB;
				}
		}


		System.out.println(minB);

	}
}
