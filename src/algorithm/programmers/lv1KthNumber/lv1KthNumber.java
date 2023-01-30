package algorithm.programmers.lv1KthNumber;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class lv1KthNumber {


    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int ii = commands[i][0] - 1;
                int jj = commands[i][1] - 1;
                int[] newArr = new int[jj-ii+1];
                for (int i2 = ii; i2 <= jj; i2++) {
                    newArr[i2 - ii] = array[i2];
                }
                Arrays.sort(newArr);
                answer[i] = newArr[commands[i][2] - 1];
            }

            return answer;
        }
    }
}
