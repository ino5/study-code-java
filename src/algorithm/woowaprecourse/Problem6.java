package algorithm.woowaprecourse;

import java.util.*;

/**
 * https://github.com/woowacourse-precourse/java-onboarding/blob/main/docs/PROBLEM6.md
 */
public class Problem6 {

    /** 체크맵: 값이 true일 경우 해당 문자열은 중복으로 간주된다. */
    private static Map<String, Boolean> g_checkMap = new HashMap<>();

    /** 정답리스트: 닉네임이 중복인 이메일 오른차순 정렬 (이메일 중복 제거) */
    private static List<String> g_answer;
    /** 정답셋: 닉네임이 중복인 이메일 */
    private static Set<String> g_answerSet = new HashSet<>();

    /**
     * solution 메소드
     * @param forms
     * @return
     */
    public static List<String> solution(List<List<String>> forms) {

        // TODO 유효성 체크
            // 이메일 형식
            // 이메일 길이
            // 이메일 도메인
            // 닉네임 한글 유무
            // 닉네임 길이

        // 체크맵 등록
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            putAll(nickname);
        }

        // 중복체크
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String id = forms.get(i).get(1);
            boolean isDuplicated = check(id);
            if (isDuplicated) {
                g_answerSet.add(email);
            }
        }
        g_answer = new ArrayList<String>(g_answerSet);
        Collections.sort(g_answer);

        return g_answer;
    }

    /**
     * 닉네임에 대해 가능한 모든 두글자의 문자열를 파라미터로 하여 put 메소드를 호출한다.
     * @param nickname 닉네임
     */
    private static void putAll(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String str = nickname.substring(i, i+2);
            put(str);
        }
    }

    /**
     * 파라미터로 받은 문자열을 체크맵에 넣는다. 이미 체크맵의 키로 존재하는 문자열이면 값을 true로 그렇지 않으면 false로 넣는다.
     * @param str 문자열
     */
    private static void put(String str) {
        Boolean previousValue = g_checkMap.get(str);
        if (previousValue == null) {
            g_checkMap.put(str, false);
        } else if (previousValue == false) {
            g_checkMap.put(str, true);
        }
    }

    /**
     * 해당 닉네임이 중복인지 체크한다.
     * @param nickname 닉네임
     * @return 중복여부
     */
    private static boolean check(String nickname) {
        boolean result = false;
        for (int i = 0; i < nickname.length() - 1; i++) {
            String str = nickname.substring(i, i+2);
            if(g_checkMap.get(str) != null && g_checkMap.get(str) == true) {
                result = true;
                break;
            }
        }
        return result;
    }
}
