package algorithm_practice;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String args[]){
		 List<List<Integer>> nums = new ArrayList<>();
		 List<Integer> num = new ArrayList<Integer>();
		 num.add(1);
		 num.add(2);
		 num.add(3);
		 nums.add(num);
		 
		 System.out.println(nums.indexOf(2));
		 

	}
}
