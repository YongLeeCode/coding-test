package how_to_use_string.caesar_cipher;

public class CaesarCipher {
    public static String solution(String s, int n) {
        char[] characters = s.toCharArray();
        StringBuilder newWord = new StringBuilder();

        for(char c : characters){
            int transformedChar = c + n;
            if(transformedChar > 'z' && c <= 'z') {
                newWord.append((char) (transformedChar + ('a' - ('z' + 1))));
            } else if (c <= 'Z' && transformedChar > 'Z') {
                newWord.append((char) (transformedChar + ('A' - ('Z' + 1))));
            } else if (c > 'z' || c < 'A') {
                newWord.append(c);
            } else {
                newWord.append((char) (transformedChar));
            }
        }

        return newWord.toString();
    }

    public static void main(String[] args) {
        String answer = solution("z b A Z", 1);
        System.out.println(answer);
    }
}
