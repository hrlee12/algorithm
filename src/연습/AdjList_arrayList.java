package algorithm_practice;

import java.util.*;
import java.io.*;

public class AdjList_arrayList {

	public static List<List<Integer>> adj;

	
	public static void main(String[] args) {
		adj = new ArrayList<>();
		
		for (int idx=0; idx<6; idx++) {
			adj.add(new ArrayList<Integer>());
		}
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(3).add(1);
		adj.get(3).add(5);
		adj.get(5).add(3);
		
		for (List<Integer> elem : adj) {
			System.out.println(elem);
		}
		
		
	}

}
