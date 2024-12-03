
import java.io.*;
import java.util.*;


public class SWEA_5643_키순서_이효리 {
	public static int N, M, answer, outCnt;
	public static boolean[] visited;
	public static int[] totalCnt;
	public static List<Integer>[] students;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = null;		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			students = new ArrayList[N + 1];
			totalCnt = new int[N + 1];
			
			for (int i = 1; i <= N; ++i) {
				students[i] = new ArrayList<Integer>();
			}
			
			for (int i = 1; i <= M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				students[a].add(b);
			}
			
			int answer = 0;
			for (int i = 1; i <= N; ++i) {
				outCnt = 0;

				visited = new boolean[N + 1];
				visited[i] = true;
				go(i);
				totalCnt[i] += outCnt;
			}
            
			answer = 0;
			for (int i = 1; i <= N; ++i) {
				if (totalCnt[i] == N) {
					answer++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void go(int n) {
		outCnt++;
		
		for (int i = 0; i < students[n].size(); ++i) {
			int student = students[n].get(i);
			if (visited[student]) {
				continue;
			}
			
			visited[student] = true;
			totalCnt[student]++;
			go(student);
		}
	}
}