package algorithm.combination;



/*
 * BOJ_2493 탑
 * 
 * 높이가 더 높은 애가 뒤에 오면 쓰일 일 없음 - 삭제
 * +
 * 나랑 가까운 애부터 비교 
 * 
 * -> 나랑 가까운 애부터 삭제 -> 후입선출 -> 스택
 * 
 * 
 * 나는 딱 보면 왼쪽에 레이저가 닿고 안 닿고가 파악이 됨.
 * 그치만 컴퓨터는 못 하니 컴퓨터가 알아볼 수 있게 짜는 게 핵심. 
 * 
 * 
 * 나랑 가장 가깝고 나보다 큰 애한테 닿음.
 * 즉, 현재 스택에 들어와있는 애가 뒤의 애보다 작으면 영원히 닿을 일 없음. 
 * 굳이 안 쓰이는데 얘까지 확인할 필요가 없으므로 pop. 
 * 
 * 그렇게 하면 스택에는 큰-> 작 순으로 들어있음. 
 * 큰 게 뒤에 나오면 죄다 빼버리기 때문. 
 * 
 * 아무튼 그렇게 해서 닿는 게 없으면(맨 처음 / 앞에 나보다 큰 게 안 나올 경우)
 * stack안에 아무것도 없음. 
 * 
 * 나보다 작은 애는 다 빼버리고 나서 stack에 가장 위에 있는 애한테 내가 닿는거임. 
 *  
 * 
 * 1. 안에 나보다 더 작은 게 없을 때까지 pop 
 * 2. 안에 아무것도 없으면 0저장. 있으면 그 녀석의 인덱스 저장. 
 * 
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Stack;


public class BOJ_2493_탑_이효리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<length; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			while (true) {
				if (stack.isEmpty()) {
					sb.append(0 + " ");
					break;
				}
				if (stack.peek()[0] > target) {
					sb.append(stack.peek()[1] + " ");
					break;
				} else {
					stack.pop();
				}
			}
			
			stack.add(new int[] {target, i+1});
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
	}
}
		
		
		
		
		
		
		
		
/*		
 * 오답
 * 
 * 링크드리스트 두개를 사용해서 하나는 정렬, 하나는 그대로. 
 * 
 *  
 * 작은 것부터 확인하고 삭제해서 내 왼쪽 것이 답이게 하는 건 획기적이었지만 (나보다 작았으면 이미 삭제됨)
 * 
 * 그러면 탑들의 인덱스가 가변적이어서 한 녀석에 대해 할 때마다 indexOf()로 확인해서 N만큼 이터레이션을 돌게 됨. 
 * 
 * 좋은 아이디어 같아 보였지만 삭제하는 것은 인덱스가 가변적이어서 좋지 않았음. 
 * 오케이? 
 * 인덱스를 계속 새로 찾아야 하는 경우 말짱 도루묵임 !!!
 * 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
//		int[][] towers = new int[length][2];
		List<int[]> towers_sort = new LinkedList<>();
		List<int[]> towers = new LinkedList<>();
		int[] result = new int[length];
		
		for (int idx =0; idx<length; idx++) {
			int[] tower = new int[2];
			tower[0] = Integer.parseInt(st.nextToken());
			tower[1] = idx;
			towers_sort.add(tower);
			towers.add(tower);
		}
		
//		for (int[] elem: towers) {
//			System.out.println(Arrays.toString(elem));
//		}
//		
		
		Collections.sort(towers_sort, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o2[0] - o1[0];
				else 
					return o2[1] - o1[1];
			}
		});
		
		
//		for (int[] elem: towers_sort) {
//			System.out.println(Arrays.toString(elem));
//		}
//		
		for (int idx=length-1; idx>=0; idx--) {
			int[] tower = towers_sort.get(idx);
			int current_idx = towers.indexOf(tower);
			if (current_idx == 0) {
				result[tower[1]] = 0;
			}
			else {
				int[] target = towers.get(current_idx-1);
				result[tower[1]] = target[1]+1;
			}
//			towers_sort.delete(current_idx);
			towers.remove(current_idx);
			towers_sort.remove(idx);			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int elem : result) {
			sb.append(elem + " ");
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
*/		

