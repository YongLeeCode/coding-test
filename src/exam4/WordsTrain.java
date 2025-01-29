package exam4;

import java.util.Arrays;
import java.util.HashSet;

public class WordsTrain {
    // HashSet을 사용해서 이미 사용한 단어인지 확인
    // 만약 사용했다면
    //  그 위치 인덱스 + 1 % n = 어떤 사람이 실수했는지 알 수 있다.
    //  인덱스 + 1 / n을 하면 몇번째 회전에서 실수했는지 알 수 있다.
    public static int[] solution(int n, String[] words) {
        HashSet<String> memorize = new HashSet<>();
        char letter = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if(memorize.contains(words[i]) || words[i].charAt(0) != letter) {
                int person = (i % n) + 1;
                int rotation = (i / n) + 1;
                System.out.println(person + " " + rotation);
                return new int[]{person, rotation};
            }
            letter = words[i].charAt(words[i].length() - 1);
            memorize.add(words[i]);
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = solution(2, words);
        System.out.println(Arrays.toString(result));
    }
}
