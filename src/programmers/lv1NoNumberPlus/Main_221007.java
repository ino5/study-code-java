package programmers.lv1NoNumberPlus;

import java.util.*;

public class Main_221007 {
    class Solution {
        public int solution(int[] numbers) {
            int initial = 45;
            for (int i = 0; i < numbers.length; i++) {
                initial -= numbers[i];
            }
            return initial;
        }
    }
}
