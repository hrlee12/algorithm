package dfs_bfs;

public class PRO_네트워크 {
    public static void main(String[] args) {
        int result = Solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println(result);
    }


    class Solution {
        public static int result;
        public static int[][] adj;
        public static boolean[] visited;
        public static int solution(int n, int[][] computers) {

            adj = computers;
            visited = new boolean[computers.length];

            for (int idx = 0; idx < adj.length; idx++) {
                if (visited[idx] == true) continue;
                result++;
                dfs(idx);
            }

            return result;
        }


        public static void dfs(int current){

            visited[current] = true;

            for(int idx = 0; idx < adj.length; idx++) {
                if (adj[current][idx] == 0) continue;
                if (visited[idx] == true) continue;
                dfs(idx);

            }
        }
    }
}
