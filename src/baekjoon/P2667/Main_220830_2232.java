package baekjoon.P2667;

import java.util.*;

/*
단지번호붙이기 실버1
https://www.acmicpc.net/problem/2667

피드백
- 푸는 데 1시간 15분 정도 걸림 너무 오래 걸림.
- 인풋으로 주어진 문자열 처리 익숙치 않음.
- 큐 사용 익숙치 않음.
- static 사용 안하고 해봤는데 각 메소드가 너무 복잡해짐.
- bfs 제대로 사용 못해서 헤맸음.

해야할 것
- 문제 다시 풀어보기

 */
public class Main_220830_2232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt(); // 맵 길이

        boolean[][] map = new boolean[N][N]; // 맵: 집이 있는지
        boolean[][] isVst = new boolean[N][N]; // 방문했는지 여부
        Queue<int[]> bfsQue = new LinkedList<>(); // bfs 대기열 큐
        List<Integer> cntList = new ArrayList<>(); // cnt 리스트

        // 맵 입력
        for (int i = 0; i < N; i++) {
            String[] intArr = sc.next().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = intArr[j].equals("1") ? true : false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int startI = i;
                int startJ = j;
                int[] pos = new int[] {startI, startJ};
                int cnt = 1;

                if (chkVst(N, pos, isVst)) continue;

                // 시작점 방문
                vst(cnt, pos, N, map, isVst, bfsQue);

                // bfs
                if (!bfsQue.isEmpty()) bfs(cnt, cntList, N, map, isVst, bfsQue);
            }
        }
        Collections.sort(cntList);
        System.out.println(cntList.size());
        for (int item : cntList) {
            System.out.println(item);
        }

    }

    // 방문 처리 하기
    public static boolean vst(int cnt, int[] pos, int N, boolean[][] map, boolean[][] isVst, Queue<int[]> bfsQue) {
        int posI = pos[0];
        int posJ = pos[1];

        if (posI >= N || posJ >= N || posI < 0 || posJ < 0) return false;

        if (!map[posI][posJ]) return false;

        if (!chkVst(N, pos, isVst)) {
            // 방문 처리
            isVst[posI][posJ] = true;
            // System.out.println(posI + " " + posJ);

            // 큐 등록
            bfsQue.add(pos);

            return true;
        } else {
            return false;
        }
    }

    // 방문 여부 체크하기
    public static boolean chkVst(int N, int[] pos, boolean[][] isVst) {
        boolean result = false;
        int posI = pos[0];
        int posJ = pos[1];

        if (posI >= N || posJ >= N || posI < 0 || posJ < 0) { // 범위 벗어나면
            result = false;
        }
        else if (isVst[posI][posJ]) { // 방문했으면
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    // bfs 이웃 탐색
    public static void bfs(int cnt, List<Integer> cntList,int N, boolean[][] map, boolean[][] isVst, Queue<int[]> bfsQue) {
        int[] pos = bfsQue.peek();
        final int posI = pos[0];
        final int posJ = pos[1];
        // System.out.println("posI posJ: " + posI + " " + posJ);

        int posUI = posI - 1;
        int posUJ = posJ;
        int[] posU = new int[] {posUI, posUJ};
        if (vst(cnt, posU, N, map, isVst, bfsQue)) cnt++;

        int posDI = posI + 1;
        int posDJ = posJ;
        int[] posD = new int[] {posDI, posDJ};
        if (vst(cnt, posD, N, map, isVst, bfsQue)) cnt++;

        int posRI = posI;
        int posRJ = posJ + 1;
        int[] posR = new int[] {posRI, posRJ};
        if (vst(cnt, posR, N, map, isVst, bfsQue)) cnt++;

        int posLI = posI;
        int posLJ = posJ - 1;
        int[] posL = new int[] {posLI, posLJ};
        if (vst(cnt, posL, N, map, isVst, bfsQue)) cnt++;

        // 꺼내기
        bfsQue.poll();

        // 큐 남아있으면 bfs 반복
        if(!bfsQue.isEmpty()) {
            bfs(cnt, cntList, N, map, isVst, bfsQue);
        } else {
            cntList.add(cnt);
            // System.out.println("cnt end: " + cnt);
        }
    }
}
