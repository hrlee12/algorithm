package algorithm.etc;

import java.util.Scanner;

public class BOJ_17478_재귀함수가뭔가요_이효리 {
	
	static int count = 0;
	
	public static void recursion(int num){
		String underScore = "";
		
		for (int i =0; i<count; i++) {
			underScore += "____";
		}
		
		if (count == 0) {
			System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		}
		
		System.out.print(underScore);
		System.out.print("\"재귀함수가 뭔가요?\"\n");
		
		if (count < num) {
			System.out.print(underScore);
			System.out.print("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			System.out.print(underScore);
			System.out.print("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			System.out.print(underScore);
			System.out.print("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			count++;
			recursion(num);
		}
		
		if (count >= num) {
			System.out.print(underScore);
			System.out.print("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			count = 0;
		}
		System.out.print(underScore);
		System.out.print("라고 답변하였지.\n");			
	}
	

	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		recursion(in.nextInt());
		
		

	}
}
