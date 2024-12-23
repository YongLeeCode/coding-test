package exam3;

import java.util.Arrays;

public class MaxAndMin {
    public static String solution(String s) {
        String[] str = s.split(" ");
        int[] numbers = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbers).min().getAsInt() + " " + Arrays.stream(numbers).max().getAsInt();
    }
    public static void main(String[] args) {
        String s = "1 2 3 4";
        String result = solution(s);
        System.out.println(result);
    }
}
