package how_to_sort.h_index;

import java.util.Arrays;

public class HIndex {

//    public static int solution(int[] citations) {
//        Arrays.sort(citations);
//        if (citations.length % 2 == 0) {
//            return (citations[citations.length / 2 - 1] + citations[citations.length / 2]) / 2;
//        } else {
//            return citations[citations.length / 2];
//        }
//    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        for (int h = citations.length; h >= 1; h--) {
            if (isValid(h, citations)) {
                return h;
            }
        }
        return 0;
    }

    private static boolean isValid(int h, int[] citations) {
        return citations[citations.length - h] >= h;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 0, 6, 1, 5};
        int result = solution(numbers);
        System.out.println(result);
    }
}
