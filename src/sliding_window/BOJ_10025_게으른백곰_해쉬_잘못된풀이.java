package sliding_window;

import java.io.*;
import java.util.*;

public class BOJ_10025_게으른백곰_해쉬_잘못된풀이 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int bucketNum = Integer.parseInt(st.nextToken());
		int windowSize = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> buckets = new HashMap<>();

		for (int idx = 0; idx < bucketNum; idx++){
			st = new StringTokenizer(br.readLine());
			int amount = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());

			buckets.put(location, amount);
		}

		Iterator<Integer> i = buckets.keySet().iterator();
		while(i.hasNext()){
			int key = i.next();

			System.out.println(key + " : " + buckets.get(key));
		}

		System.out.println("-------------------");
		Integer[] bucketLocations = buckets.keySet().toArray(new Integer[0]);

		Arrays.sort(bucketLocations);
		System.out.println(Arrays.toString(bucketLocations));
		int maxIce = 0;
		int currentIce = 0;
		for (int idx = bucketLocations[0]; idx < bucketLocations[0] + windowSize; idx++){

			if (buckets.containsKey(idx)){
				currentIce += buckets.get(idx);
			}
		}

		if (maxIce < currentIce){
			maxIce = currentIce;
		}

		System.out.println(maxIce);

		for (int startIdx = 1; startIdx < bucketLocations.length; startIdx++){
			int locationGap = bucketLocations[startIdx] - bucketLocations[startIdx-1];
			if (locationGap >= windowSize){
				currentIce = 0;
				for (int idx = 0; idx < windowSize; idx++){
					if (startIdx + idx > 1000000){
						break;
					}
					if (buckets.containsKey(startIdx + idx)){
						currentIce += buckets.get(startIdx + idx);
					}
				}
			} else {
				for (int idx = 0; idx <startIdx; idx++){
					while(true){
						int targetIdx = startIdx-idx-1;

						if (bucketLocations[startIdx] - bucketLocations[targetIdx] <= locationGap && buckets.containsKey(targetIdx)){
							currentIce -= buckets.get(targetIdx);
						} else {
							break;
						}
					}
				}

				int addLocation = bucketLocations[startIdx-1]+windowSize;

				for (int idx = 0; idx < addLocation; idx++){
					if (idx > 1000000){
						break;
					}
					if (buckets.containsKey(idx)){
						currentIce += buckets.get(idx);
					}
				}

			}


			if (currentIce > maxIce){
				maxIce = currentIce;
			}

			System.out.println(maxIce);

		}


		System.out.println(maxIce);
	}
}
