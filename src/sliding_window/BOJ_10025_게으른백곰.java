/*
전형적인 슬라이딩 윈도우 문제

알고리즘이 괜히 있는 게 아님.
슬라이딩 윈도우로 풀 수 있으면 무조건 슬라이딩 윈도우로 가자!!!!!!!!!

그리고 내가 푼 해쉬방법은 문제가 있어.
백곰의 위치가 양동이가 아니라 어정쩡한 위치에 있을 때 오히려 여러 양동이에 닿을 수 있잖아.
근데 나는 백곰의 위치가 무조건 양동이인 경우만 가정했어.
그럼 안되지.
만약 맞는 풀이라도 자잘한 계산이 맞아서 개빡치고 오래 걸림!!!!!!!
슬라이딩 윈도우 !!!!! 레고
 */


package sliding_window;



import java.util.*;
import java.io.*;


public class BOJ_10025_게으른백곰 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int bucketNum = Integer.parseInt(st.nextToken());
		int windowSize = Integer.parseInt(st.nextToken());
		windowSize = windowSize*2 + 1;
		int[] buckets = new int[1000001];

		for (int idx = 0; idx < bucketNum; idx++){
			st = new StringTokenizer(br.readLine());
			int iceNum = Integer.parseInt(st.nextToken());
			int bucketLocation = Integer.parseInt(st.nextToken());

			buckets[bucketLocation] = iceNum;
		}
		int maxIce = 0;
		int currentIce = 0;

		for (int idx = 0; idx < windowSize; idx++){

			if (idx > 1000000){
				break;
			}
			currentIce += buckets[idx];
		}


		if (maxIce < currentIce){
			maxIce = currentIce;
		}

		for (int idx = 1; idx+windowSize-1 <= 1000000; idx++){
			currentIce -= buckets[idx-1];
			currentIce += buckets[idx+windowSize-1];

			if (maxIce < currentIce){
				maxIce = currentIce;
			}
		}


		System.out.println(maxIce);
	}
}
