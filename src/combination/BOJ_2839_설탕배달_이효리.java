package algorithm.combination;


/*
 * 조건
1)	설탕 N kg 
2)	최대한 적은 봉지
봉지 3kg / 5kg


출력
봉지의 최소 개수.   불가능하면 -1


풀이 1)
자, 일단……. 중복 조합이라고 볼 수 있지. 
일단 조합을 0개부터 해서 답이 나올 때까지 점점 늘리기. 
흠…. 시간 괜찮으려나?
없을 경우는 어쩔건데? 
특정한 조합의 길이에서 모든 조합에서 N을 넘으면 끝내면 되겠지. 
일단 2+4+8+16+32+64+128 ……
근데 N이 5000이잖아. 
그치. 
5000/ 3 = 1700 (대략)
2**1701 인거임. 감당 가능?
무슨 수인진 모르겠지만 일단 1억 넘기 쌉가능. 
그러니까 조합은 안 됨 ! 



풀이 2) 
그리디. 
이게 선택가능한 수가 많으면 이렇게 하면 안되는데 선택 대상이 두개이기 때문에 모 아니면 도잖아? 그래서 괜찮을 듯
먼저 일단 5가 더 많으면 더 적게 들거라고 생각해볼 수 있겠지. 
그러니까 전부 5로 나누고 그 수 저장. 
5로 나눈 나머지가 3으로 딱 떨어지면 됨. 

5로 나눈 수를 저장하고 이제 for문으로 5를 하나씩 줄여가면서 나머지가 3으로 나눠지는지 계산. 
결국 전부 3으로 나눠도 안되면 -1 리턴. 

 * 
 */

public class BOJ_2839_설탕배달_이효리 {

	public static void main(String[] args) {
		int target_weight = 18;
		

	}

}
