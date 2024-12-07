package hash.duplicated_letters;

import java.util.HashSet;

public class DuplicatedLetters {

    public static String solution(String my_string) {
        HashSet<String> set = new HashSet<>();
        String[] strArr = my_string.split("");
        String result = "";

        for (String s : strArr) {
            if (!set.contains(s)) {
                set.add(s);
                result += s;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String my_string = "We are the world";
        String result = solution(my_string);
        System.out.println(result);
    }
}
