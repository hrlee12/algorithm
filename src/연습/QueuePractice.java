package algorithm_practice;


/*
 * 
 * 선입선출
 * 
 * Queue 인터페이스를 구현한 클래스로 사용
 *  - ArrayDeque
 *  - LinkedList
 * 
 * 언제 LinkedList 쓰다가 ArrayDeque쓰게 될지 모르니 Queue변수에 담아서 다형성 활용.
 * 
 * 메서드
 * 	poll() : 맨 앞의 원소 삭제. 원소가 없으면 null 반환
 *   add() / offer() : 맨 뒤로 원소 삽입
 *   size() : 사이즈 반환
 *   isEmpty() : 비어있는지 확인
 *   
 */
import java.util.Queue;
import java.util.LinkedList;

public class QueuePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		int num = queue.poll();
		System.out.println(num);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		

		
	}

}
