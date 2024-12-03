package inClass;
import java.util.EmptyStackException;

public class LinkedListStack<E> implements IStack<E>{

	
	private Node<E> top = null;
	
	@Override
	public void push(E e) {	// 첫노드로 삽입
		top = new Node<>(e, top);
	}

	@Override
	public E pop() { // 첫노드 삭제 후 반환
		if (isEmpty()) {
			// 런타임 익셉션이라 필수로 처리해주지 않아도 됨. 
			throw new EmptyStackException();
		}
		
		Node<E> popNode = top;
		top =  popNode.getLink();
		popNode.setLink(null);
		return popNode.getData();
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return top.getData();
	}

	
	// 보통 사이즈 관리하는 변수를 만듬
	// 여기서는 전체 순회하는 것을 실습해보기 위해 전체 순회해서 사이즈 알아보기로 함. 
	@Override
	public int size() {
		int size = 0;
		
		for (Node<E> temp = top;temp != null; temp = temp.getLink()) {
			++size;
		}
		
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
	
}
