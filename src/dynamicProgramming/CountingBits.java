package dynamicProgramming;

import java.util.Arrays;

public class CountingBits {
//    public static int[] countBits(int n) {
//        int[] answer = new int[n + 1];
//        for(int i = 0; i <= n; i++) {
//            String binary = Integer.toBinaryString(i);
//            answer[i] = (int) Arrays.stream(binary.split("")).filter(d->d.equals("1")).count();
//        }
//
//        return answer;
//    }

    // DP를 활용한 방식
    public static int[] countBits(int n) {
        int[] answer = new int[n + 1];

        // odd = 전단계 숫자
        // even = i / 2
        answer[0] = 0;
        for(int i = 1; i <= n; i++) {
            answer[i] = i % 2 == 1 ? (answer[i - 1] + 1) : answer[i / 2];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] result = countBits(5);
        System.out.println(Arrays.toString(result));
    }
}
