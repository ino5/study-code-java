package algorithm.baekjoon.P11660;

import java.util.*;

public class Main_221128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[][] sumMap = new int[N + 1][N + 1]; // (0,0)부터의 합
        sumMap[1][1] = map[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumMap[i][j] = sumMap[i][j - 1] + sumMap[i - 1][j]
                             - sumMap[i - 1][j - 1] +map[i][j];
            }
        }

        // 정답 구하기
        for (int M_i = 0; M_i < M; M_i++) {
            int a_i = sc.nextInt();
            int a_j = sc.nextInt();
            int b_i = sc.nextInt();
            int b_j = sc.nextInt();
            int answer = sumMap[b_i][b_j]
                       - sumMap[a_i - 1][b_j]
                       - sumMap[b_i][a_j - 1]
                       + sumMap[a_i - 1][a_j - 1];
            System.out.println(answer);
        }
    }
}
