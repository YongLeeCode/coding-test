package exam3;

public class vowelDictionary {
    private static int count = 0;

    public static int solution(String word) {
        int count = words("", word);
        return count;
    }

    private static int words(String curr, String word) {
        if(curr.length() > 5) {
            return 0;
        }

        count++;

        if(word.equals(curr)) {
            System.out.println(curr + " " + count);
            return count;
        }

        for (char c : new char[] {'A', 'E', 'I', 'O', 'U'}) {
            int result = words(curr + c, word);
            if (result > 0) {
                return result; // 정답을 찾은 경우 즉시 반환
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String word = "I";
        int result = solution(word);
        System.out.println(result);
    }
}
