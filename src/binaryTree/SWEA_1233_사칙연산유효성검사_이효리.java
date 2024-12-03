package algorithm.binaryTree;

/*
 * SWEA_1233_사칙연산 유효성 검사
 * 
 * 유효한 경우
 * 단말노드에 모두 양의 정수가 나옴
 * 그 외의 노드는 모두 사칙연산이 들어감. 
 * 단말 노드가 아닌 경우 차수는 2개여야 함. 
 * 
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.io.FileReader;



public class SWEA_1233_사칙연산유효성검사_이효리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
//		BufferedReader br = new BufferedReader(new FileReader("./input_operator.txt"));
		String[] operators = new String[] {"*", "/", "-", "+"};
		for (int tc =0; tc<10; tc++) {
			int length = Integer.parseInt(br.readLine());

	
			int degree = 0;
			int max_node = 1;
			while (true) {
				if (length < max_node) 
					break;
				
				max_node *= 2;
				degree++;
				
			}
			String[] nodes = new String[length];
			int number_node = max_node / 2;
			
			
			
			boolean isOk = true;
			for (int idx = 0; idx<length; idx++) {
				
				
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				nodes[idx] = st.nextToken();
			}
			
			if (length % 2 == 0) {
				System.out.println("length 잘 못됨 : " + length);
				System.out.printf("#%d %d\n", tc+1, 0);
				continue;
			}
			System.out.println("max_node" + max_node);
			System.out.println("number_node" + number_node);
			for (int idx = 0; idx<length; idx++) {
				
				boolean isOperator = false;
				
				for (String operator: operators) {
					if (nodes[idx].equals(operator)) isOperator = true;
				}
				


				if (idx <number_node && isOperator == false) {
					System.out.printf("연산자인데 숫자 length: %d  node_num : %d value: %s", length, idx+1, nodes[idx]);
						isOk = false;
						break;
				}
				
				if (idx >= number_node && isOperator == true) {
					System.out.printf("숫자인데 연산자 length: %d  node_num : %d value: %s", length, idx+1, nodes[idx]);
						isOk = false;
						break;
				}
				
				
						
					
			}
			
			String output = "#" + (tc+1) + " ";
			
			if (isOk) 
				output += 1;
			else 
				output += 0;
			
			System.out.println(output);
		}
	}

}
