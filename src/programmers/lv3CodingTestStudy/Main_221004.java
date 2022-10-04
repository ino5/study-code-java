package programmers.lv3CodingTestStudy;

import java.util.*;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/118668
정확성은 통과했지만 효율성은 모두 런타임에러
 */
public class Main_221004 {
    static int CNT = 0;
    static Queue<int[]> bfsQue = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;
    static int currentAlp;
    static int currentCop;
    static int goalAlp = Integer.MIN_VALUE;
    static int goalCop = Integer.MIN_VALUE;
    static int[][] g_problems;
    static boolean[][][] checkArr = new boolean[151][151][301];
    public int solution(int alp, int cop, int[][] problems) {
        currentAlp = alp;
        currentCop = cop;
        g_problems = problems;

        // 가능한 시작점 큐에 넣기
        bfsQue.add(new int[]{currentAlp + 1, currentCop, 1}); // alp 증가
        bfsQue.add(new int[]{currentAlp, currentCop + 1, 1}); // cop 증가
        for (int i = 0; i < problems.length; i++) {
            if (currentAlp >= problems[i][0] && currentCop >= problems[i][1]) {
                bfsQue.add(new int[]{currentAlp + problems[i][2], currentCop + problems[i][3], problems[i][4]});
            }

            // goal 설정
            if (goalAlp < problems[i][0]) goalAlp = problems[i][0];
            if (goalCop < problems[i][1]) goalCop = problems[i][1];
        }

        bfs();


        return answer;
    }
    public void bfs() {
        CNT++;
        if (CNT > 20000) return;
        if (bfsQue.size() == 0) return;
        int[] now = bfsQue.peek();
        int nowAlp = now[0];
        int nowCop = now[1];
        int nowCost = now[2];
        // System.out.println(nowAlp + " " + nowCop + " " + nowCost);

        // 이미 처리한 조합이면
        if (checkArr[nowAlp][nowCop][nowCost]) {

        }

        // 현재 정답보다 cost 높은 상태면 종료
        else if (nowCost >= answer) {

        }

        // 모두 충족하면 종료
        else if (nowAlp >= goalAlp && nowCop >= goalCop) {
            if (nowCost <= answer) answer = nowCost;
        }

        // 그렇지 않으면 문제 풀이 수행
        else {
            bfsQue.add(new int[]{nowAlp + 1, nowCop, nowCost + 1}); // alp 증가
            bfsQue.add(new int[]{nowAlp, nowCop + 1, nowCost + 1}); // cop 증가
            for (int i = 0; i < g_problems.length; i++) {
                if (nowAlp >= g_problems[i][0] && nowCop >= g_problems[i][1]) {
                    bfsQue.add(new int[]{nowAlp + g_problems[i][2],
                            nowCop + g_problems[i][3],
                            nowCost + g_problems[i][4]});
                }
            }
        }

        checkArr[nowAlp][nowCop][nowCost] = true;
        bfsQue.poll();
        bfs();
    }
}
