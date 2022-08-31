package baekjoon.P2798;

import java.util.Scanner;

/*
백준 2798번 브론즈2
블랙잭
https://www.acmicpc.net/problem/2798
완전탐색
풀이: 220901

피드백:
for문 메서드화 생각해보기.
다른 사람 풀이 참고해보기.
지정한 숫자 배열로 담기 + sum 메서드화(파라미터는 배열로) 생각해보기.

 */
public class Main_220901 {
    static int N, M;
    static int[] numbers;
    static int sum;
    static int minDiff = Integer.MAX_VALUE;
    static int minSum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = numbers[i] + numbers[j] + numbers[k];
                    if (sum <= M) {
                        if (diff(sum) < minDiff) {
                            minDiff = diff(sum);
                            minSum = sum;
                        }
                    }
                }
            }
        }
        System.out.println(minSum);
    }
    public static int diff (int num) {
        return (M - num);
    }
}
