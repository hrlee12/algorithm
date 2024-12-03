package DFS_BFS;

import java.util.LinkedList;
import java.util.List;





/*
문제 : begin에서 target으로 단어를 변환하려한다.
 words 내부의 단어들로만 바꿀 수 있고 스팰링이 하나만 다른 경우만 바꿀 수 있다.
 최소 몇번 변환해야 하는지 구하시오 (변환 불가능한 경우 0 반환)

 여기서 키포인트는 target이 words 중에 없으면 변환 불가능 하다는 점이다.
 말그대로 "words 내부의 단어들로만 변환 가능" 이다. 하하하



 변환 가능한 관계를 인접하다고 정의하고 풀면 어렵지 않다.



 */
public class 단어변환 {

    public static void main(String[] args) {
        int result = Solution.solution("mix", "gap", new String[]{"max", "map", "gap", "mag", "mex"});
        System.out.println(result);
    }



    class Solution {

        public static boolean[] visited;
        public static String[] word;
        public static boolean[][] adj;
        public static int word_length;
        public static String start, end;




        public static int solution(String begin, String target, String[] words) {

            start = begin;
            end = target;
            word = new String[words.length+1];
            word[0] = begin;


            // words 중에 target이 없는지 체크
            boolean containEnd = false;

            // begin도 배열에 포함시켜서 탐색 진행 (begin부터 시작)
            for (int idx = 0; idx < words.length; idx++) {
                if (words[idx].equals(end)) {
                    containEnd = true;
                }
                word[idx+1] = words[idx];
            }

            // words 중에 target이 없으면 바로 0 리턴
            if (containEnd == false) {
                return 0;
            }
            visited = new boolean[word.length];
            adj = new boolean[word.length][word.length];
            word_length = word[0].length();

            // 인접 배열 생성
            makeAdj();


            // bfs 진행하다가 target 발견하면 깊이 리턴
            return bfs();
        }



        // adj 배열 생성.
        // 알파벳 하나만 다른 경우, 인접한 관계
        public static void makeAdj(){



            for (int idx = 0; idx < word.length; idx++) {
                char[] target = word[idx].toCharArray();

                for (int compare_idx = idx+1; compare_idx < word.length; compare_idx++) {
                    char[] compare = word[compare_idx].toCharArray();
                    int different_count = 0;
                    for (int char_idx = 0; char_idx < word_length; char_idx++) {
                        if (target[char_idx] != compare[char_idx]) {
                            different_count++;
                        }
                    }

                    if (different_count == 1) {
                        adj[idx][compare_idx] = true;
                        adj[compare_idx][idx] = true;
                    }
                }
            }
        }



        // 최소 길이를 구하는 문제로 bfs (더 효율적)
        public static int bfs(){
            int result = 0;
            List<int[]> queue = new LinkedList<>();


            queue.add(new int[]{0, 0});
            visited[0] = true;

            loop:
                while(!queue.isEmpty()){

                    int[] target = queue.remove(0);
                    int target_idx = target[0];
                    int target_depth = target[1];

                    System.out.println("pop : " + word[target_idx]);
                    System.out.println(target_depth);




                    for (int idx = 0; idx < word.length; idx++) {
                        if (visited[idx] == true) continue;
                        if (adj[target_idx][idx] == false) continue;

                        System.out.println("add : " + word[idx]);
                        if (word[idx].equals(end)){
                            result = target_depth+1;
                            break loop;
                        }
                        visited[idx] = true;
                        queue.add(new int[]{idx, target_depth+1});
                    }
                }

            return result;
        }
    }
}
