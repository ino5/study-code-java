package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1325_230124_2 {
    static int N, M;
    static ArrayList<Integer>[] E;
    static boolean[] V;
    static int[] answers = new int [10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        E = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            E[i] = new ArrayList<>();
        }
        // answers = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            E[b].add(a); // b->a (a는 b를 신뢰한다.)
        }

        for (int i = 1; i <= N; i++) {
            // 방문 초기화
            V = new boolean[N+1];

            int s_node = i; // 시작 노드
            V[s_node] = true;

            dfs(s_node, s_node);


        }

        int max_ansVal = 0;
        for (int i = 1; i <= N; i++) {
            if (answers[i] > max_ansVal) {
                max_ansVal = answers[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (answers[i] == max_ansVal) {
                sb.append(i).append(' ');
            }
        }
        bw.write(sb.toString().trim());
        bw.flush();
    }

    static void dfs(int node, int s_node) {
        for (int n_node : E[node]) {
            if (!V[n_node]) {
                V[n_node] = true;
                answers[s_node]++;
                dfs(n_node, s_node);
            }
        }
    }
}
