package algorithm_practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileInputTest {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./test.txt"));
		int a = Integer.parseInt(br.readLine());
		for (int i=0; i<5; i++) {
			String line = br.readLine();
			if (line==null) break;
			System.out.println(line);
		}
		
		int b = 3;
		
		String c = Integer.toString(b);
		System.out.println(c);
		
		System.out.println(c.equals("3"));
		
		

//		int j =0;
//		loop:
//			for (int i= 0; i<5; i++) {
//				j=0;
//				System.out.printf("i : %d\n", i);
//				while (true) {
//					System.out.printf("j : %d\n", j);
//					if (j>=5) break;
//					if (i== 3 && j==2) continue loop;
//					j++;
//				}
//			}
	}
}
