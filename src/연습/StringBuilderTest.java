package algorithm_practice;

import java.lang.StringBuilder;

public class StringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append("1 ");
		sb.append("2 ");
		
		System.out.println(sb.toString());
		sb.setLength(0);

		
		sb.append("안녕하세요");
		
		System.out.println(sb.length());
		System.out.println(sb.toString());
		System.out.println(sb.charAt(sb.length()-1));
		System.out.println(sb.deleteCharAt(sb.length()-1));
		System.out.println(sb.deleteCharAt(sb.length()-1));
		
	}

}
