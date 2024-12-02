package recursiveFunction.vowel_dictionary;

public class Vowel_Dictionary {
    public static int solution(String word){
        return find("", word, 1);
    }
    private static int find(String word, String match, int index){
        if(word.equals(match)){
            return index;
        }
        if(word.length() >= 5){
            return -1;
        }

        char[] characters = {'A', 'E', 'I', 'O', 'U'};
        int result = 0;
        for(char c : characters) {
            result = find(word + c, match, index+1);
            if(result != -1) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //모음사전
        String match = "AUAAE";
        int index = solution(match);
        System.out.println(index);
    }
}