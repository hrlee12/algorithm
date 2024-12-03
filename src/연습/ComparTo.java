package practice;

public class ComparTo {
	public static void main(String[] args) {
		Integer x = 4;
		Integer y = 3;
		Double z = 1.0;

		// Integer의 경우
		// 기본 자료형은 안되고 Wrapper 클래스만 됨.
		// 클 때는 1 반환
		System.out.println(x.compareTo(y));
		// 작을 때는 -1 반환
		System.out.println(y.compareTo(x));
		// 같으면 0 반환
		System.out.println(x.compareTo(4));
		// Double도 가능
		System.out.println(z.compareTo(2.7));

		// int의 경우
		// Integer.compare(x, y)
		int a = 1;
		int b = 2;
		System.out.println(Integer.compare(a, b));


		// 문자열 비교

		System.out.println("======= 문자열 =======");
		String str = "abcd";

		// 1) 두 문자열의 일부가 시작부터 순서와 문자가 일부 같을 때
		// 같은 문자열일 경우 0 반환
		System.out.println(str.compareTo("abcd"));
		// 비교 문자열이 해당 문자열에 포함되어 있을 경우 길이의 차이를 반환
		System.out.println(str.compareTo("ab"));
		System.out.println(str.compareTo("a"));
		System.out.println("a".compareTo(str));
		// 빈문자열은 항상 포함되었다고 봄.
		System.out.println("".compareTo(str));
		System.out.println(str.compareTo(""));
		// 길이 반환은 처음부터 순서대로 같아야 함.
		// 이 경우엔 c는 첫번째 a와 같지 않으므로 a에서 아스키 코드를 빼서 반환함.
		// 97 - 99
		System.out.println(str.compareTo("c"));

		// 문자열 둘다 일부만 순서와 문자가 같은 경우. (중간에서 분기)
		// 달라지는 부분의 문자의 아스키 코드를 빼줌.
		// c = 99, f = 102
		System.out.println(str.compareTo("abfd"));


		// 비교대상과 전혀 다른 문자열인 경우

		// 위와 마찬가지로 문자열의 순서와 문자가 다른 지점의 문자열 아스키값을 빼줌.
		// a = 97, z = 122
		System.out.println(str.compareTo("zefd"));
		// 대소문자 구분함.
		System.out.println(str.compareTo("ABCD"));
		// 대소문자 무시하고 비교해주는 함수 compareToIgnoreCase()
		System.out.println(str.compareToIgnoreCase("ABCD"));
	}
}
