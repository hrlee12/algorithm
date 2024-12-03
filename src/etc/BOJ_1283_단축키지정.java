/*

n의 개수 30개.
근데 n당 5 *10 = 50
즉, 30 * 50 = 1500개를 다 뒤져야 함.

별로 어려운 거 아닌데...

시간복잡도도 안 넘고.


그냥 정한 키워드를 set에 넣어서 그 set에 이미 존재하는지 확인하자.


 */



import java.io.*;
import java.util.*;

public class BOJ_1283_단축키지정 {
	private static Set<Character> symbol = new HashSet<>();
	private static char[][][] options;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int length = Integer.parseInt(br.readLine());
		options = new char[length][5][10];

		for (int idx = 0; idx < length; idx++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wordIdx = 0;
			while(st.hasMoreTokens()){

				// 배열의 서브 배열의 길이가 달라도 됨.
				// 자료형만 맞음면 됨.
				options[idx][wordIdx++] = st.nextToken().toCharArray();
			}
		}
		findSymbol();

		System.out.println(makeAnswer());

	}

	private static void findSymbol(){


		for (int idx = 0; idx < options.length; idx++){



			boolean getSymbol = false;

			// 앞글자 확인
			for (int wordIdx = 0; wordIdx < 5; wordIdx++){


				if ((int)options[idx][wordIdx][0] == 0){
					break;
				}
				if (symbol.contains(Character.toUpperCase(options[idx][wordIdx][0]))){
					continue;
				}

				symbol.add(Character.toUpperCase(options[idx][wordIdx][0]));
				getSymbol = true;
				char[] newWord = new char[options[idx][wordIdx].length+2];
				newWord[0] = '[';
				newWord[1] = options[idx][wordIdx][0];
				newWord[2] = ']';
				for (int charIdx = 1; charIdx<options[idx][wordIdx].length; charIdx++){
					newWord[2+charIdx] = options[idx][wordIdx][charIdx];
				}
				options[idx][wordIdx] = newWord;
				break;

			}

			if (getSymbol)
				continue;




			// 전체 훑기


			loop:
			for (int wordIdx = 0; wordIdx < 5; wordIdx++){



				if ((int)options[idx][wordIdx][0] == 0){
					break;
				}

				for (int charIdx = 1; charIdx < options[idx][wordIdx].length; charIdx++){
					// charCount++;
					if (symbol.contains(Character.toUpperCase(options[idx][wordIdx][charIdx]))){
						continue;
					}


					symbol.add(Character.toUpperCase(options[idx][wordIdx][charIdx]));

					char[] newWord = new char[options[idx][wordIdx].length+2];
					for (int newWordCharIdx = 0; newWordCharIdx < charIdx; newWordCharIdx++){
						newWord[newWordCharIdx] = options[idx][wordIdx][newWordCharIdx];
					}

					newWord[charIdx] = '[';
					newWord[charIdx+1] = options[idx][wordIdx][charIdx];
					newWord[charIdx+2] = ']';


					for (int newWordCharIdx = charIdx+1; newWordCharIdx < options[idx][wordIdx].length; newWordCharIdx++){
						newWord[newWordCharIdx+2] = options[idx][wordIdx][newWordCharIdx];
					}
					options[idx][wordIdx] = newWord;


					break loop;
				}
			}


			if (getSymbol)
				continue;
		}


	}

		private static String makeAnswer(){

			StringBuilder sb = new StringBuilder();

			for (int idx = 0; idx < options.length; idx++){
				for (int wordIdx = 0; wordIdx < options[idx].length; wordIdx++){
					if ((int)options[idx][wordIdx][0] == 0) break;

					for (int charIdx = 0; charIdx < options[idx][wordIdx].length; charIdx++){
						sb.append(options[idx][wordIdx][charIdx]);
					}
					sb.append(' ');
				}
				sb.append('\n');
			}

			sb.delete(sb.length()-1, sb.length());

			return sb.toString();
		}
}
