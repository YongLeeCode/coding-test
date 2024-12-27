package exam3;

import java.util.Arrays;

public class RecursiveBinaryTran {
    public static int[] solution(String s) {
        int totalZero = 0;
        int round = 1;

        int[] findOneZero = countZero(s.split(""));
        totalZero += findOneZero[1];

        while(findOneZero[0] != 1) {
            findOneZero = countZero(Integer.toBinaryString(findOneZero[0]).split(""));
            totalZero += findOneZero[1];
            round++;
        }
        System.out.println(totalZero+ " " + round);

        return new int[]{round, totalZero};
    }

    public static int[] countZero(String[] nums) {
        int one = 0;
        int zero = 0;

        for(String num : nums) {
            if(num.equals("0")) zero++;
            if(num.equals("1")) one++;
        }
        return new int[]{Integer.parseInt(Integer.toBinaryString(one), 2), zero};
    }
    public static void main(String[] args) {
        String s = "110010101001";
        int[] result = solution(s);
        System.out.println(Arrays.toString(result));
    }
}
