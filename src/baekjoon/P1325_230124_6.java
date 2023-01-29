package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 4는 되는데 이거(6)는 왜 안되지..?
public class P1325_230124_6 {
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
            E[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            // 방문 초기화
            V = new boolean[N+1];
            V[i] = true;
            dfs(i);
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

    static void dfs(int node) {
        for (int n_node : E[node]) {
            if (!V[n_node]) {
                V[n_node] = true;
                answers[n_node]++;
                dfs(n_node);
            }
        }
    }
}
