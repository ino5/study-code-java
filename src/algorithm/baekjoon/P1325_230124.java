package algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class P1325_230124 {
    static int N, M;
    static boolean[][] E;
    static boolean[] V;
    static int ansVal = 1;
    static TreeSet<Answer> answers = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = new boolean[N+1];
        E = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            E[b][a] = true; // b->a (a는 b를 신뢰한다.)
        }

        for (int i = 1; i <= N; i++) {
            int s_node = i; // 시작 노드
            V[s_node] = true;

            dfs(s_node);

            // 정답 넣기
            answers.add(new Answer(s_node, ansVal));
            // 방문 초기화
            for (int v_i = 1; v_i <= N; v_i++) {
                V[v_i] = false;
            }

            // 정답 초기화
            ansVal = 1;
        }

        int idx = -1;
        int max_val = 0;
        StringBuilder sb = new StringBuilder();
        for (Answer item : answers) {
            idx++;
            if (idx == 0) {
                max_val = item.val;
                sb.append(item.no).append(' ');
            } else if (max_val == item.val) {
                sb.append(item.no).append(' ');
            } else {
                continue;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int node) {
        for (int i = 1; i <= N; i++) {
            int n_node = i;
            if (E[node][n_node] && !V[n_node]) {
                V[n_node] = true;
                ansVal++;
                dfs(n_node);
            }
        }
    }

    static class Answer implements Comparable<Answer> {
        int no;
        int val;

        public int compareTo(Answer o) {
            if (this.val != o.val) {
                return -(this.val - o.val);
            } else {
                return this.no - o.no;
            }

        }

        public Answer(int no, int val) {
            this.no = no;
            this.val = val;
        }
    }
}
