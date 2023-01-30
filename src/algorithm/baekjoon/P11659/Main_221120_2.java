package algorithm.baekjoon.P11659;

import java.util.*;

// 221120_1 에서 시간초과 나서 방식 바꿔서 풀이
// 구간 합 구하기 4 (실버3)
// https://www.acmicpc.net/problem/11659
public class Main_221120_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];

        // n번째 인덱스까지의 합 배열 만들기
        int[] sums = new int[N];
        sums[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i-1] + sc.nextInt();
        }

        // 각 구간에 대한 합 구하기
        for (int MIdx = 0; MIdx < M; MIdx++) {
            int sIdx = sc.nextInt() - 1; // 구간 처음 인덱스
            int eIdx = sc.nextInt() - 1; // 구간 끝 인덱스
            int sum = 0;
            if (sIdx == 0) {
                sum = sums[eIdx];
            } else {
                sum = sums[eIdx] - sums[sIdx - 1];
            }
            System.out.println(sum);
        }
    }
}
