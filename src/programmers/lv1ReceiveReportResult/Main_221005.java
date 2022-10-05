package programmers.lv1ReceiveReportResult;

import java.util.*;

/**
 * 신고 결과 받기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class Main_221005 {

    class Solution {
        // 픽 맵 리스트. 인덱스: 신고당한사람, 맵의 값: 신고한사람
        List<Map<String, Boolean>> pickMapList = new ArrayList<>();

        // 인덱스 맵
        Map<String, Integer> indexMap = new HashMap<>();

        // 누적 맵
        Map<String, Integer> accMap = new HashMap<>();

        // 정지 여부 맵
        Map<String, Boolean> banMap = new HashMap<>();

        public int[] solution(String[] id_list, String[] report, int k) {
            for (int i = 0; i < id_list.length; i++) {
                Map<String, Boolean> map = new HashMap<>();
                pickMapList.add(map);
                String id = id_list[i];
                indexMap.put(id, i);
                accMap.put(id, 0);
                banMap.put(id, false);
            }

            // 신고 계산
            for (int i = 0; i < report.length; i++) {
                String[] splitArr= report[i].split(" ");
                String actor = splitArr[0];
                String target = splitArr[1];
                int index = indexMap.get(target);
                Map<String, Boolean> pickMap = pickMapList.get(index);

                // 신고자가 중복 아닐 때만 +1
                if (pickMap.get(actor) == null || !pickMap.get(actor)) {
                    accMap.put(target, accMap.get(target) + 1);
                }

                pickMap.put(actor, true); // 신고자 넣기
            }

            // 정지 계산
            for (int i = 0; i < accMap.size(); i++) {
                String target = id_list[i];
                int accCnt = accMap.get(target);
                if (accCnt >= k) {
                    banMap.put(target, true);
                }
            }

            int[] answer = new int[id_list.length];

            for (int i = 0; i < id_list.length; i++) {
                String target = id_list[i];
                Boolean isBaned = banMap.get(target);
                if (isBaned != null && isBaned) { // 타겟이 밴된 사람이라면
                    Map<String, Boolean> pickMap = pickMapList.get(i);
                    Set<String> keySet = pickMap.keySet();
                    for (String actor : keySet) {
                        if (pickMap.get(actor)) { // 타겟을 신고한 사람이라면
                            answer[indexMap.get(actor)] += 1;
                        }
                    }
                }
            }

            return answer;
        }
    }
}
