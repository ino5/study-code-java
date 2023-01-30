package algorithm.programmers.lv3CodingTestStudy;

import java.util.LinkedList;
import java.util.Queue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/118668
정확성: 50.0
효율성: 30.0
합계: 80.0 / 100.0
 */
public class Main_221004_2 {
    static Queue<int[]> bfsQue = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;
    static int currentAlp;
    static int currentCop;
    static int goalAlp = Integer.MIN_VALUE;
    static int goalCop = Integer.MIN_VALUE;
    static int[][] g_problems;
    static int[][] checkArr = new int[1000][1000];
    public int solution(int alp, int cop, int[][] problems) {
        currentAlp = alp;
        currentCop = cop;
        g_problems = problems;

        // 가능한 시작점 큐에 넣기
        // bfsQue.add(new int[]{currentAlp + 1, currentCop, 1}); // alp 증가
        addQue(currentAlp + 1, currentCop, 1);
        // bfsQue.add(new int[]{currentAlp, currentCop + 1, 1}); // cop 증가
        addQue(currentAlp, currentCop + 1, 1);
        for (int i = 0; i < problems.length; i++) {
            if (currentAlp >= problems[i][0] && currentCop >= problems[i][1]) {
                // bfsQue.add(new int[]{currentAlp + problems[i][2], currentCop + problems[i][3], problems[i][4]});
                addQue(currentAlp + problems[i][2], currentCop + problems[i][3], problems[i][4]);
            }

            // goal 설정
            if (goalAlp < problems[i][0]) goalAlp = problems[i][0];
            if (goalCop < problems[i][1]) goalCop = problems[i][1];
        }

        bfs();


        return answer;
    }
    public void bfs() {
        if (bfsQue.size() == 0) return;
        int[] now = bfsQue.peek();
        int nowAlp = now[0];
        int nowCop = now[1];
        int nowCost = now[2];
        // System.out.println(nowAlp + " " + nowCop + " " + nowCost);

        // 현재 정답보다 cost 높은 상태면 종료
        if (nowCost >= answer) {

        }

        // 모두 충족하면 종료
        else if (nowAlp >= goalAlp && nowCop >= goalCop) {
            if (nowCost <= answer) answer = nowCost;
        }

        // 그렇지 않으면 문제 풀이 수행
        else {
            addQue(nowAlp + 1, nowCop, nowCost + 1);
            addQue(nowAlp, nowCop + 1, nowCost + 1);
            for (int i = 0; i < g_problems.length; i++) {
                if (nowAlp >= g_problems[i][0] && nowCop >= g_problems[i][1]) {
                    // bfsQue.add(new int[]{nowAlp + g_problems[i][2],
                    //                      nowCop + g_problems[i][3],
                    //                      nowCost + g_problems[i][4]});
                    addQue(nowAlp + g_problems[i][2],
                            nowCop + g_problems[i][3],
                            nowCost + g_problems[i][4]);
                }
            }
        }

        bfsQue.poll();
        bfs();
    }

    public void addQue(int alp, int cop, int cost) {
        // 이미 처리한 조합에 대해 코스트가 이미 이상일 경우
        if (checkArr[alp][cop] > 0 && cost >= checkArr[alp][cop]) {
            return;
        } else {
            checkArr[alp][cop] = cost;
            bfsQue.add(new int[]{alp, cop, cost});
        }
    }
}
