package sort;

import java.util.*;
import java.io.*;

public class K번째수 {
    public static void main(String[] args) {

    }

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int cnt = commands.length;
        int[] answer = new int[cnt];

        for (int count = 0; count < cnt; count++) {


            int[] sliceArray = Arrays.copyOfRange(array, commands[count][0]-1, commands[count][1]);
            Arrays.sort(sliceArray);
            answer[count] = sliceArray[commands[count][2]-1];
        }

        return answer;
    }
}


}