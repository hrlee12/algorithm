package algorithm.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * SWEA_1218 괄호 짝짓기
 * 
 * 주어진 괄호가 짝이 맞는지 확인하는 문제
 * 
 * 괄호가 짝이 맞으려면?
 * 닫는 괄호가 나왔을 때 가장 최근에 나온 여는 괄호와 짝이 맞아야 됨. 
 * 즉, 가장 마지막에 넣은 요소가 가장 먼저 나오는 스택 자료형이 필요함. 
 * 
 * 
 * 풀이 과정
 * 
 * 괄호를 담은 배열에서 원소를 하나씩 빼며
 * 	1) 여는 괄호가 나오면 스택에 넣는다.
 *  2) 닫는 괄호가 나오면 스택에서 데이터를 빼서(가장 마자막에 넣은 요소) 비교
 *  	1) 짝이 맞으면 계속 진행
 *  	2) 짝이 다르면 flag를 false로 바꾸고 for문 탈출 -> 4번으로 가기
 *  	3) 스택이 비어있으면 flag를 false로 바꾸고 for문 탈출 -> 4번으로 가기
 *  3) 배열의 모든 원소를 다 확인했을 때, 
 *  	1) 스택에 원소가 없으면 flag는 true (그대로 두기)
 *  	2) 스택에 원소가 있으면 짝이 안 맞음 -> flag를 false로 바꿈. 
 *  4) flag 값을 확인하여 답을 출력. 
 * 
 * 
 * 
 * 변수
 * 
 * isOk : boolean  							플래그 변수
 * datas : char[]							괄호 입력값을 char배열로 변환하여 저장할 변수
 * stack : char<String> 					여는 괄호를 담을 스택
 * current_data : char						현재 datas에서 꺼내와 확인하고 있는 원소	
 * pop_elem : char 							스택에서 빼내온 원소				
 * 
 */




public class SWEA_1218_괄호짝짓기_이효리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 여는 괄호, 닫는 괄호를 각각 배열에 담아 사용
		char[] open = new char[] {'[', '{', '(', '<'};
		char[] close = new char[] {']', '}', ')', '>'};
		

		for (int tc=0; tc<10; tc++) {
			
			// 짝이 맞지 않으면 플래그를 false로 바꾸고 break
			// 짝이 맞으면 건드리지 않음.
			// 마지막에 검사했을 때 true 그대로면 짝이 맞고 false면 짝이 안 맞는거임. 
			boolean isOk = true;
			
			// 데이터 입력받기
			int length = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			
			// 괄호의 길이가 홀수면 짝이 안 맞으므로 
			// 더 볼 것도 없이 바로 결과 출력하고 다음 테스트케이스로 continue
			if (length % 2 == 1) {
				System.out.printf("#%d %d\n", tc+1, 0);
				continue;
			}
			
			
			char[] datas = input.toCharArray();
			Stack<Character> stack = new Stack();
			
			// datas의 모든 char를 하나씩 들여다보며 확인
			loop:
				for (int idx=0; idx<length; idx++) {
					// 현재 char 변수에 저장 
					char current_data = datas[idx];
					// 여는 괄호인지 확인
					for (char elem: open) {
						// 여는 괄호이면 스택에 넣고 continue해서 다음 char확인하러 가기
						if (current_data == elem) {
							stack.push(current_data);
							continue loop;
						}
					}
					
					// 여는 괄호가 아니었으면 닫는 괄호인지 확인
					for (int close_idx =0; close_idx<close.length; close_idx++) {
						// 어떤 닫는 괄호인지 확인 
						// 1) 해당 닫는 괄호가 아니면 continue해서 다음 닫는 괄호와 대조
						if (close[close_idx] != current_data) 
							continue;
						
						// 2) 해당 닫는 괄호이면 
							
						
						
						// 스택에서 여는 괄호 빼기 전에 스택에 원소가 있는지 확인
						// 없으면 짝이 안 맞는 것이므로 
						// flag를 false로 바꾸고 더 볼 필요가 없으므로 확인 종료
						if (stack.isEmpty()) {
							isOk = false;
							break loop;
						}
						char pop_elem = stack.pop();
						
						
						// 짝이 같은지 확인
						// 1) 짝이 같으면 다음 char 확인하러 가기 
						if (open[close_idx] == pop_elem) continue loop;
						
						// 2)짝이 다르면
						// 플래그 false로 바꾸고 테스트 케이스의 모든 char확인하는 루프 빠져나오기 
						isOk = false;
						break loop;
					}
				}
			
			
			// 스택에 원소가 남아있으면 여는 괄호가 더 많은 것이므로 짝이 안 맞음. 
			if (!stack.isEmpty()) {
				isOk = false;
			}
			
			
			//  결과 출력
			int result;
			if (isOk) {
				result = 1;
			} else {
				result = 0;
			}
			
			System.out.printf("#%d %d\n", tc+1, result);
		}
	}




	public static class Stack <T> {
		private T[] stack;
		private int index;
		private int size;
		private int default_size = 10;
		
		
		
		// 매개변수 없을 때 생성자.
		// 기본값으로 배열 초기화
		@SuppressWarnings("unchecked")
		public Stack() {
			this.stack = (T[])new Object[default_size];
			this.index = 0;
			this.size = default_size;
			
		}
		
		// 매개변수 있을 때 생성자
		// 한번에 여러개 값을 넣을 수 있도록 매개변수를 가변인수로 함. 
		public Stack(T...array) {
			this();
			
			// 입력 데이터가 default_size를 넘더라도
			// push메서드에서 자동으로 size 늘리게 함. 
			for (T atom: array){
				push(atom);
			}
			
		}
		
		
		
		public void push(T input) {
			// 현재 배열에 값이 다 채워져 있으면 사이즈를 늘림.
			if (this.index == this.size) {
				
				// length가 기존의 5배인 새로운 배열을 만들어서 값을 다 옮김. 
				this.size = this.size*5;
				T[] newStack = (T[])new Object[this.size];
				
				for (int idx = 0; idx<this.index; idx++) {
					newStack[idx] = this.stack[idx];
				}
				
				this.stack = newStack;
			}
			
			stack[this.index++] = input;
		}
		
		
		public T pop() {
			return this.stack[--this.index]; 
		}
		
		public T peek() {
			return this.stack[this.index-1];
		}
		
		public int size() {
			return this.index;
		}
		
		public boolean isEmpty() {
			return this.index==0 ? true : false;
		}
		
		public String toString() {
			String result = "";
			
			result += "[";
			
			for (int idx =0; idx <this.index; idx++) {
				result += stack[idx];
				
				if (idx < this.index-1) {
					result += ", ";
				}
			}
			
			result += "]";
			
			return result;
			
		}
		
		// 디버깅용 메서드
		int getSize() {
			return this.size;
		}

	}
	
}
