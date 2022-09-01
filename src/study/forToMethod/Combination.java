package study.forToMethod;

/*
중첩 for문에 대해서 메서드로 만들어 보기

주머니에서 카드 10장 ("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")가 있다.
이 때, 6장 뽑았을 때 나올 수 있는 경우와 경우의 수 출력하기 (순서 고려하지 않음)

 */
public class Combination {
    static int CHOICE_NUMBER = 6; // 한번 시행 시 뽑는 개수
    static int totCnt = 0; // 총 경우의 수
    static String[] pckArr = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; // 주머니
    static String[] choArr = new String[CHOICE_NUMBER]; // 선택한 값 넣은 배열

    public static void main(String[] args) {
        solve(CHOICE_NUMBER, 0, pckArr.length - 1);
        System.out.println("cnt: " + totCnt); // 개수
    }

    public static void solve(int N, int sIdx, int eIdx) {
        // 출력 및 개수 더하기
        if (N == 0) {
            // 출력
            for (int i = 0; i < choArr.length; i++) {
                if (i == 0) System.out.print(choArr[i]);
                else System.out.print(", " + choArr[i]);
            }
            System.out.println();

            // 개수 더하기
            totCnt++;
            return;
        }
        
        // for 문
        for (int i = sIdx; i <= eIdx; i++) {
            int outIdx = CHOICE_NUMBER - N; // 출력배열의 인덱스 (제일 처음 0부터 시작하도록)
            choArr[outIdx] = pckArr[i]; // 출력배열에 값 넣기
            solve(N-1, i + 1, eIdx); // 다음 값 선택하기
        }
    }
}

