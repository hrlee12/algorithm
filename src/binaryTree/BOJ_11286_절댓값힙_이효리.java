package algorithm.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

class Absolute_heap {
	List<int[]> nodes = new LinkedList<>();
	
	private int index = 1;
	
	public Absolute_heap() {
		nodes.add(new int[2]);
	}
	
	public void add(int num) {
		int[] node = new int[2];
		
		if (num >= 0) {
			node = new int[] {num, num};
		} else {
			node = new int[] {-num, num};
		}
		
		nodes.add(index++, node);
		
		int target_idx = index-1;
		while (true) {
			if ((target_idx)/2==0) {
				return;
			}
			
			int[] parent_node = nodes.get((target_idx)/2);
			if ((node[0] < parent_node[0]) ||( node[0] == parent_node[0] && node[1] < parent_node[1])) {
				nodes.set((target_idx)/2, node);
				nodes.set((target_idx), parent_node);		
				
				target_idx /= 2;
			} else
				return;
		}
	};
	
	public int remove() {
		if (index==1) {
			return 0;
		}
		System.out.println("삭제 전 인덱스 : " + index);
		
		int[] result_node = nodes.get(1);
		nodes.set(1, nodes.get(--index));
		System.out.println("삭제 후 : " + index);
		nodes.remove(index);
		System.out.println("삭제하는 노드 인덱스 : " + index);
		int target_idx = 1;
		while (true) {
			System.out.println("삭제 시 타겟노드 : " + target_idx);
			int[] target = nodes.get(target_idx);

			int left_idx = target_idx*2;
			int right_idx = target_idx*2+1;
			
			
			if (left_idx < index) { // 왼쪽 자식노드가 있을 경우 (왼쪽 자식노드가 없으면 오른쪽 자식노드도 없음)
				System.out.println("왼쪽 자식 있음");
				int[] left = nodes.get(left_idx);
				if (right_idx < index) { // 오른쪽 자식노드도 있을 경우
					System.out.println("오른쪽 자식 있음");
					int[] right = nodes.get(right_idx);
					int change_idx = -1;
					// 오른쪽 자식노드가 더 작을 경우
					if (left[0] > right[0] || (left[0]==right[0] && left[1] > right[1]))
						change_idx = right_idx;
					// 왼쪽 자식노드가 더 작을 경우
					else if(left[0] < right[0] || (left[0]==right[0] && left[1] < right[1]))
						change_idx = left_idx;
					// 자리 바꾸기 
					int[] change_node = nodes.get(change_idx);
					if (target[0] > change_node[0] || (target[0] == change_node[0] && target[1] > change_node[1])) {
						nodes.set(target_idx, nodes.get(change_idx));
						nodes.set(change_idx, target);
						target_idx = change_idx;
					} else {
						break;
					}
						
					
					
				} else { // 왼쪽 자식노드만 있을 경우
					System.out.println("왼쪽 자식만 있음");
					// 왼쪽 자식노드와 바꾸고 있는 노드 크기 비교 후 더 작으면 바꿈 
					if (target[0] > left[0] || (target[0] == left[0] && target[1] > left[1])) {
						nodes.set(target_idx, left);
						nodes.set(left_idx, target);
						target_idx = left_idx;
					} else // 왼쪽 자식노드만 있지만 더 작지 않은 경우 
						break;
				}
			
			}else {  // 자식 노드가 둘 다 없을 경우
				System.out.println("자식 없음");
				break;
			}
			System.out.println("자리 바꿨음");
					
		}
		return result_node[1];
}
	
	
	public void print() {
		int level = 1;
		int count = -1;
		for (int[] elem: nodes) {
			count++;
//			if (count == 0)
//				continue;
			System.out.print(Arrays.toString(elem) + " ");

			if ((int)(Math.pow(2, level)-1) == count){
				
				System.out.println();
				level++;
			}
		}
		System.out.println();
		System.out.println("-----------------------------");
		
	}
}


public class BOJ_11286_절댓값힙_이효리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int number = Integer.parseInt(br.readLine());
//		
//		Absolute_heap h = new Absolute_heap();
//		
//		for (int count = 0; count < number; count++) {
//			int input = Integer.parseInt(br.readLine());
//			if (input == 0) {
//				System.out.println(h.remove());
//			} else {
//				h.add(input);
//			}
//			
//			h.print();
//		}
//		
		
		Absolute_heap h = new Absolute_heap();
		h.add(1);
		h.print();
		h.add(5);

		
		h.print();
		
		h.remove();
		h.print();
		h.remove();
		h.print();
		h.remove();

//		
//		int level;
//		int count;
//		
//		level = 1;
//		count = -1;
//		for (int[] elem: h.nodes) {
//			count++;
//			if (count == 0)
//				continue;
//			System.out.print(Arrays.toString(elem) + " ");
//
//			if ((int)(Math.pow(2, level)-1) == count){
//				
//				System.out.println();
//				level++;
//			}
//		}
		

		
	}

	
	
}
