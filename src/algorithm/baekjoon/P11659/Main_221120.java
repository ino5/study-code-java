package algorithm.baekjoon.P11659;

import java.util.*;

// 시간초과 발생
public class Main_221120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];

        // 숫자 배열 만들기
        for (int NIdx = 0; NIdx < N; NIdx++) {
            numbers[NIdx] = sc.nextInt();
        }

        // 각 구간에 대한 합 구하기
        for (int MIdx = 0; MIdx < M; MIdx++) {
            int sIdx = sc.nextInt() - 1; // 구간 처음 인덱스
            int eIdx = sc.nextInt() - 1; // 구간 끝 인덱스
            int sum = 0;
            for (int sumIdx = sIdx; sumIdx <= eIdx; sumIdx++) {
                sum += numbers[sumIdx];
            }
            System.out.println(sum);
        }
    }
}
