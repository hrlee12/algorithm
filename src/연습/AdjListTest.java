package inClass;

/*
 * 인접 리스트로 표현
 */

import java.util.*;

public class AdjListTest {
	
	static class Node {
		int vertex;	
		Node next;
		
		
		
		
		public Node(int vertext, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
			
		}

		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node adjList[] = new Node[V];	// 헤드 리스트
		
		
		for (int i = 0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
	}
}