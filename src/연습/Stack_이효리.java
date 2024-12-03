package algorithm_practice;

/* class Stack
 * 
 * 
 * 가지고 있어야 할 변수
 * 
 * stack: T[]			데이터를 저장할 배열
 * index: int			현재 채워진 인덱스
 * size: int			전체 배열 크기
 * default_size :int    배열이 초기화되는 길이
 * 
 * 구현해야 할 기능
 * 
 * push(): 				void 뒤에서 넣기
 * pop(): <T>  			뒤에서 삭제
 * 						-> 그냥 배열의 뒤에서 넣기 빼기 하면 될 듯. 
 *    				             애초에 스택은 단방향으로만 넣고 빼고 하니까 뒤로만 넣고 빼고 하면 됨. 
 * peek(): <T> 			맨 위의 원소 반환(삭제는 안 함)
 * size() : int  		사이즈 반환
 * isEmpty() : boolean 	비어있는지 확인
 * toString() : String 
 * getSize() : int		디버깅용 메서드. 데이터를 저장한 배열의 크기를 반환. 
 * 
 */

public class Stack_이효리{
	
	
	public static void main(String args[]){
		
		// 초기화 테스트
		Stack<Integer> stack = new Stack(1, 2, 3);
		System.out.println("--------초기화 테스트---------");
		System.out.println(stack);

		// push test
		stack.push(4);
		System.out.println("--------push test---------");
		System.out.println(stack);
		
		// pop/peek test
		System.out.println("--------pop/peek test ---------");
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		
		// isEmpty/size test
		System.out.println("--------isEmpty/size test ---------");
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.getSize());
		
		
		// push시 사이즈 초과하면 자동으로 늘리는 기능 잘 되는지 test
		System.out.println("--------사이즈 초과시 자동으로 늘리기 test ---------");
		int[] tmp = new int[100];
		for (int i =0; i<100; i++) {
			stack.push(i);
			tmp[i] = i;
		}
		
		System.out.println(stack);
		System.out.println(stack.getSize());
		
		
		// 초기화 시 size 초과하면 자동으로 늘리는 기능 잘 되는지 test
		System.out.println("--------초기화 시, 사이즈 초과하면 자동으로 늘리기 test ---------");
		Stack<Integer> stack2 = new Stack<Integer>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		System.out.println(stack2);
		System.out.println(stack2.getSize());
	
	
		Stack<String> stack3 = new Stack<>("가");
		System.out.println(stack3);
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
			return this.index == 0 ? true : false;
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