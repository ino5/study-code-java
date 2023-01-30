package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10986
// 나머지합
// 골드3
public class P10986_221129 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] nums = new long[N];
        long[] sums = new long[N];
        long[] rcnts = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        sums[0] = nums[0] % M;
        rcnts[Long.valueOf(sums[0]).intValue()]++;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + (nums[i] % M);
            sums[i] %= M;
            rcnts[Long.valueOf(sums[i]).intValue()]++;
        }

        int answer = 0;
        answer += rcnts[0];
        for (int i = 0; i < rcnts.length; i++) {
            if (rcnts[i] > 1) {
                answer += (rcnts[i] * (rcnts[i] - 1)) / 2;
            }
        }
        System.out.println(answer);
    }
}
