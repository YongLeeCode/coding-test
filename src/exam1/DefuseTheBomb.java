package exam1;

import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 5;
        int[] result = decrypt(code, k);
        System.out.println(Arrays.toString(result));
    }
    public static int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        int copyK = k;
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                // Sum the next k elements (circular)
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
                result[i] = sum;
            }
        }  else if (k == 0){
            for(int i = 0; i < code.length; i++) {
                result[i] = 0;
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = 1; j <= Math.abs(k); j++) {
                    sum += code[(i - j + code.length) % code.length];
                }
                result[i] = sum;
            }
        }
        return result;
    }
}
// 세가지 상황
// k > 0,  현재 i번째 넘버 제외 다 더하기
    // 첫 번째, for로 다 더하기
// k = 0, 모두 0이 된다.
// k < 0, 현재 i번째 전 숫자들 두개 더하기