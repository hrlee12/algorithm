package algorithm.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_2164_카드2_이효리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> numbers = new LinkedList<Integer>();
		
		int length = sc.nextInt();
		
		for (int num = 1; num <= length ; num++) {
			numbers.add(num);
		}
		while (numbers.size() > 1) {
			numbers.poll();
			int tmp = numbers.poll();
			numbers.offer(tmp);
		}
		System.out.println(numbers.poll());
	}
}