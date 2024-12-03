package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23971_ZOAC {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int gapRow = Integer.parseInt(st.nextToken());
		int gapCol = Integer.parseInt(st.nextToken());

		int rowAvariable = 1 + (row-1) / (gapRow+1);
		int colAvariable = 1 + (col-1) / (gapCol+1);

		System.out.println(rowAvariable * colAvariable);
	}
}
