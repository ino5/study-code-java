package programmers.P43165;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165#
 * lv 2 타겟 넘버
 * DFS로 풀어보았다.
 */
public class Main_221123 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(answer);
    }
}

class Solution {
    static int[] g_numbers;
    static int g_target, g_answer;
    static Stack<int[]> g_stack = new Stack<>();
    static int[] g_sign = new int[] {-1, 1};
    static boolean[][] g_isVisited;
    public int solution(int[] numbers, int target) {
        g_numbers = numbers;
        g_target = target;

        // 가능한 시작지점마다 시작
        for (int i_starting = 0; i_starting < g_sign.length; i_starting++) {
            // 초기화
            g_isVisited = new boolean[numbers.length][g_sign.length];

            // 시작지점 방문하기
            visit(0, i_starting, 0);

            // dfs
            dfs();
        }

        int answer = g_answer;
        return answer;
    }

    // 방문하기
    public void visit(int depth, int index, int curSum) {
        // 방문 처리
        g_isVisited[depth][index] = true;

        // 새로운 합 계산
        int newSum = curSum + g_sign[index] * g_numbers[depth];

        // 스택에 넣기
        g_stack.push(new int[] {depth, newSum});
    }

    // dfs
    public void dfs() {
        if (g_stack.size() == 0) {
            return;
        }

        int[] popedArr = g_stack.pop();
        int depth = popedArr[0] + 1;
        int curSum = popedArr[1];

        if (depth == g_numbers.length) {
            if (curSum == g_target) {
                g_answer++;
            }
            return;
        }

        for (int i = 0; i < g_sign.length; i++) {
            visit(depth, i, curSum);
            dfs();
        }
    }
}