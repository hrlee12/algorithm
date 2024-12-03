package etc;

import java.util.*;
import java.io.*;
public class BOJ_2292_벌집 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());

		if (number == 1) {
			System.out.println(1);
			return;
		}

		double tmp = (number - 1) / Double.valueOf(6);
		int count = 0;
		int sum = 0;

		while (true) {
			count++;
			sum += count;

			if (sum >= tmp) {
				break;
			}
		}

		System.out.println(count + 1);

	}
}
