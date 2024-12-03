package 힙;

import java.util.PriorityQueue;

public class PriorityQueue연습 {
	public static void main(String args[]) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(3);
		queue.offer(5);
		queue.offer(2);

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
