package etc;

import java.io.*;
import java.util.*;


public class BOJ_5073_삼각형과세변 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



		while (true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] lengths = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

			if (lengths[0] == 0 && lengths[1] == 0 && lengths[2] == 0)
				break;


			if (lengths[0] == lengths[1] && lengths[1] == lengths[2]){
				System.out.println("Equilateral");
			} else if (lengths[0] >= lengths[1] + lengths[2] || lengths[1] >= lengths[0] + lengths[2] || lengths[2] >= lengths[0] + lengths[1]  ){
				System.out.println("Invalid");

			} else if (lengths[0] == lengths[1] || lengths[1] == lengths[2] || lengths[0] == lengths[2]){
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		}
	}
}
