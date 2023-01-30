package algorithm.baekjoon.P2667;

import java.util.*;

/*
단지번호붙이기 실버1
https://www.acmicpc.net/problem/2667

220830 이후 다시 풀어봤다.

 */
public class Main_220901 {
    static int N;
    static Queue<int[]> bfsQue = new LinkedList<>();
    static boolean[][] map;
    static boolean[][] isVisited;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int cnt;
    static List<Integer> cntList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) == '1' ? true : false;
            }
        }
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 시작점 지정
                int[] startPos = new int[] {i, j};

                // 카운트 초기화
                cnt = 0;

                // 시작점 방문하기
                boolean visitResult = visit(startPos);

                // 시작점 이미 방문했거나 방문할 수 없으면 continue
                if(!visitResult) continue;

                // BFS 탐색 시작
                bfs();

                // cnt 등록
                cntList.add(cnt);
            }
        }

        Collections.sort(cntList);
        System.out.println(cntList.size());
        for (int itm : cntList) {
            System.out.println(itm);
        }
    }

    // 방문하기
    public static boolean visit(int[] tPos) {
        int I = tPos[0];
        int J = tPos[1];
        // 위치가 맵 밖이면 false
        if (I >= N || J >= N || I < 0 || J < 0) {
            return false;
        }

        // 이미 방문했으면 false
        else if (isVisited[I][J]) {
            return false;
        }

        // 집이 없으면 false
        else if (!map[I][J]) {
            return false;
        }

        // 방문 가능하면
        else {
            isVisited[I][J] = true;
            bfsQue.add(new int[]{I, J});
            cnt++;
            return true;
        }
    }

    public static void bfs() {
        // 큐에 대기열 없으면 return;
        if (bfsQue.isEmpty()) return;
        
        // 대기열에서 꺼내기
        int[] tPos = bfsQue.peek();
        int I = tPos[0];
        int J = tPos[1];
        
        // 대상의 이웃 방문하기
        for (int i = 0; i < dR.length; i++) {
           visit(new int[] {I + dR[i], J + dC[i]});
        }
        
        // 사용한 대기열 꺼내기
        bfsQue.poll();
        
        // bfs 반복
        bfs();
    }
}
