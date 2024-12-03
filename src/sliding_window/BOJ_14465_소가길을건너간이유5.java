package sliding_window;


import java.io.*;
import java.util.*;

public class BOJ_14465_소가길을건너간이유5 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int crosswalkNum = Integer.parseInt(st.nextToken());
		int windowSize = Integer.parseInt(st.nextToken());
		int brokenNum = Integer.parseInt(st.nextToken());

		boolean[] isBroken = new boolean[crosswalkNum+1];

		for (int idx = 0; idx < brokenNum; idx++){
			isBroken[Integer.parseInt(br.readLine())] = true;

		}

		int minBroken = Integer.MAX_VALUE;
		int currentBroken = 0;
		for (int idx = 1; idx < windowSize+1; idx++){
			if (isBroken[idx])
				currentBroken++;
		}

		if (minBroken > currentBroken)
			minBroken = currentBroken;


		for (int idx = 2; idx < isBroken.length-windowSize+1; idx++){
			if (isBroken[idx-1])
				currentBroken--;

			if (isBroken[idx+windowSize-1])
				currentBroken++;

			if (minBroken > currentBroken)
				minBroken = currentBroken;
		}


		System.out.println(minBroken);
	}
}